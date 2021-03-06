package com.gildedrose;

import com.gildedrose.support.VeryImportantObject;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {
    @Test
    public void decreaseQualityOfOrdinaryItemBy2() throws Exception {
        Item item = new Item("Sample Item", 0, 2);
        GildedRose gildedRose = new GildedRose(new VeryImportantObject(null)){
            @Override
            protected void InitializeItems() {
                items = null;
            }

            @Override
            protected void LogMessageDebug(String message) {
            }
        };
        gildedRose.updateItem(item);
        Assert.assertEquals(0,item.quality);
    }

    @Test
    public void given_item_is_aged_brie_and_quality_and_sell_in_is_zero_when_update_item_should_increment_quality_by_2() throws Exception {
        Item item = new Item("Aged Brie", 0, 0);
        GildedRose gildedRose = new GildedRose(new VeryImportantObject(null)){
            @Override
            protected void InitializeItems() {
                items = null;
            }

            @Override
            protected void LogMessageDebug(String message) {
            }
        };
        gildedRose.updateItem(item);
        Assert.assertEquals(2,item.quality);
    }

    @Test
    public void reset_quality_of_item_to_zero_if_it_is_a_ticket_to_a_concert() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 4);
        GildedRose gildedRose = new GildedRose(new VeryImportantObject(null)){
            @Override
            protected void InitializeItems() {
                items = null;
            }

            @Override
            protected void LogMessageDebug(String message) {
            }
        };
        gildedRose.updateItem(item);
        Assert.assertEquals(0,item.quality);
    }

    

}