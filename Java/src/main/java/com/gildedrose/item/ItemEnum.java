package com.gildedrose.item;

/**
 * Created by bauer on 11.03.17.
 */
public enum ItemEnum {

    BRIE("Aged Brie"),
    DEXTERITY("+5 Dexterity Vest"),
    ELEXIR("Elixir of the Mongoose"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGEPASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake");

    String title;

    ItemEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
