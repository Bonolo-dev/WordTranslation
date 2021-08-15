package com.bonolo.XtmAssessment.services;

import java.util.HashMap;
import java.util.Map;

public class ModeOneImplementation implements ITranslateServices{

    public ModeOneImplementation() {
    }

    @Override
    public String translator(String data, HashMap<String,String> dictionary) {

        for(Map.Entry<String, String> entry: dictionary.entrySet()){
            data= data.replace(" "+entry.getValue()+" ", " "+entry.getKey()+" ");
        }
        return data;
    }
}
