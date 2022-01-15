package com.travello.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PricingRulesTest {


    @Test
    public void test_item_without_discount() {


        PricingRules pricingRules = PricingRulesFixter.createPricingRule();
        Assertions.assertEquals(60d, pricingRules.getPrice(new Item("C"), 3));
        Assertions.assertEquals(80d, pricingRules.getPrice(new Item("C"), 4));

    }

    @Test
    public void test_item_with_discount() {
        PricingRules pricingRules = PricingRulesFixter.createPricingRule();



        double aPrice = pricingRules.getPrice(new Item("A"), 5);

        Assertions.assertEquals(230d, aPrice);
    }

    @Test
    public void test_item_with_rule_info() {
        PricingRules pricingRules = PricingRulesFixter.createPricingRule();

        double aPrice = pricingRules.getPrice(new Item("Z"), 5);

        Assertions.assertEquals(0d, aPrice);
    }
}
