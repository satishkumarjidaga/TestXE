package com.test.commonuties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public Properties properties;
    String rootdirectory = System.getProperty("user.dir");

    String propertyFilePath = rootdirectory +File.separator+"Configs" + File.separator+"Config.properties";

    public ConfigFileReader() {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found in the path" +propertyFilePath );
        }

    }
    public String getConfigvalue(String key)
    {
        String value = properties.getProperty(key);
        return value;
    }
}