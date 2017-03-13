package com.gildedrose.item;

import com.gildedrose.strategy.AStrategy;
import com.gildedrose.strategy.IStrategy;

/**
 * The ItemWrapper combines an Item with an update strategy.
 * <p>
 * The wrapper class is needed because one of the refactoring rules is "don't touch the Item class"
 */
public class ItemWrapper {

    // the original Item, like 'Aged Brie'
    private Item item;

    // the correspondending update strategy, like 'AgedBrieStrategy'
    private IStrategy strategy;

    public ItemWrapper(Item item, IStrategy iStrategy) {
        this.item = item;
        this.strategy = iStrategy;
    }

    // region getter and setter methods, all calls are delegated to the original item
    public int getSellIn() {

        return this.item.sellIn;
    }

    public int getQuality() {

        return this.item.quality;
    }

    public AStrategy getStrategy() {

        return (AStrategy)this.strategy;
    }

    public void setSellIn(int sellIn) {

        this.item.sellIn = sellIn;
    }

    public void setQuality(int quality) {

        this.item.quality = quality;
    }
    // endregion

    @Override
    public String toString() {

        return this.item.toString();
    }

    public void update() {

        this.strategy.update(this);
    }
}
