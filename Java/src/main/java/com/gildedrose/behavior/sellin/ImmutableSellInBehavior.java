package com.gildedrose.behavior.sellin;

import com.gildedrose.Item;

public class ImmutableSellInBehavior implements SellInBehavior {

    private static final int STEP_SIZE_ZERO = 0;

    private final DecreasingSellInBehavior decreasingSellInBehavior;

    private ImmutableSellInBehavior () {
        decreasingSellInBehavior = DecreasingSellInBehavior.newInstance(STEP_SIZE_ZERO);
    }

    public static ImmutableSellInBehavior newInstance() {
        return new ImmutableSellInBehavior();
    }

    @Override
    public void processSellInUpdate(Item item) {
        decreasingSellInBehavior.processSellInUpdate(item);
    }
}
