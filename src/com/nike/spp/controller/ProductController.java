package com.nike.spp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nike.spp.dao.ItemMasterDAO;

@Controller
public class ProductController {
	
	@Autowired
	private ItemMasterDAO itemMasterDao; 
	
	  /*@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("item") ItemMaster item) {
        System.out.println(item.getItem_name());
        if(null != item ) 
        	itemMasterDao.add(item);
         
        ModelAndView model = new ModelAndView("ItemMasterAdd");
		item=new ItemMaster();
        model.addObject("item", item);
        List<ItemMaster> itemList = itemMasterDao.list();
        model.addObject("itemList", itemList);
        return model;
  }*/
	
	
	@RequestMapping(value = "/save")
    public void save() {
        	itemMasterDao.add();
  }
	
	  /*@RequestMapping(value="/list")
	    public ModelAndView list() {
	        List<ItemMaster> itemList = itemMasterDao.list();
	        ModelAndView model = new ModelAndView("ItemMasterList");
	        model.addObject("itemList", itemList);
	        return model;
	    }

	  @RequestMapping(value="/loadAddForm")
	    public ModelAndView add() {
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
		   ItemMaster item=new ItemMaster();
           model.addObject("item", item);
	        List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }
	  
	  @RequestMapping(value="/edit")
	    public ModelAndView edit(@RequestParam(value="id", required=true) Long id) {
		  System.out.println("Id= " + id);
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
		   ItemMaster item=  itemMasterDao.getItem(id);
           model.addObject("item", item);
	       List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }*/
	
	
	/*  @RequestMapping(value="/delete")
	    public ModelAndView delete(@RequestParam(value="id", required=true) Long id) {
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
	        itemMasterDao.delete(id);
	       List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }*/
	
	  

	  /*@RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ModelAndView save(@ModelAttribute("item") ItemMaster item) {
	        System.out.println(item.getItem_name());
	        if(null != item ) 
	        	itemMasterDao.add(item);
	         
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
			item=new ItemMaster();
	        model.addObject("item", item);
	        List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	  }*/
	  
	  /*@RequestMapping(value = "/update", method = RequestMethod.POST)
	    public ModelAndView update(@ModelAttribute("item") ItemMaster item) {
	        System.out.println(item.getItem_name());
	        if(null != item ) 
	        	itemMasterDao.update(item);
	         
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
			item=new ItemMaster();
	        model.addObject("item", item);
	        List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	  }
	  */

}


