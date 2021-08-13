package com.bonolo.XtmAssessment.dto;

import com.bonolo.XtmAssessment.enums.EModes;

public class TranslateRequestDto {
    String translateData;
    EModes mode;

    public TranslateRequestDto() {
    }

    public String getTranslateData() {
        return translateData;
    }

    public void setTranslateData(String translateData) {
        this.translateData = translateData;
    }

    public EModes getMode() {
        return mode;
    }

    public void setMode(EModes mode) {
        this.mode = mode;
    }
}
