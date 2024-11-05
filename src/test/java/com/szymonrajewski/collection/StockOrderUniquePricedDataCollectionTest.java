package com.szymonrajewski.collection;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StockOrderUniquePricedDataCollectionTest {
    @Test
    public void testAddOneElement() {
        try {
            final UniquePricedDataCollection<StockOrder> stockOrders = new UniquePricedDataCollection<>();
            final StockOrder stockOrder1 = new StockOrder("001", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            stockOrders.add(Optional.of(stockOrder1));

            assertEquals(1, stockOrders.count());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testRemoveOneElement() {
        try {
            final UniquePricedDataCollection<StockOrder> stockOrders = new UniquePricedDataCollection<>();
            final StockOrder stockOrder1 = new StockOrder("001", StockOrderName.Buy, StockOrderActionType.Remove, 25.00F, 100);
            stockOrders.add(Optional.of(stockOrder1));
            stockOrders.remove(Optional.of(stockOrder1));

            assertEquals(0, stockOrders.count());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAddMultipleElements() {
        try {
            final UniquePricedDataCollection<StockOrder> stockOrders = new UniquePricedDataCollection<>();
            final StockOrder stockOrder1 = new StockOrder("001", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder2 = new StockOrder("002", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder3 = new StockOrder("003", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            stockOrders.add(Optional.of(stockOrder1));
            stockOrders.add(Optional.of(stockOrder2));
            stockOrders.add(Optional.of(stockOrder3));

            assertEquals(3, stockOrders.count());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testRemoveMultipleElements() {
        try {
            final UniquePricedDataCollection<StockOrder> stockOrders = new UniquePricedDataCollection<>();
            final StockOrder stockOrder1 = new StockOrder("001", StockOrderName.Buy, StockOrderActionType.Remove, 25.00F, 100);
            final StockOrder stockOrder2 = new StockOrder("002", StockOrderName.Buy, StockOrderActionType.Remove, 25.00F, 100);
            final StockOrder stockOrder3 = new StockOrder("003", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            stockOrders.add(Optional.of(stockOrder1));
            stockOrders.add(Optional.of(stockOrder2));
            stockOrders.add(Optional.of(stockOrder3));

            stockOrders.remove(Optional.of(stockOrder1));
            stockOrders.remove(Optional.of(stockOrder2));

            assertEquals(1, stockOrders.count());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testFindElementsWithLowestPrice() {
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

            assertEquals(3, elementsWithLowestPrice.size());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAddMultipleElementsThatExceedsInitialSize() {
        try {
            final UniquePricedDataCollection<StockOrder> stockOrders = new UniquePricedDataCollection<>();

            final StockOrder stockOrder1 = new StockOrder("001", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder2 = new StockOrder("002", StockOrderName.Buy, StockOrderActionType.Add, 30.00F, 100);
            final StockOrder stockOrder3 = new StockOrder("003", StockOrderName.Buy, StockOrderActionType.Add, 125.00F, 100);
            final StockOrder stockOrder4 = new StockOrder("004", StockOrderName.Buy, StockOrderActionType.Add, 225.00F, 100);
            final StockOrder stockOrder5 = new StockOrder("005", StockOrderName.Buy, StockOrderActionType.Add, 325.00F, 100);
            final StockOrder stockOrder6 = new StockOrder("006", StockOrderName.Buy, StockOrderActionType.Add, 425.00F, 100);
            final StockOrder stockOrder7 = new StockOrder("007", StockOrderName.Buy, StockOrderActionType.Add, 525.00F, 100);
            final StockOrder stockOrder8 = new StockOrder("008", StockOrderName.Buy, StockOrderActionType.Add, 625.00F, 100);
            final StockOrder stockOrder9 = new StockOrder("009", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder10 = new StockOrder("010", StockOrderName.Buy, StockOrderActionType.Add, 25.00F, 100);
            final StockOrder stockOrder11 = new StockOrder("011", StockOrderName.Buy, StockOrderActionType.Add, 30.00F, 100);

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

            assertEquals(11, stockOrders.count());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
