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
public class LoginController {

    private static boolean loggedIn = false;

    public static boolean isLoggedIn() { return loggedIn; }

    @RequestMapping("/userLogin")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        if(loggedIn == true) return "Login Page/LoggedIn";
        else return "Login Page/Loginpage";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") User user, Model model) {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://address/helping_hand", "un", "pw");
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM users WHERE email='" + user.getEmail() + "' AND password='" + user.getPassword() + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            if(rs.next()) {
                loggedIn = true;
                return "Profile Page/profile";
            }
            else {
                try
                {
//                    Connection con1 = DriverManager.getConnection("jdbc:mysql://address/helping_hand", "un", "pw");
                    Statement stmt1 = con.createStatement();
                    String SQL1 = "SELECT * FROM users WHERE email='" + user.getEmail() + "'";
                    ResultSet rs1 = stmt1.executeQuery(SQL1);
                    if(!rs1.next()) {
                        model.addAttribute("notUser", "notUser");
                        return "Login Page/Loginpage";
                    }
                }
                catch (Exception e)
                {
                    return("Error: " + e.getMessage());
                }
                model.addAttribute("logError", "logError");
                return "Login Page/Loginpage";
            }
        }
        catch (Exception e)
        {
            return("Error: " + e.getMessage());
        }
    }

}
