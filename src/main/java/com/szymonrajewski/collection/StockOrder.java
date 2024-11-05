package com.szymonrajewski.collection;

public record StockOrder(
        String id,
        StockOrderName order,
        StockOrderActionType type,
        float price,
        int quantity
) implements UniqueElement, PricedElement {
}
