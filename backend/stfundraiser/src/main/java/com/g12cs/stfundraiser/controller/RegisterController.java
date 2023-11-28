package com.g12cs.stfundraiser.controller;

import com.g12cs.stfundraiser.models.User;
import com.g12cs.stfundraiser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Controller

//@RequestMapping(path="/stfundraiser")

public class RegisterController {

    // Post mapping used through thymeleaf to submit the user registration data through a
    // thymleaf template
    @Autowired
    private UserService service;

    @GetMapping("/register")


    public String Registration(Model model){
        model.addAttribute("user", new User());

        return "Registration Page/Registrationpage";
        //This is resolved to resources/templates/Registrationpage.html

    }
    @PostMapping("/register")
    public String submitRegistration(@ModelAttribute("user") User user, ModelMap model){
        //form data stored in user, can add more attributes to Model for more data input
        //
        //This directly connects to MySQL database amd checks whether user is already registered
        //with current data
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://address/helping_hand", "un", "pw");
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM users WHERE email='" + user.getEmail() + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            if(rs.next()) {
                return "Registration Page/AlreadyRegistered";
            }
        }
        catch (Exception e)
        {
            return("Error: " + e.getMessage());
        }

        System.out.println("Registered, entering into DB");
        //Easily save/register the user using the userService class by submitting user template
        //Note that userservice is more of a controller that actually uses User repository to write/fetch data from DB

        service.save(user);
        //Confirmation for registration
        return "Registration Page/sampleregistration";
    }
}
