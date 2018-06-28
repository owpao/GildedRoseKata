package com.gildedrose;

import com.gildedrose.support.ItemDao;
import com.gildedrose.support.LOG;
import com.gildedrose.support.VeryImportantObject;


class GildedRose {
    Item[] items;
    private VeryImportantObject veryImportantObject;

    GildedRose(VeryImportantObject veryImportantObject) {
        this.veryImportantObject = veryImportantObject;
        InitializeItems();
    }

    protected void InitializeItems() {
        this.items = ItemDao.findAllItems();
    }


    public void somethingImportant() {
        this.veryImportantObject.doIt();
    }

    protected void updateItem(Item item) {
        LogMessageDebug("Start Update");
        updateQuality(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
        LogMessageDebug("End Update Item");
    }

    protected void LogMessageDebug(String message) {
        LOG.debug(message);
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    void updateQuality(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            CheckItemQualityIfCanIncrementSellIn(item);
        }
    }

    private void CheckItemQualityIfCanIncrementSellIn(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }


}