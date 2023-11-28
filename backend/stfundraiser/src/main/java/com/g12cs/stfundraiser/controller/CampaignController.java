/*package com.g12cs.stfundraiser.controller;

import com.g12cs.stfundraiser.models.Campaign;
import com.g12cs.stfundraiser.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    private CampaignService service;

    @PostMapping("/addCampaign")
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        return service.saveCampaign(campaign);
    }

    @PostMapping("/addCampaigns")
    public List<Campaign> addCampaigns(@RequestBody List<Campaign> campaigns) {
        return service.saveCampaigns(campaigns);
    }

    @GetMapping("/campaigns")
    public List<Campaign> findAllCampaign() {
        return service.getCampaigns();
    }

    @GetMapping("/campaignById/{id}")
    public Campaign findCampaignById(@PathVariable int id) {
        return service.getCampaignById(id);
    }

    @GetMapping("/campaign/{name}")
    public Campaign findCampaignByName(@PathVariable String name) {
        return service.getCampaignByName(name);
    }

    @PutMapping("/update")
    public Campaign updateCampaign(@RequestBody Campaign campaign) {
        return service.updateCampaign(campaign);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCampaign(@PathVariable int id) {
        return service.deleteCampaign(id);
    }
}*/

package com.g12cs.stfundraiser.controller;

import com.g12cs.stfundraiser.models.User;
import com.g12cs.stfundraiser.repository.CampaignRepository;
import com.g12cs.stfundraiser.models.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.g12cs.stfundraiser.processor.SearchEngine;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CampaignController {
    @Autowired
    CampaignRepository campaignRepository;
    @Autowired
    SearchEngine searchEngine;
    @GetMapping("/campaign")
    public List<Campaign> getAll(){
        return campaignRepository.findAll();
    }
    @GetMapping("/campaign/query=/{query}")
    public List<Campaign> getBySearch(@Valid @PathVariable(value = "query")String query){
       return searchEngine.campaignSearch(campaignRepository.findAll(),query);

    }

    @PostMapping("/campaign")
    public Campaign addCampaign(@Valid @RequestBody Campaign camp){
        return campaignRepository.save(camp);
    }

    @GetMapping("/campaign/{name}")
    public List<Campaign> getByName(@PathVariable(value ="name") String name){
        return campaignRepository.findByName(name);
    }
    @GetMapping("/campaign/category/{category}")
    public List<Campaign> getByCategory(@PathVariable(value= "category")String category){
        return campaignRepository.findByCategory(category);
    }

    @RequestMapping("/loginCheck")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        boolean loggedIn = LoginController.isLoggedIn();
        if(loggedIn == true) return "CreateEvent/CreateEvent2";
        else return "Login Page/Loginpage";
    }

    @RequestMapping("/events")
    public String showEventsPage(Model model){
        //    model.addAttribute("user", new User());
        return "LatestEvents/latestevents";
    }

/*    @RequestMapping("/event1")
    public String showEvent1Page(Model model){
        //    model.addAttribute("user", new User());
        return "LatestEvents/CyclingEvent";
    }

    @RequestMapping("/event2")
    public String showEvent2Page(Model model){
        //    model.addAttribute("user", new User());
        return "LatestEvents/MarathonEvent";
    }

    @RequestMapping("/event3")
    public String showEvent3Page(Model model){
        //    model.addAttribute("user", new User());
        return "LatestEvents/ArtAuctionEvent";
    }

    @RequestMapping("/event4")
    public String showEvent4Page(Model model){
        //    model.addAttribute("user", new User());
        return "LatestEvents/OverseasEvent";
    }*/

}


