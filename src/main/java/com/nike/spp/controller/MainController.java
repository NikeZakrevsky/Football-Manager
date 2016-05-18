package com.nike.spp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nike.spp.dao.DAO;
import com.nike.spp.dto.Match;
import com.nike.spp.dto.Player;
import com.nike.spp.dto.Team;
import com.nike.spp.dto.User;

@Controller
public class MainController {

	@Autowired
	private DAO itemMasterDao;

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ModelAndView signIn(@ModelAttribute("user") User user) {
		List<User> userList = itemMasterDao.getUserList();
		for (User userItem : userList) {
			if (userItem.getLogin().equals(user.getLogin()) && userItem.getPassword().equals(user.getPassword())) {
				itemMasterDao.setCurrentUser(userItem);
				return new ModelAndView("redirect:/index.do");
			}
		}
		return new ModelAndView("regLogPage");
	}

	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("regLogPage");
		return model;
	}

	@RequestMapping(value = "/teams")
	public ModelAndView team() {
		ModelAndView model = new ModelAndView("teams");
		model.addObject("lists", itemMasterDao.getTeams());
		model.addObject("listsCurrent", itemMasterDao.getCurrentTeamsList());
		return model;
	}

	@RequestMapping(value = "/stadiums")
	public ModelAndView stadium() {
		ModelAndView model = new ModelAndView("stadiums");
		model.addObject("lists", itemMasterDao.getStadiums());

		return model;
	}

	@RequestMapping(value = "/teamAdd")
	public ModelAndView teamAdd() {
		ModelAndView model = new ModelAndView("teamAdd");
		for (Team team : itemMasterDao.getTeams()) {
			System.out.println(team.getName());
		}
		model.addObject(itemMasterDao.getTeams());
		return model;
	}

	@RequestMapping(value = "/matchAdd")
	public ModelAndView matchAdd() {
		ModelAndView model = new ModelAndView("matchAdd");
		model.addObject("lists1", itemMasterDao.getStadiums());
		model.addObject("lists", itemMasterDao.getTeams());
		return model;
	}

	@RequestMapping(value = "/playerAdd")
	public ModelAndView playerAdd() {
		ModelAndView model = new ModelAndView("playerAdd");
		for (Team team : itemMasterDao.getTeams()) {
			System.out.println(team.getName());
		}
		model.addObject("lists", itemMasterDao.getCurrentTeamsList());
		return model;
	}

	@RequestMapping(value = "/stadiumAdd")
	public ModelAndView stadiumAdd() {
		ModelAndView model = new ModelAndView("stadiumAdd");
		return model;
	}

	@RequestMapping(value = "/matches")
	public ModelAndView matches() {
		ModelAndView model = new ModelAndView("matches");
		model.addObject("lists",itemMasterDao.getMatches());
		return model;
	}

	@RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
	public ModelAndView saveTeam(@ModelAttribute("team") Team team) {
		itemMasterDao.addTeam(team);
		System.out.println(team.getName());
		return new ModelAndView("teamAdd");
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		itemMasterDao.addUser(user);
		return new ModelAndView("redirect:/index.do");
	}

	@RequestMapping(value = "/savePlayer", method = RequestMethod.POST)
	public ModelAndView savePlayer(@ModelAttribute("employee") Player player, BindingResult result) {
		itemMasterDao.savePlayer(player);
		return new ModelAndView("playerAdd");
	}

	@RequestMapping(value = "/saveMatch", method = RequestMethod.POST)
	public ModelAndView saveMatch(@ModelAttribute("employee") Match match, BindingResult result) {
		itemMasterDao.addMatch(match);
		return new ModelAndView("matchAdd");
	}
}
