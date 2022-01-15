package com.travello.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Checkout {

    private final PricingRules pricingRules;
    private final List<Item> items;

    public Checkout(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
        this.items = new ArrayList<>();
    }

    public void scan(Item item) {
        this.items.add(item);
    }

    public Price total() {

        Map<Item, Long> itemToCount = this.items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        double sum = itemToCount.entrySet()
                .stream()
                .mapToDouble(e -> pricingRules.getPrice(e.getKey(), e.getValue()))
                .sum();

        return new Price(sum);


    }


}
