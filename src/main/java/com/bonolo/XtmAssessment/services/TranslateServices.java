package com.bonolo.XtmAssessment.services;

import com.bonolo.XtmAssessment.dto.TranslateRequestDto;
import com.bonolo.XtmAssessment.util.LoadDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TranslateServices {

    private LoadDictionary loadDictionary;
    public TranslateServices() {
    }
    @Autowired
    public TranslateServices(LoadDictionary loadDictionary){
        this.loadDictionary=loadDictionary;
    }

    public String getTranslation(TranslateRequestDto translateRequestDto){

        String translatedData;
        switch(translateRequestDto.getMode()){
            case MODE1:
                ModeOneImplementation modeOneObj = new ModeOneImplementation();
                translatedData = modeOneObj
                        .translator(translateRequestDto.getTranslateData(),this.loadDictionary.getDictionary());
                break;
            case MODE2:
                ModeTwoImplementation modeTwoObj = new ModeTwoImplementation();
                translatedData =  modeTwoObj
                        .translator(translateRequestDto.getTranslateData(),this.loadDictionary.getDictionary());
                break;
            default:
                throw new RuntimeException("Error: Invalid mode");
        }
        return translatedData;
    }

    public Map<String,Integer> getWordRankings(String data){

        Map<String,Integer> translatedWordRanks = new HashMap<>();

        //Theoretically any translation method may be used
        ModeOneImplementation modeOneObj = new ModeOneImplementation();
        String translated = modeOneObj.translator(data,this.loadDictionary.getDictionary());

        String[] translatedArr = translated.split(" ");

        for(Map.Entry<String, String> entry: this.loadDictionary.getDictionary().entrySet()){

            List<String>matchOccurance =Arrays.stream(translatedArr).filter(word-> entry.getKey().matches(word))
            .collect(Collectors.toList());

            if(matchOccurance.size()>0){
                translatedWordRanks.put(entry.getKey(),matchOccurance.size());
            }

        }

        Map<String, Integer> translatedOrdered = new LinkedHashMap<>();

        translatedWordRanks.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> translatedOrdered.put(x.getKey(), x.getValue()));


        return translatedOrdered;
    }
}
