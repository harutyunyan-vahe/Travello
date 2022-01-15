package com.travello;

import com.travello.model.*;

public class Program {

    public static void main(String[] args) {
        PricingRules pricingRules = new PricingRules();

        pricingRules.add(new Item("A"), PricingRules.Rule.withDiscount(50, 3 , 130));
        pricingRules.add(new Item("B"), PricingRules.Rule.withDiscount(30, 2, 45));
        pricingRules.add(new Item("C"), PricingRules.Rule.withoutDiscount(20));
        pricingRules.add(new Item("D"), PricingRules.Rule.withoutDiscount(15));


        Checkout checkout = new Checkout(pricingRules);

        checkout.scan(new Item("A"));
        checkout.scan(new Item("A"));
        checkout.scan(new Item("A"));

        checkout.scan(new Item("B"));
        checkout.scan(new Item("B"));
        checkout.scan(new Item("B"));
        checkout.scan(new Item("B"));

        Price total = checkout.total();
        System.out.println(total);

    }
}
