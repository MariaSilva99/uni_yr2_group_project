package com.g12cs.stfundraiser.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import java.util.Date;


@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotBlank
    private String creators;

    @NotNull
    private int fund_target;

    @NotBlank
    private String description;



    public Campaign(String name, String category, String creators, int fund_target, String description){
        this.name = name;
        this.description = description;
        this.creators = creators;
        this.fund_target = fund_target;
        this.category = category;

    }
    public Campaign(){

    }


    // getters and setters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCreators(){
        return creators;
    }

    public String getCategory(){
        return category;
    }

    public String getDescription(){
        return description;
    }

    public int getFund_target(){
        return fund_target;
    }


    public void setId (int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setCreators(String creators){
        this.creators = creators;
    }
    public void setFund_target (int fund_target){
        this.fund_target = fund_target;
    }
    public void setDescription(String description){
        this.description = description;
    }



}