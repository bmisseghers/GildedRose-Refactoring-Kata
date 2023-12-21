package com.gildedrose.behavior.quality;

import com.gildedrose.Item;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StagedIncreasingQualityBehavior implements QualityBehavior {

    private final List<QualityStage> stages;
    private final QualityStage defaultStage;
    private final QualityLimit qualityLimit;


    private StagedIncreasingQualityBehavior(List<QualityStage> stages, int defaultQualityIncrease) {
        this.stages = getSortedQualityStages(stages);
        this.defaultStage = QualityStage.of(0, defaultQualityIncrease);
        this.qualityLimit = QualityLimit.DEFAULT();
    }

    public static StagedIncreasingQualityBehavior withStages(List<QualityStage> stages, int defaultQualityIncrease) {
        return new StagedIncreasingQualityBehavior(stages, defaultQualityIncrease);
    }

    @Override
    public void processQualityUpdate(Item item) {
        increaseQuality(item);
    }

    private void increaseQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else {
            final QualityStage stage = findStage(item);
            item.quality = limitQuality(item.quality + stage.getQualityIncrease());
        }
    }

    private int limitQuality(int newQuality) {
        return qualityLimit.execute(newQuality);
    }

    private QualityStage findStage(Item item) {
        return stages.stream().filter(qualityStage -> qualityStage.getSellInCutoff() >= item.sellIn)
                .findFirst().orElse(defaultStage);
    }

    private List<QualityStage> getSortedQualityStages(List<QualityStage> stagesUnsorted) {
        return stagesUnsorted.stream().sorted(Comparator.comparingInt(QualityStage::getSellInCutoff)).collect(Collectors.toList());
    }
}
