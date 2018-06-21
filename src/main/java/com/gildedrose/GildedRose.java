package com.gildedrose;

import com.gildedrose.support.ItemDao;
import com.gildedrose.support.LOG;
import com.gildedrose.support.VeryImportantObject;
//Item[] items;
//private VeryImportantObject veryImportantObject;

class GildedRose {
    Item[] items;
    private VeryImportantObject veryImportantObject;

    //    Item[] items = new Item[]{
//            new Item("+5 Dexterity Vest", 10, 20), //
//            new Item("Aged Brie", 2, 0), //
//            new Item("Elixir of the Mongoose", 5, 7), //
//            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
//            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
//            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
//            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
//            // this conjured item does not work properly yet
//            new Item("Conjured Mana Cake", 3, 6)};
//
    GildedRose(VeryImportantObject veryImportantObject) {
        this.veryImportantObject = veryImportantObject;
        this.items = ItemDao.findAllItems();
    }

    //
//    GildedRose(VeryImportantObject veryImportantObject) {
//        this.veryImportantObject = veryImportantObject;
//        this.items = ItemDao.findAllItems();
//    }
//
//
    public void somethingImportant() {
        this.veryImportantObject.doIt();
    }
//
//    public void somethingImportant() {
//        this.veryImportantObject.doIt();
//    }

    public void updateQuality() {
        LOG.debug("start to update quality");
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
                }
            }


//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
        ItemDao.save(items);
        LOG.debug("items saved to database");
    }

//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//        ItemDao.save(items);
//        LOG.debug("items saved to database");
//    }
}