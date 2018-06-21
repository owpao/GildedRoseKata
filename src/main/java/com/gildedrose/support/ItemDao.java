package com.gildedrose.support;

import com.gildedrose.Item;

public class ItemDao {
    public static boolean DATABASE_READY = false;
    private static Item[] items;


    public static Item[] findAllItems() {
        if (!DATABASE_READY)
            throw new RuntimeException("Database connection error");

        return items;
    }

    public static void save(Item[] items) {
        if (!DATABASE_READY)
            throw new RuntimeException("Database connection error");
    }

    public static void prepareData(Item[] items) {
        ItemDao.items = items;
    }
}
