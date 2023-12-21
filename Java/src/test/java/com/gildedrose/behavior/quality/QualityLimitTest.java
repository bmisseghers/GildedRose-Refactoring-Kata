package com.gildedrose.behavior.quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualityLimitTest {

    private QualityLimit defaultQualityLimit;

    @BeforeEach
    public void setUp() throws Exception {
        defaultQualityLimit = QualityLimit.DEFAULT();
    }

    @Test
    void defaultQLimit_under_limit() {
        int limit = defaultQualityLimit.execute(-1);

        assertEquals(0, limit);
    }

    @Test
    void defaultQLimit_lower_boundary() {
        int limit = defaultQualityLimit.execute(0);

        assertEquals(0, limit);
    }

    @Test
    void defaultQLimit_within_limits() {
        int limit = defaultQualityLimit.execute(10);

        assertEquals(10, limit);
    }

    @Test
    void defaultQLimit_upper_boundary() {
        int limit = defaultQualityLimit.execute(50);

        assertEquals(50, limit);
    }

    @Test
    void defaultQLimit_over_limit() {
        int limit = defaultQualityLimit.execute(51);

        assertEquals(50, limit);
    }
}
