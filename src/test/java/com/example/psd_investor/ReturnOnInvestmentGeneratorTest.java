package com.example.psd_investor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReturnOnInvestmentGeneratorTest {

    @Autowired
    ReturnOnInvestmentGenerator returnOnInvestmentGenerator;

    @Test
    void shouldGenerateSample() {
        //when
        double sample = returnOnInvestmentGenerator.generate();

        //then
        Assertions.assertNotNull(sample);
    }


}