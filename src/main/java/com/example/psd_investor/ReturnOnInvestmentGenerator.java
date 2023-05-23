package com.example.psd_investor;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ReturnOnInvestmentGenerator {

    private static final double RANGE = 0.1;

    private final Random random = new Random();

    @Value("${mean}")
    private String meanS;

    @Value("${variance}")
    private String varianceS;

    public double generate() {
        double mean = Double.parseDouble(meanS);
        double variance = Double.parseDouble(varianceS);
        double standardDeviation = Math.sqrt(variance);

        return generateNumberFromGaussian(mean, standardDeviation);
    }

    private double generateNumberFromGaussian(double mean, double standardDeviation) {
        double randomNumber;
        do {
            randomNumber = random.nextGaussian() * standardDeviation + mean;
        } while (randomNumber < -RANGE || randomNumber > RANGE);
        return randomNumber;
    }
}
