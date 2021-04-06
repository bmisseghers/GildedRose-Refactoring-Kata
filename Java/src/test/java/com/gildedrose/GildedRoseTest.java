package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("foo", 0, 0));
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testDexterityVest() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("+5 Dexterity Vest", 10, 20));
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void testAgedBrie() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Aged Brie", 2, 0));
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void testElixirOfMongoose() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Elixir of the Mongoose", 5, 7));
        assertEquals(4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void testSulfuras() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testSulfurasExpired() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Sulfuras, Hand of Ragnaros", -1, 80));
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testBackstagePasses15() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void testBackstagePasses10() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackstagePasses5() {
        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

//    @Test
//    void testConjuredManaCake() {
//        GildedRose app = GildedRoseAppTester.runFor(1, new Item("Conjured Mana Cake", 3, 6));
//        assertEquals(2, app.items[0].sellIn);
//        assertEquals(5, app.items[0].quality);
//    }
}
