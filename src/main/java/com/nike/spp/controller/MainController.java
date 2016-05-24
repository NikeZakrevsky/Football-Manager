package com.nike.spp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nike.spp.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nike.spp.dao.DAO;

@Controller
public class MainController {

	@Autowired
	private DAO itemMasterDao;

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		itemMasterDao.removeStadium(id);
		return "redirect:/adminPage";
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ModelAndView signIn(@ModelAttribute("user") User user) {
		User currentUser = null;
		List<User> userList = itemMasterDao.getUserList();
		for (User userItem : userList) {
			System.out.println(userItem.getLogin());
			if (userItem.getLogin().equals(user.getLogin()) && userItem.getPassword().equals(user.getPassword())) {
				itemMasterDao.setCurrentUser(userItem);
				if (itemMasterDao.getRole(userItem).equals("user"))
					return new ModelAndView("redirect:/index.do");
				else return new ModelAndView("redirect:/adminPage");
			}
		}
		return new ModelAndView("login");
	}

	@RequestMapping(value = "teams.pdf", method = RequestMethod.GET)
	ModelAndView generatePdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("pdfView", "command", itemMasterDao.getTeams());
		return modelAndView;
	}

	@RequestMapping(value = "teams.csv", method = RequestMethod.GET)
	ModelAndView generateCsv(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("csvView", "csvTeams", itemMasterDao.getTeams());
		return modelAndView;
	}

	@RequestMapping(value = "teams.xls", method = RequestMethod.GET)
	ModelAndView generateExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("excelView", "teams", itemMasterDao.getTeams());
		return modelAndView;
	}

	@RequestMapping(value = "stadiums.pdf", method = RequestMethod.GET)
	ModelAndView generatePdfStadium(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("pdfView", "stadiums", itemMasterDao.getStadiums());
		return modelAndView;
	}

	@RequestMapping(value = "stadiums.csv", method = RequestMethod.GET)
	ModelAndView generateCsvStadium(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("csvView", "stadiums", itemMasterDao.getStadiums());
		return modelAndView;
	}

	@RequestMapping(value = "stadiums.xls", method = RequestMethod.GET)
	ModelAndView generateExcelStadium(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("excelView", "stadiums", itemMasterDao.getStadiums());
		return modelAndView;
	}

	@RequestMapping(value = "match.pdf", method = RequestMethod.GET)
	ModelAndView generatePdfMatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("matchpdfView", "command", itemMasterDao.getMatches());
		return modelAndView;
	}

	@RequestMapping(value = "match.csv", method = RequestMethod.GET)
	ModelAndView generateCsvMatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("matchcsvView", "matches", itemMasterDao.getMatches());
		return modelAndView;
	}

	@RequestMapping(value = "match.xls", method = RequestMethod.GET)
	ModelAndView generateExcelMatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");
		ModelAndView modelAndView = new ModelAndView("matchexcelView", "matches", itemMasterDao.getMatches());
		return modelAndView;
	}

	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/adminPage")
	public ModelAndView adminPage() {
		if(itemMasterDao.getCurrentUser().getRole().getName().equals("admin")) {
			ModelAndView model = new ModelAndView("adminPage");
			model.addObject("stadiums", itemMasterDao.getStadiums());
			return model;
		}
		else { return new ModelAndView("index"); }
	}

	@RequestMapping(value = "/profile")
	public ModelAndView profile() {
		ModelAndView model = new ModelAndView("profile");
		model.addObject("lists", itemMasterDao.getCurrentTeamsList());
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
		model.addObject("lists", itemMasterDao.getMatches());
		for (Match match : itemMasterDao.getMatches()) {
			System.out.println(match.getTeam1Name());
		}
		return model;
	}

	@RequestMapping(value = "/saveStadiumAdmin", method = RequestMethod.POST)
	public ModelAndView saveTeamAdmin(@ModelAttribute("stadium") Stadium stadium) {
		itemMasterDao.addStadium(stadium);
		System.out.println(stadium.getName());
		return new ModelAndView("redirect:/adminPage");
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
