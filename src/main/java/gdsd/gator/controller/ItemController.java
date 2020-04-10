package gdsd.gator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;

import gdsd.gator.model.Items;
import gdsd.gator.service.ItemService;

import gdsd.gator.model.Seller;
import gdsd.gator.service.SellerService;

import gdsd.gator.model.Users;
import gdsd.gator.service.UsersService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	
	private ItemService itemService;
	private SellerService sellerService;
	private UsersService usersService;
	
	@Autowired
	public void setItemService(ItemService itemService){
	    this.itemService=itemService;
	}
	
	@RequestMapping(value="/list")
	public String itemlist(Model model) {
		
		List<Items> itemArr;
		//Get Latest Item
		itemArr = this.itemService.getItems();
	    System.out.println(Arrays.deepToString(itemArr.toArray()));
	    
	    model.addAttribute("ItemArr", itemArr);
        
		return "itemlist";
	}
	
	@RequestMapping(value="/sell")
	public String itemsell(Model model) {
        
		return "itemsell";
	}
	
	@PostMapping(value="/sell/create")
	public String itemsellcreate(Model model) {
        
		return "dashboard";
	}
	
	@RequestMapping(value="/show/{id}")
	public String item(Model model, HttpServletRequest request, HttpSession session, Items Item, Seller Seller) {
		
		//
		Items itemArr;
		int item_id = Item.getId();
		//System.out.println(item_id);
		//Get Single Item detail
		itemArr =  this.itemService.getItem(item_id);
	    System.out.println((itemArr));
	    
	    model.addAttribute("item", itemArr);
	    
	    //get items to display by the side
	    List<Items> sideItemsArr;
	    List<Items> side_items;
	    //latest items
	    sideItemsArr = this.itemService.getLatestItems(8); 
	    //get out the first 4
  		if(sideItemsArr.size() > 3) {
  			side_items = sideItemsArr.subList(0, 4);
  		}else {
  			side_items = sideItemsArr;
  		}
  		model.addAttribute("side_items", side_items);
  		
  		//get item seller, 
  		List <Seller> sellerArr;	
  		Users  itemUser;
  		System.out.println((itemArr.getId()));
  		sellerArr =  this.sellerService.getSellerByItem(itemArr.getId());
  		//itemUser =  this.usersService.getUser(sellerArr.get(0).getUserId());
  		System.out.println((sellerArr));
  		//model.addAttribute("item_user", itemUser);
        
		return "item";
	}

}
