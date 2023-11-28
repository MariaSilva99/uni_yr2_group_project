package com.g12cs.stfundraiser.service;

import com.g12cs.stfundraiser.models.Campaign;
import com.g12cs.stfundraiser.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository repository;
    public Campaign savecampaign(Campaign campaign) {
        return repository.save(campaign);
    }

    public List<Campaign> savecampaigns(List<Campaign> campaigns) {
        return repository.saveAll(campaigns);
    }

    public List<Campaign> getcampaigns() {
        return repository.findAll();
    }

    public Campaign getcampaignById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Campaign getcampaignByName(String name) {
        return (Campaign) repository.findByName(name);
    }

    public String deletecampaign(int id) {
        repository.deleteById(id);
        return "campaign removed !! " + id;
    }
    public Campaign updatecampaign(Campaign campaign) {
        Campaign existingcampaign = repository.findById(campaign.getId()).orElse(null);
        existingcampaign.setName(campaign.getName());
        existingcampaign.setDescription(campaign.getDescription());
        existingcampaign.setFund_target(campaign.getFund_target());
        return repository.save(existingcampaign);
    }


}
