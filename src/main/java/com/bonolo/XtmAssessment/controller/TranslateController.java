package com.bonolo.XtmAssessment.controller;

import com.bonolo.XtmAssessment.dto.TranslateRequestDto;
import com.bonolo.XtmAssessment.services.TranslateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

    private TranslateServices translateServices;

    @Autowired
    public TranslateController(TranslateServices translateServices){
        this.translateServices=translateServices;
    }

    @PostMapping("/translate")
    public ResponseEntity<?> getTranslation(@RequestBody TranslateRequestDto translateRequestDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.translateServices.getTranslation(translateRequestDto));
    }
    @PostMapping("/ranking")
    public ResponseEntity<?> getRanking(@RequestBody TranslateRequestDto rankingDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.translateServices.getWordRankings(rankingDto.getTranslateData()));
    }
}
