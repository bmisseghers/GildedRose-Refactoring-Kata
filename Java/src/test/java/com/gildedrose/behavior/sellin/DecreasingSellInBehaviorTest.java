package com.gildedrose.behavior.sellin;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecreasingSellInBehaviorTest {

    private SellInBehavior sellInBehavior;
    private SellInBehavior doubleDecreasingSellInBehavior;

    @BeforeEach
    public void setUp() {
        sellInBehavior = DecreasingSellInBehavior.newInstance();
        doubleDecreasingSellInBehavior = DecreasingSellInBehavior.newInstance(2);
    }

    @Test
    void decreaseSellIn() {
        Item item = getItem(10);
        sellInBehavior.processSellInUpdate(item);

        assertEquals(9, item.sellIn);
    }

    @Test
    void decreaseSellInZero() {
        Item item = getItem(0);
        sellInBehavior.processSellInUpdate(item);

        assertEquals(-1, item.sellIn);
    }

    @Test
    void decreaseNegativeSellIn() {
        Item item = getItem(-1);
        sellInBehavior.processSellInUpdate(item);

        assertEquals(-2, item.sellIn);
    }

    @Test
    void doubleDecreaseSellIn() {
        Item item = getItem(10);
        doubleDecreasingSellInBehavior.processSellInUpdate(item);

        assertEquals(8, item.sellIn);
    }

    @Test
    void doubleDecreaseSellInZero() {
        Item item = getItem(0);
        doubleDecreasingSellInBehavior.processSellInUpdate(item);

        assertEquals(-2, item.sellIn);
    }

    @Test
    void doubleDecreaseNegativeSellIn() {
        Item item = getItem(-1);
        doubleDecreasingSellInBehavior.processSellInUpdate(item);

        assertEquals(-3, item.sellIn);
    }

    private Item getItem(int sellIn) {
        return new Item("SomeItem", sellIn, 0);
    }
}
