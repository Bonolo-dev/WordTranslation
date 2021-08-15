package com.bonolo.XtmAssessment.services;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModeTwoImplementationTest {

    @Test
    void translator() {

        //Given
        String testData = "My trousers were torn by a cat that has white eyes. " +
                "The cat is owned by a soldier who has white socks and his name is Alice Smith. " +
                "The cat is at the helm of my snow white garden, we always fight for the door.";

        String expected = "My \"spodnie\" were torn by \"kota\" that \"ma\" \"białym\" eyes." +
                " The cat is owned by a \"żołnierzem\" who \"ma\" \"białym\" socks and his name is \"Ala\" Smith. " +
                "The cat is at \"sterem\" of my snow \"białym\" garden, we always \"walcz\" for the door.";

        HashMap<String,String> dictionary = new HashMap<>(){{
            put("Ala","Alice");
            put("ma","has");
            put("kota","a cat");
            put("jesteś","you are");
            put("sterem","the helm");
            put("białym","white");
            put("żołnierzem","soldier");
            put("nosisz","wear");
            put("więc","so");
            put("walcz","fight");
            put("spodnie","trousers");
        }};

        //When
        ModeTwoImplementation modeTwoImplementation = new ModeTwoImplementation();
        String translatedTest =modeTwoImplementation.translator(testData, dictionary );

        //Then
        assertThat(translatedTest).isEqualTo(expected);
    }
}