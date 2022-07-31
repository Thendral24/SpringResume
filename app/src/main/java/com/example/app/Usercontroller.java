package com.example.app;


// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class Usercontroller {

   
    @Autowired
    UserRepo repo;
    @Autowired
    contactRepo contactRepo;

    @RequestMapping("/all")
    @ResponseBody
    public ModelAndView indexpage() {
        UserResume resume= repo.findByUserId(1);
        contact con = contactRepo.findByContactId(1);
        
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("resume",resume);
        mav.addObject("con",con);
        String[] academichistory = resume.getAcademichistory().split(":");
        mav.addObject("ac",academichistory);
        
        String[] skills = resume.getMyskills().split(":");
        mav.addObject("sk",skills);
        String[] language = resume.getLanguagesknown().split(",");
        mav.addObject("la",language);
        String[] inplant = resume.getWorkshop().split(":");
        mav.addObject("in",inplant);
        String[] certification = resume.getCertification().split(":");
        mav.addObject("ce",certification);

        return mav;
      

    }

    @GetMapping("/test")
	
	public String testAPI() {
		
	  	return "Server up and Running";
	  }

     @GetMapping("/getUserDetails")
	 public UserResume getUserDetails() {
		UserResume user=new UserResume();

       
        return user;

        
}
    
    // @GetMapping("/getContactDetails")
    // public contact getContactDetails() {
    //     contact con = new contact();
    //     return con;
    // }

    @PostMapping("/update")
    public RedirectView contactSubmit(contact con, Model model) {
        // model.addAttribute("con", con);
        contact concurrent = contactRepo.findByContactId(1);
        concurrent.setEmail(con.getEmail());
        concurrent.setPhoneNumber(con.getPhoneNumber());
        concurrent.setAddress(con.getAddress());
        contactRepo.save(concurrent);
        
        return new RedirectView("/all");
    //    return concurrent;
    }

    // @GetMapping("/con")
    // public String contactForm(Model model) {
    //   model.addAttribute("con",new contact());
    //   return "con";
    // }

    
    
}
