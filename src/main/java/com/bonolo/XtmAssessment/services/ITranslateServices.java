package com.bonolo.XtmAssessment.services;

import java.util.HashMap;
import java.util.Map;


public interface ITranslateServices {

    public abstract String translator(String data, HashMap<String,String> dictionary);
}
