package com.g12cs.stfundraiser.controller;

import com.g12cs.stfundraiser.models.User;
import com.g12cs.stfundraiser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@Controller
public class StaticsController {

    @RequestMapping(value = {"/", "/home"})
    public String showHomePage(Model model){
    //    model.addAttribute("user", new User());
        return "../static/Home Page/index";
    }

    @RequestMapping("/about")
    public String showAboutPage(Model model){
        //    model.addAttribute("user", new User());static
        return "About us page/Aboutuspage";
    }

    @RequestMapping("/causes")
    public String showCausesPage(Model model){
        //    model.addAttribute("user", new User());
        return "LatestCauses/latestcauses";
    }

    @RequestMapping("/donate")
    public String showDonationPage(Model model){
        //    model.addAttribute("user", new User());
        return "Donation/donate";
    }
}