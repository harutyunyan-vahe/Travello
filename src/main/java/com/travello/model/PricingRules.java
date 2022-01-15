package com.travello.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


public class PricingRules {

    private final Map<Item, Rule> rules = new HashMap<>();

    public void add(Item item, Rule itemPrice) {
        rules.put(item, itemPrice);
    }

    public double getPrice(Item item, long itemCount) {
        Rule rule = rules.get(item);
        if (rule == null) {
            return 0;
        }

        DiscountPrice discountPrice = rule.getDiscountPrice();
        if (discountPrice == null) {
            return itemCount * rule.getSinglePrice();
        } else {
            double discountedPrice = discountPrice.getPrice() * (itemCount / discountPrice.getDiscountCount());
            double normalPrice = rule.getSinglePrice() * (itemCount % discountPrice.getDiscountCount());
            return discountedPrice + normalPrice;
        }

    }

    @Data
    public static class Rule {
        public static Rule withoutDiscount(double singlePrice) {
            return new Rule(singlePrice);
        }

        public static Rule withDiscount(double singlePrice, int count, double discountPrice) {
            return new Rule(singlePrice, new DiscountPrice(count, discountPrice));
        }

        private final double singlePrice;
        private DiscountPrice discountPrice;

        private Rule(double singlePrice) {
            this.singlePrice = singlePrice;
        }

        private Rule(double singlePrice, DiscountPrice discountPrice) {
            this.singlePrice = singlePrice;
            this.discountPrice = discountPrice;
        }


    }

    @Data
    private static class DiscountPrice {
        private final int discountCount;
        private final double price;
    }
}
