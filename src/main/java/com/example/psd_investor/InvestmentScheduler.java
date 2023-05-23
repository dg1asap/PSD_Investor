package com.example.psd_investor;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class InvestmentScheduler {

    private static final int MIN_DELAY = 1;

    private static final int MAX_DELAY = 10;

    private final InvestmentController investmentController;

    private final Random random = new Random();

    @Scheduled(fixedDelay = 1)
    public void executeTask() {
        waitRandomTimeInterval();
        investmentController.publishReturnOnInvestment();
    }

    private void waitRandomTimeInterval() {
        int delay = random.nextInt(MAX_DELAY) + MIN_DELAY;
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
