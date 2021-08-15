package com.bonolo.XtmAssessment.controller;

import com.bonolo.XtmAssessment.services.TranslateServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class TranslateControllerTest {

    private TranslateServices translateServicesTest;

    @BeforeEach
    void setUp() {
        translateServicesTest = new TranslateServices(null);
    }

    @Test
    void serviceContextLoads() {
        assertThat(this.translateServicesTest).isNotNull();
    }
    @Test
    void testInstanceOfTranslateServices() {
        assertThat(this.translateServicesTest).isInstanceOf(TranslateServices.class);
    }


}