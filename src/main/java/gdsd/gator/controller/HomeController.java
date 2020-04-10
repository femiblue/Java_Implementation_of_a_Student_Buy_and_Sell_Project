package gdsd.gator.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gdsd.gator.model.Users;
import gdsd.gator.service.ItemService;
import gdsd.gator.model.Items;

import gdsd.gator.model.Items;
import gdsd.gator.service.ItemService;

@Controller
public class HomeController {
	
	//use the item service create different item lists for display
	private ItemService itemService;
	@Autowired
	public void setItemService(ItemService itemService){
	    this.itemService=itemService;
	}

	@SuppressWarnings("null")
	@RequestMapping(value="/")
	public String home(Users User,  Model model,  HttpServletRequest request, HttpSession session) {		
		
		//define item array
		List<Items> itemArr;
		List<Items> latest_items;
		List<Items> bestDealsArr;
		List<Items> bestdeals_items;
		List<Items> bestDealsCatArr;
		List<Items> bestdeals_cat_items;
		List<Items> topnew_items;
		
		//int list_counter = 0;
		//Get All Items
		itemArr = this.itemService.getLatestItems(8); //limit not working with this, use crude method and find better way latter
		//System.out.println(Arrays.deepToString(itemArr.toArray()));
		//get out the first 8
		if(itemArr.size() > 7) {
			latest_items = itemArr.subList(0, 8);
		}else {
			latest_items = itemArr;
		}
		System.out.println(latest_items.size());
		System.out.println(Arrays.deepToString(latest_items.toArray()));
	    model.addAttribute("latest_items", latest_items);
	    
	    //best deals by price
	    bestDealsArr = this.itemService.getBestDeals(); 
	    //get out the first 4
  		if(bestDealsArr.size() > 3) {
  			bestdeals_items = bestDealsArr.subList(0, 4);
  		}else {
  			bestdeals_items = bestDealsArr;
  		}
  		model.addAttribute("bestdeals_items", bestdeals_items);
  		
  	    //best deals by price, category
	    bestDealsCatArr = this.itemService.getBestDealsCat(); 
	    //get out the first 4
  		if(bestDealsCatArr.size() > 3) {
  			bestdeals_cat_items = bestDealsCatArr.subList(0, 4);
  		}else {
  			bestdeals_cat_items = bestDealsCatArr;
  		}
  		model.addAttribute("bestdeals_cat_items", bestdeals_cat_items);
  		
  		//get out the first 4 for the Top New
		if(itemArr.size() > 4) {
			topnew_items = itemArr.subList(0, 4);
		}else {
			topnew_items = itemArr;
		}
		model.addAttribute("topnew_items", topnew_items);
	    
		//Check if user is logged in and pick user detail
		model.addAttribute("user_det", "");
		if(session.getAttribute("userArr") != null && session.getAttribute("userArr") != "") {
			List <Users> user_det = (List<Users>) session.getAttribute("userArr");
			System.out.println("\n\n\n....Before Home page display");
			System.out.println(Arrays.deepToString(user_det.toArray()));
			System.out.println("\n\n\n....");
			System.out.println(user_det.get(0).getName());
			model.addAttribute("user_det", user_det.get(0));
		}
		return "index";
	}
	
	@RequestMapping(value="/dashboard")
	public String dashboard(Users User, Model model,  HttpServletRequest request, HttpSession session) {
		
		model.addAttribute("user_det", "");
		if(session.getAttribute("userArr") != null && session.getAttribute("userArr") != "") {
			List <Users> user_det = (List<Users>) session.getAttribute("userArr");
			System.out.println("\n\n\n....Before Home page display");
			System.out.println(Arrays.deepToString(user_det.toArray()));
			System.out.println("\n\n\n....");
			System.out.println(user_det.get(0).getName());
			model.addAttribute("user_det", user_det.get(0));
			
			return "dashboard";
		}else {
			//if user is not logged in
			//return "login";
			model.addAttribute("", "");
			return "redirect:user/login";
		}
		
	}
}
