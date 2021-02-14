package com.gildedrose;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_QUALITY = 50;
    public static final int BACKSTAGE_DOUBLE_QUALITY_INCREASE_SELLIN = 10;
    public static final int BACKSTAGE_TRIPLE_QUALITY_INCREASE_SELLIN = 5;
    public static final int MINIMUN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items)
            update(item);

    }

    private void update(Item itemTmp) {
        switch (itemTmp.name) {
            case AGED_BRIE:
                reduceSellIn(itemTmp);
                if(itemTmp.quality < MAX_QUALITY)
                    itemTmp.quality++;
                if(itemTmp.sellIn < 0 && itemTmp.quality < MAX_QUALITY)
                    itemTmp.quality++;
                break;
            case BACKSTAGE_PASSES:
                if(itemTmp.quality < MAX_QUALITY)
                    itemTmp.quality++;
                if(itemTmp.sellIn <= BACKSTAGE_DOUBLE_QUALITY_INCREASE_SELLIN && itemTmp.quality < MAX_QUALITY)
                    itemTmp.quality++;
                if(itemTmp.sellIn <= BACKSTAGE_TRIPLE_QUALITY_INCREASE_SELLIN && itemTmp.quality < MAX_QUALITY)
                    itemTmp.quality++;
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                break;
            default:
                reduceSellIn(itemTmp);
                if(itemTmp.quality > MINIMUN_QUALITY)
                    itemTmp.quality--;

                if(itemTmp.sellIn < 0 && itemTmp.quality > MINIMUN_QUALITY)
                    itemTmp.quality--;
        }
    }

    private void reduceSellIn(Item itemTmp) {
        itemTmp.sellIn--;
    }
}