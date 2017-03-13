package com.gildedrose.strategy;

import com.gildedrose.item.ItemWrapper;

/**
 * Created by bauer on 11.03.17.
 */
public class BackstagePassesStrategy extends AStrategy {

    public BackstagePassesStrategy() {

        this.delta = 1;
    }

    @Override
    public void update(ItemWrapper itemWrapper) {

        // decrease the sellIn value
        itemWrapper.setSellIn(itemWrapper.getSellIn() - 1);

        // cache the current sellIn value
        int currentSellIn = itemWrapper.getSellIn();

        adaptDelta(currentSellIn);

        if (delta < 0) {
            itemWrapper.setQuality(0);
            return;
        }

        // cache the current quality
        int currentQuality = itemWrapper.getQuality();

        // check the quality against the bounds first
        if (this.isQualityWithinLimits(currentQuality)) {

            // update the quality
            itemWrapper.setQuality(this.getValidQuality(currentQuality + delta));
        }
    }

    private void adaptDelta(int sellIn) {

        if (sellIn <= 10)
            delta = 2;

        if (sellIn <= 5)
            delta = 3;

        if (sellIn <= 0)
            delta = -1; // a negative value is invalid for BackstagePassesStrategy and used as indicator only
    }
}
