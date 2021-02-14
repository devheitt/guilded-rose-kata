package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenAnNormalItemShouldDecreaseTheQualityAndSellInByOneOnUpdate() {
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void givenAnItemWhenPassedTheSellDateThenDecreaseTheQualityTwiceOnUpdate() {
        Item[] items = new Item[] { new Item("foo", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void checkThanTheQualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenAnAgedBrieThenIncreaseTheQualityOnUpdate() {
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void checkThatTheQualityNeverIsHigherThan50() {
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void givenASulfurasThenAllTheValuesRemainTheSameOnUpdate() {
        Item[] items = new Item[] { new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void givenASulfurasThenTheQualityCanGetTo80() {
        Item[] items = new Item[] { new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void givenABackstagePassThenTheQualityIncreaseBy1WhenTheSellInIsGreaterThan10() {
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 11, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void givenABackstagePassThenTheQualityIncreaseBy2WhenTheSellInIsEqualsOrLowerThan10() {
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void givenABackstagePassThenTheQualityIncreaseBy3WhenTheSellInIsEqualsOrLowerThan5() {
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }
}
