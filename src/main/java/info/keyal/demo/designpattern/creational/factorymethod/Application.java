package info.keyal.demo.designpattern.creational.factorymethod;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {

        PlanFactory planFactory = new PlanFactory();
        String planName = "COM";
        int units = 2;
        Plan comPlan = planFactory.getPlan("COM");
        comPlan.getRate();
        LOGGER.info("Bill amount for {} with rate {}, of {} units is: {} ", planName, comPlan.rate, units, comPlan.calculateBill(units));


        planName = "DOM";
        Plan domPlan = planFactory.getPlan(planName);
        domPlan.getRate();
        LOGGER.info("Bill amount for {} with rate {}, of {} units is: {} ", planName, domPlan.rate, units, domPlan.calculateBill(units));
    }
}

