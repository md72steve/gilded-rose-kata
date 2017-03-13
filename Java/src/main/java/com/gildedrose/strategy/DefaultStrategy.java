package com.gildedrose.strategy;

import com.gildedrose.item.ItemWrapper;

/**
 * Created by bauer on 10.03.17.
 */
public class DefaultStrategy extends AStrategy {

    @Override
    public void update(ItemWrapper itemWrapper) {

        // cache the current quality
        int currentQuality = itemWrapper.getQuality();

        // decrease the sellIn value
        itemWrapper.setSellIn(itemWrapper.getSellIn() - 1);

        // check the quality limits first
        if (this.isQualityWithinLimits(currentQuality)) {

            // update the quality
            itemWrapper.setQuality(this.getValidQuality(currentQuality + delta));
        }
    }
}
