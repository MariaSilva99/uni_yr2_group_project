package com.g12cs.stfundraiser.processor;
import com.g12cs.stfundraiser.models.Campaign;
import com.g12cs.stfundraiser.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("Search Engine")
public class SearchEngine {

    public List<User> userSearch(List<User> users, String query){
        String[] searchTerms = query.split(" ");
        List<User> results= new ArrayList<User>();

        for (User u: users){
            String[] tokens = u.getUsername().split(" ");
            for(String t: tokens){
                for(String s: searchTerms){
                    if(t.equalsIgnoreCase(s) && !results.contains(u)){
                        results.add(u);
                    }
                }
            }

        }

        return results;
    }


    public List<Campaign> campaignSearch(List<Campaign> campaigns, String query){

        // splits search terms in to words
        String[] searchTerms = query.split(" ");
        List<Campaign> results= new ArrayList<Campaign>();

        // looks for matching words in the title and description
        for (Campaign c: campaigns){
            String[] tokens = c.getDescription().split(" ");
            for(String t: tokens){
                for(String s: searchTerms){
                    if(t.equalsIgnoreCase(s) && !results.contains(c)){
                        results.add(c);
                    }
                }
            }

        }
        for (Campaign c: campaigns){
            String[] tokens = c.getName().split(" ");
            for(String t: tokens){
                for(String s: searchTerms){
                    // adds to results list if there is a match and it isn't already in the list
                    if(t.equalsIgnoreCase(s) && !results.contains(c)){
                        results.add(c);
                    }
                }
            }

        }
        for (Campaign c: campaigns){
            String[] tokens = c.getCreators().split(" ");
            for(String t: tokens){
                for(String s: searchTerms){
                    if(t.equalsIgnoreCase(s) && !results.contains(c)){
                        results.add(c);
                    }
                }
            }

        }
        for (Campaign c: campaigns){
            String[] tokens = c.getCategory().split(" ");
            for(String t: tokens){
                for(String s: searchTerms){
                    if(t.equalsIgnoreCase(s) && !results.contains(c)){
                        results.add(c);
                    }
                }
            }

        }


        return results;
    }

}
