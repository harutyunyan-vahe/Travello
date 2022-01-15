package com.travello.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTest {

    @Test
    public void test_with_multiple_items() {

        PricingRules pricingRules = PricingRulesFixter.createPricingRule();

        Checkout checkout = new Checkout(pricingRules);

        checkout.scan(new Item("A"));
        checkout.scan(new Item("A"));
        checkout.scan(new Item("A"));

        checkout.scan(new Item("B"));
        checkout.scan(new Item("B"));
        checkout.scan(new Item("B"));
        checkout.scan(new Item("B"));

        Price total = checkout.total();
        Assertions.assertEquals(220d, total.getPrice());

    }

    @Test
    public void test_with_single_item_type() {

        PricingRules pricingRules = PricingRulesFixter.createPricingRule();

        Checkout checkout = new Checkout(pricingRules);

        checkout.scan(new Item("C"));
        checkout.scan(new Item("C"));
        checkout.scan(new Item("C"));
        checkout.scan(new Item("C"));


        Price total = checkout.total();
        Assertions.assertEquals(80d, total.getPrice());

    }


    @Test
    public void test_empty_checkout() {

        PricingRules pricingRules = PricingRulesFixter.createPricingRule();

        Checkout checkout = new Checkout(pricingRules);


        Price total = checkout.total();
        Assertions.assertEquals(0d, total.getPrice());

    }

}
