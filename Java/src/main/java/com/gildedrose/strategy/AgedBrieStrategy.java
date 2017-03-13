package com.gildedrose.strategy;

import com.gildedrose.item.ItemWrapper;

/**
 * Created by bauer on 10.03.17.
 */
public class AgedBrieStrategy extends AStrategy {

    public AgedBrieStrategy() {

        // Rule: "Aged Brie" actually increases in Quality the older it gets
        this.delta = 1;
    }

    @Override
    public void update(ItemWrapper itemWrapper) {

        // cache the current quality
        int currentQuality = itemWrapper.getQuality();

        // decrease the sellIn value
        itemWrapper.setSellIn(itemWrapper.getSellIn() - 1);

        // check the quality against the bounds first
        if (this.isQualityWithinLimits(currentQuality)) {

            // update the quality
            itemWrapper.setQuality(this.getValidQuality(currentQuality + delta));
        }
    }
}
