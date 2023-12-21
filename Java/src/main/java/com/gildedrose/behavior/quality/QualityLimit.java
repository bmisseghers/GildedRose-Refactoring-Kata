package com.gildedrose.behavior.quality;

public class QualityLimit {

    public static final int DEFAULT_MAX_QUALITY_LEVEL = 50;
    public static final int DEFAULT_MIN_QUALITY_LEVEL = 0;

    private final int max_q_level;
    private final int min_q_level;

    private QualityLimit(int max_q_level, int min_q_level) {
        this.max_q_level = max_q_level;
        this.min_q_level = min_q_level;
    }

    public static QualityLimit DEFAULT() {
        return new QualityLimit(DEFAULT_MAX_QUALITY_LEVEL, DEFAULT_MIN_QUALITY_LEVEL);
    }

    public static QualityLimit of(int max_q_level, int min_q_level) {
        return new QualityLimit(max_q_level, min_q_level);
    }

    public int execute(int requestedQualityLevel) {
        return Math.max(min_q_level, Math.min(max_q_level, requestedQualityLevel));
    }
}
