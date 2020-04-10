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
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;

import gdsd.gator.model.Users;
import gdsd.gator.service.UsersService;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
    private UsersService usersService;
	
	private String Username;
	private String Password;
	
	/**
     * Create new Users object for empty from
     * 
     * @return
     */
	@ModelAttribute("Users")
    public Users setUsers() {
        return new Users();
    }
	
	//User sign up form display
	@RequestMapping(value="/register")
	public String regsiter(Model model) {
		
    	model.addAttribute("Users", new Users());
    	
		return "register";
	}
	
	/**
     * Save User sign up form
     * 
     * @param User
     * @param model
     * @return
     */
    @PostMapping("/create")
    public String saveUser(@ModelAttribute("Users") Users User, Model model) {

        // Implement business logic to save user details into a database
        // .....
    	model.addAttribute("display_msg_success", true);
    	model.addAttribute("message", "You successfully signed up. Please login to continue");
        model.addAttribute("user", User);
        usersService.saveUser(User);

        return "login";
    }
    
	//display login page
	@RequestMapping(value="/login")
	public String login(Model model) {
        
		model.addAttribute("display_msg_success", false);
		model.addAttribute("display_msg_err", false);
		return "login";
	}
	
	//process login attempt
	@PostMapping("/login/check")
	public String login_check(@ModelAttribute("Users") Users User, Model model, HttpServletRequest request, HttpSession session) {
        
		System.out.println("Username : " + User.getUsername());
		System.out.println("Password : " + User.getPassword());
		
		List <Users> userArr;
		boolean userFound;
		String nextUrl = "login";
		this.Username = User.getUsername();
		this.Password = User.getPassword();
		
		//perform check
		userArr = usersService.checkLogin(this.Username, this.Password);
		System.out.println(Arrays.deepToString(userArr.toArray()));
		//check if return list is empty
		if ((userArr != null) && (userArr.size() > 0)) {
			//if not empty, set userFound to true
			userFound= true;
			//set user details to session
			session.setAttribute("userArr", userArr);
			//List <Users> user_det = (List<Users>) session.getAttribute("userArr");
			
			//set error msg to false
			//model.addAttribute("display_msg_err", false);
			return "redirect:../../";
			
		}else {
			//if list is empty, set userFound to false
			userFound= false;
			model.addAttribute("display_msg_err", true);
			model.addAttribute("message", "Unable to sign in. Please check your user details");
			return "login";
		}
		
		//return nextUrl;
	}
	
	//process logout
	@RequestMapping(value="/logout")
	public String logout(Model model, HttpSession session) {
        //end session
		session.invalidate(); 
		model.addAttribute("display_msg_success", true);
		model.addAttribute("message", "You successfully logged out!");
		return "login";
	}
	
	

}
