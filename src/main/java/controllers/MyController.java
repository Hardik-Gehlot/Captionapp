package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import model.Caption;
import model.Category;
import model.User;
import services.UserServices;

@Controller
public class MyController {
	@Autowired
	private UserServices userServices;
	@RequestMapping({"/","dashboard"})
	public String index(HttpSession s,Model m) {
		m.addAttribute("categories", this.userServices.getCategories());
		m.addAttribute("captions", this.userServices.getCaptions("Nature","English",1));
		m.addAttribute("title","Nature");
		m.addAttribute("currentPage",1);
		m.addAttribute("category","Nature");
		m.addAttribute("lang","English");
		m.addAttribute("nextLang","Hindi");
		
		// TODO: filter
		
		int r = this.userServices.getTotalNumberOfCaptions("Nature", "English");
		int page=1;
		if(r%15==0) {
			page = r/15;
		}else {
			page = (r/15)+1;
		}
		m.addAttribute("lastPage",page);
		return "index";
	}
	@RequestMapping("caption")
	public String getCaptions(Model m,HttpServletRequest request) {
		String category = request.getParameter("category");
		String lang = request.getParameter("lang");
		int page = Integer.parseInt(request.getParameter("p"));
		List<Caption> captions = this.userServices.getCaptions(category,lang,page);
		List<Category> categories = this.userServices.getCategories();
		m.addAttribute("categories", categories);
		m.addAttribute("captions", captions);
		m.addAttribute("title",category);
		m.addAttribute("currentPage",page);
		m.addAttribute("category",category);
		m.addAttribute("lang",lang);
		String nextLang = "Hindi";
		if(lang.equalsIgnoreCase("English")) {
			nextLang = "Hindi";
		}else {
			nextLang = "English";
		}
		m.addAttribute("nextLang", nextLang);
		int r = this.userServices.getTotalNumberOfCaptions(category, lang);
		int totalpage=1;
		if(r%15==0) {
			totalpage = r/15;
		}else {
			totalpage = (r/15)+1;
		}
		m.addAttribute("lastPage",totalpage);
		return "index";
	}
	@RequestMapping("/add_caption")
	public String add_caption(Model m,HttpSession s) {
		if(s.getAttribute("user") == null) {
			return "redirect:login";
		}
		List<Category> categories = this.userServices.getCategories();
		m.addAttribute("categories", categories);
		return "addCaption";
	}
	@RequestMapping(path = "/processCaption", method = RequestMethod.POST)
	public String addCaption(@ModelAttribute Caption caption, HttpSession s) {
		User user = (User) s.getAttribute("user");
		caption.setUid(user.getUid());
		int r = this.userServices.saveCaption(caption);
		if(r>0) {
			return "redirect:dashboard";
		}
		return "redirect:add_caption";
	}
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession s) {
		s.removeAttribute("user");
		return "redirect:dashboard";
	}
	@RequestMapping(path = "/processSignup", method = RequestMethod.POST)
	public String processSignup(@ModelAttribute User u, @RequestParam("pimg") CommonsMultipartFile file,HttpSession s) {
		byte[] data = file.getBytes();
		String path = s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"img"+File.separator+ System.currentTimeMillis() + file.getOriginalFilename();
		try{
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		u.setProfile(path);
		userServices.saveUser(u);
		return "index";
	}
	
	@RequestMapping(path = "/processLogin", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute User u,HttpSession session) {
		User user = this.userServices.getUser(u.getUsername(),u.getPassword());
		if(user!=null) {
			session.setAttribute("user", user);
			return "redirect:dashboard";
		}
		return "redirect:login";
	}
	@RequestMapping("/search")
	public String search(HttpServletRequest request,Model m) {
		String s =  (String) request.getParameter("q");
		
		int p,r;
		if(s!=null) {
			p =  Integer.parseInt(request.getParameter("p"));
		}else {
			s="";
			p=1;
		}
		r = this.userServices.getTotalNumberOfSearchCaptions(s);
			int totalpage=1;
			if(r%15==0) {
				totalpage = r/15;
			}else {
				totalpage = (r/15)+1;
			}
			m.addAttribute("lastPage",totalpage);
			m.addAttribute("currentPage",p);
			m.addAttribute("searchString", s);
			m.addAttribute("users",this.userServices.searchUsers(s));
			m.addAttribute("captions",this.userServices.searCaptions(s,p));
		return "search";
	}
	@RequestMapping("/profile")
	public String profile(Model m, HttpSession s,HttpServletRequest request) {
		if(s.getAttribute("user") == null) {
			return "redirect:login";
		}
		String reqPa = request.getParameter("p");
		int p;
		p = (reqPa!=null)?(Integer.parseInt(reqPa)):1;
		User user = (User) s.getAttribute("user");
		m.addAttribute("user", user);
		int r = this.userServices.getNumberOfPostsOfUser(user.getUid());
		m.addAttribute("posts",r);
		m.addAttribute("postsYouLiked", this.userServices.getNumberOfPostsLikedByUser(user.getUid()));
		m.addAttribute("currentPage",p);
		m.addAttribute("captions", this.userServices.getCaptionOfUser(user.getUid(), p));
		
		int page=1;
		if(r%15==0) {
			page = r/15;
		}else {
			page = (r/15)+1;
		}
		m.addAttribute("lastPage",page);
		return "profile";
	}
}
