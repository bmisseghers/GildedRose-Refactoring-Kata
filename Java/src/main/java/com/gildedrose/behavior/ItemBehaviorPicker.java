package com.gildedrose.behavior;

import com.gildedrose.behavior.item.ItemBehavior;
import com.gildedrose.behavior.item.ItemBehaviorImpl;
import com.gildedrose.behavior.quality.DecreasingQualityBehavior;
import com.gildedrose.behavior.quality.ImmutableQualityBehavior;
import com.gildedrose.behavior.quality.IncreasingQualityBehavior;
import com.gildedrose.behavior.quality.QualityStage;
import com.gildedrose.behavior.quality.StagedIncreasingQualityBehavior;
import com.gildedrose.behavior.sellin.DecreasingSellInBehavior;
import com.gildedrose.behavior.sellin.ImmutableSellInBehavior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBehaviorPicker {
    public static final String ITEM_AGED_BRIE = "Aged Brie";
    public static final String ITEM_SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String ITEM_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ITEM_CONJURED_MANA_CAKE = "Conjured Mana Cake";

    public static ItemBehavior forName(String name) {

        switch (name) {
            case ITEM_AGED_BRIE: return getAgedBrieItemBehavior();
            case ITEM_SULFURAS_HAND_OF_RAGNAROS: return getSulfurusHandOfRagnarosItemBehavior();
            case ITEM_BACKSTAGE_PASSES: return getBackstagePassesItemBehavior();
            case ITEM_CONJURED_MANA_CAKE: return getConjuredItemBehavior();
            default: return getDefaultItemBehavior();
        }
    }

    private static ItemBehavior getAgedBrieItemBehavior() {
        return ItemBehaviorImpl.of(IncreasingQualityBehavior.newInstance(), DecreasingSellInBehavior.newInstance());
    }

    private static ItemBehavior getSulfurusHandOfRagnarosItemBehavior() {
        return ItemBehaviorImpl.of(ImmutableQualityBehavior.newInstance(), ImmutableSellInBehavior.newInstance());
    }

    private static ItemBehavior getBackstagePassesItemBehavior() {
        List<QualityStage> stages = new ArrayList<>(
                Arrays.asList(
                        QualityStage.of(10,2),
                        QualityStage.of(5,3)
                ));
        return ItemBehaviorImpl.of(StagedIncreasingQualityBehavior.withStages(stages, 1), DecreasingSellInBehavior.newInstance());
    }

    private static ItemBehavior getConjuredItemBehavior() {
        return ItemBehaviorImpl.of(DecreasingQualityBehavior.newInstance(2, 4), DecreasingSellInBehavior.newInstance());
    }

    private static ItemBehavior getDefaultItemBehavior() {
        return ItemBehaviorImpl.of(DecreasingQualityBehavior.newInstance(), DecreasingSellInBehavior.newInstance());
    }
}
