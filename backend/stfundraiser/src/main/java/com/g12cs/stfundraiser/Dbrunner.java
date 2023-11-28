package com.g12cs.stfundraiser;
import com.g12cs.stfundraiser.models.User;
import com.g12cs.stfundraiser.repository.UserRepository;
import com.g12cs.stfundraiser.models.Campaign;
import com.g12cs.stfundraiser.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dbrunner implements CommandLineRunner{
    @Autowired
    private CampaignRepository sampleRepository;
    @Autowired
    private UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception {
/*
        sampleRepository.deleteAll();

        int price = 5000;

        sampleRepository.save(new Campaign("Soup kitchen","Humanitarian aid","Red Cross",500,
                "we are looking for donations to help purchase food for our soup kitchen so we can feed more people"));
        sampleRepository.save(new Campaign("Clean water","Humanitarian aid","Unicef",price,
                "we are looking for donations to help provide clean water in rural parts of africa"));
        sampleRepository.save(new Campaign("Laptops for Pupils","Technology","Unicef",price,
                "we as a charity create affordable linux based laptops for school children that cannot afford one" +
                        " "));
        sampleRepository.save(new Campaign("Solar Energy 4 all","Technology","The Tech Guys",price,
                "we are looking for funding to help build affordable solar panels for more people" +
                        " "));

        userRepository.deleteAll();
        userRepository.save(new User("Brixton soup kitchen","password","john","smith",
                "bxtnsoup@gmail.com",true));
*/
    }

}