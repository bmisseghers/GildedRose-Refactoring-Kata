package com.gildedrose.behavior.quality;

import com.gildedrose.Item;

public class IncreasingQualityBehavior implements QualityBehavior {

    private static final QualityLimit qualityLimit = QualityLimit.DEFAULT();

    public static IncreasingQualityBehavior newInstance() {
        return new IncreasingQualityBehavior();
    }

    @Override
    public void processQualityUpdate(Item item) {
        increaseQuality(item);
    }

    private void increaseQuality(Item item) {
        item.quality = limitQuality(item.quality + 1);
    }

    private int limitQuality(int newQuality) {
        return qualityLimit.execute(newQuality);
    }
}
