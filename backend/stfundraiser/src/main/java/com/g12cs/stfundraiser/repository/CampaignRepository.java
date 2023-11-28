package com.g12cs.stfundraiser.repository;

import java.util.List;
import com.g12cs.stfundraiser.models.Campaign;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    List<Campaign> findByName(String name);
    List<Campaign> findByCategory(String category);

}
