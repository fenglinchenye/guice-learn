package com.freedo.guice.persistence;

import org.springframework.stereotype.Component;

@Component
public class SampleDao {

    public void save(String data){
        System.out.println(data+" save.");
    }

    public String getByName(String name) {
        System.out.println("name get:"+name);
        return name;
    }
}

