package com.gildedrose.behavior.quality;

import com.gildedrose.Item;

public class DecreasingQualityBehavior implements QualityBehavior {

    public static final int NORMAL_QUALITY_DECREASE = 1;
    public static final int FASTER_QUALITY_DECREASE = 2;
    private final QualityLimit qualityLimit;

    private final int normalDecreaseSpeed;
    private final int fasterDecreaseSpeed;


    private DecreasingQualityBehavior(int normalDecreaseSpeed, int fasterDecreaseSpeed) {
        this.normalDecreaseSpeed = normalDecreaseSpeed;
        this.fasterDecreaseSpeed = fasterDecreaseSpeed;
        this.qualityLimit = QualityLimit.DEFAULT();
    }

    public static DecreasingQualityBehavior newInstance() {
        return new DecreasingQualityBehavior(NORMAL_QUALITY_DECREASE, FASTER_QUALITY_DECREASE);
    }

    public static DecreasingQualityBehavior newInstance(int normalDecreaseSpeed, int fasterDecreaseSpeed) {
        return new DecreasingQualityBehavior(normalDecreaseSpeed, fasterDecreaseSpeed);
    }

    @Override
    public void processQualityUpdate(Item item) {
        decreaseQuality(item);
    }

    private void decreaseQuality(Item item) {
        item.quality = limitQuality(item.quality - getQualityDecreaseAmount(item));
    }

    private int getQualityDecreaseAmount(Item item) {
        return item.sellIn > 0 ? normalDecreaseSpeed : fasterDecreaseSpeed;
    }
    private int limitQuality(int newQuality) {
        return qualityLimit.execute(newQuality);
    }
}
