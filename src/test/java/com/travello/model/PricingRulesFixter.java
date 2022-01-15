package com.travello.model;

public class PricingRulesFixter {


    public static PricingRules createPricingRule() {
        PricingRules pricingRules = new PricingRules();

        pricingRules.add(new Item("A"), PricingRules.Rule.withDiscount(50, 3 , 130));
        pricingRules.add(new Item("B"), PricingRules.Rule.withDiscount(30, 2, 45));
        pricingRules.add(new Item("C"), PricingRules.Rule.withoutDiscount(20));
        pricingRules.add(new Item("D"), PricingRules.Rule.withoutDiscount(15));

        return pricingRules;
    }

}
