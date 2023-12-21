package com.gildedrose.behavior.sellin;

import com.gildedrose.Item;

public class DecreasingSellInBehavior implements SellInBehavior {

    private static final int DEFAULT_STEP_SIZE_1 = 1;

    private final int stepSize;

    DecreasingSellInBehavior(int stepSize) {
        this.stepSize = stepSize;
    }

    public static DecreasingSellInBehavior newInstance(int stepSize) {
        return new DecreasingSellInBehavior(stepSize);
    }

    public static DecreasingSellInBehavior newInstance() {
        return newInstance(DEFAULT_STEP_SIZE_1);
    }

    @Override
    public void processSellInUpdate(Item item) {
        decreaseSellIn(item);
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - stepSize;
    }
}
