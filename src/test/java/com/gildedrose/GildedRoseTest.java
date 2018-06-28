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

}