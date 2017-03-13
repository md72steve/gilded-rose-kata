package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.item.Item;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {


    private static final int MAX_DAYS = 100;

    private GildedRose app;

    Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)
    };

    @Before
    public void init() {

        app = new GildedRose(items);
    }

    /*@Test
    public void foo() {

        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("fixme", app.items[0].name);
    }*/

    @Test
    public void qualityShouldNeverBeNegative() {

        for (int i = 1; i < MAX_DAYS; i++) {

            app.updateQuality();

            //showAll(i, app.items);

            for (Item item : app.items) {
                assertTrue("quality should never be lower than zero", item.quality >= 0);
            }
        }
    }

    @Test
    public void qualityShouldNeverGreaterThan50() {

        for (int i = 1; i < MAX_DAYS; i++) {

            app.updateQuality();

            //showAll(i, app.items);

            for (Item item : app.items) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    assertTrue("quality should never be greater than 50", item.quality <= 50);
                }
            }
        }
    }


    public void showAll(int day, Item[] items) {

        System.out.printf("\n\nDay %d\n", day);
        for (Item i : items) {
            System.out.println(i);
        }
    }
}
