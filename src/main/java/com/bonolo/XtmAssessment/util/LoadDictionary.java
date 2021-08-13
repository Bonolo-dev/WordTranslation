package com.bonolo.XtmAssessment.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoadDictionary {

    private static HashMap<String, String>dictionary;
    private final String dictionaryPath = "dictionary.json";

    public LoadDictionary() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(this.dictionaryPath);
        String data = readFromInputStream(inputStream);

        TypeReference<HashMap<String, String>> typeRef = new TypeReference<>() {};
        dictionary = new ObjectMapper().readValue(data, typeRef);
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public HashMap<String,String> getDictionary(){
        return this.dictionary;
    }


}
