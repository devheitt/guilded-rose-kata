package com.gildedrose;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item itemTmp = items[i];
            switch (itemTmp.name) {
                case AGED_BRIE:
                    itemTmp.sellIn--;
                    if(itemTmp.quality < 50)
                        itemTmp.quality++;
                    if(itemTmp.sellIn < 0 && itemTmp.quality < 50)
                        itemTmp.quality++;
                    break;
                case BACKSTAGE_PASSES:
                    if(itemTmp.quality < 50)
                        itemTmp.quality++;
                    if(itemTmp.sellIn <= 10 && itemTmp.quality < 50)
                        itemTmp.quality++;
                    if(itemTmp.sellIn <= 5 && itemTmp.quality < 50)
                        itemTmp.quality++;
                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    break;
                default:
                    itemTmp.sellIn--;
                    if(itemTmp.quality > 0)
                        itemTmp.quality--;

                    if(itemTmp.sellIn < 0 && itemTmp.quality > 0)
                        itemTmp.quality--;
            }

        }
    }
}