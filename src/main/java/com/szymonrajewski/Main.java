package com.szymonrajewski;

import com.szymonrajewski.collection.StockOrder;
import com.szymonrajewski.collection.StockOrderActionType;
import com.szymonrajewski.collection.StockOrderName;
import com.szymonrajewski.collection.UniquePricedDataCollection;

import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try {
            final UniquePricedDataCollection<StockOrder> stockOrders = new UniquePricedDataCollection<>();

            final StockOrder stockOrder1 = new StockOrder("001", StockOrderName.Sell, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder2 = new StockOrder("002", StockOrderName.Buy, StockOrderActionType.Add, 30.00F, 100);
            final StockOrder stockOrder3 = new StockOrder("003", StockOrderName.Buy, StockOrderActionType.Add, 125.00F, 100);
            final StockOrder stockOrder4 = new StockOrder("004", StockOrderName.Buy, StockOrderActionType.Add, 225.00F, 100);
            final StockOrder stockOrder5 = new StockOrder("005", StockOrderName.Buy, StockOrderActionType.Add, 325.00F, 100);
            final StockOrder stockOrder6 = new StockOrder("006", StockOrderName.Buy, StockOrderActionType.Add, 425.00F, 100);
            final StockOrder stockOrder7 = new StockOrder("007", StockOrderName.Buy, StockOrderActionType.Add, 525.00F, 100);
            final StockOrder stockOrder8 = new StockOrder("008", StockOrderName.Buy, StockOrderActionType.Add, 625.00F, 100);
            final StockOrder stockOrder9 = new StockOrder("009", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder10 = new StockOrder("010", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder11 = new StockOrder("011", StockOrderName.Buy, StockOrderActionType.Remove, 30.00F, 100);

            stockOrders.add(Optional.of(stockOrder1));
            stockOrders.add(Optional.of(stockOrder2));
            stockOrders.add(Optional.of(stockOrder3));
            stockOrders.add(Optional.of(stockOrder4));
            stockOrders.add(Optional.of(stockOrder5));
            stockOrders.add(Optional.of(stockOrder6));
            stockOrders.add(Optional.of(stockOrder7));
            stockOrders.add(Optional.of(stockOrder8));
            stockOrders.add(Optional.of(stockOrder9));
            stockOrders.add(Optional.of(stockOrder10));
            stockOrders.add(Optional.of(stockOrder11));

            Map<String, StockOrder> elementsWithLowestPrice = stockOrders.getElementWithLowestPrice();

            elementsWithLowestPrice.forEach((key, value) -> System.out.println(value.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}