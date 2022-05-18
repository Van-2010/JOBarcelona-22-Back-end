package com.example.JOBarcelona.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JasonUtilService {

    @Value("classpath:data.json")
    public Resource resource;

    public String getData(){
        try {
            File file = resource.getFile();
            String jsonData = this.jsonRead(file);
            return jsonData;
        } catch (Exception e) {
            return null;
        }
    }


    private String jsonRead(File file) throws IOException {
        BufferedReader reader = null;
        StringBuilder buffer = new StringBuilder();
        reader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        reader.close();
        return buffer.toString();
    }
}
