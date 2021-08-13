package com.bonolo.XtmAssessment.services;

import java.util.*;
import java.util.stream.Collectors;

public class ModeTwoImplementation implements ITranslateServices{

    public ModeTwoImplementation() {
    }

    @Override
    public String translator(String data,HashMap<String,String> dictionary) {

        for(Map.Entry<String, String> entry: dictionary.entrySet()){
           data= data.replace(entry.getValue(), "\""+entry.getKey()+"\"");
        }
        return data;
    }


}
