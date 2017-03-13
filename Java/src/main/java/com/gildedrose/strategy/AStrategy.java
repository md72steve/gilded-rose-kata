package com.gildedrose.strategy;

import com.gildedrose.item.ItemWrapper;

/**
 * Created by bauer on 10.03.17.
 */
abstract public class AStrategy implements IStrategy {

    // per default the quality decreases by 1
    protected int delta = -1;

    // upper and lower quality limits
    protected int maxQuality = 50;
    protected int minQuality = 0;

    /**
     * Validates the quality against the minimum and maximum limit
     *
     * @param quality
     * @return
     */
    protected boolean isQualityWithinLimits(int quality) {

        return quality >= minQuality && quality <= maxQuality;
    }

    protected int getValidQuality(int newQuality) {

        int validQuality = newQuality;

        if (newQuality > maxQuality)
            validQuality = maxQuality;

        if (newQuality < minQuality)
            validQuality = minQuality;

        return validQuality;
    }


    public int getMaxQuality() {

        return maxQuality;
    }

    public int getMinQuality() {

        return minQuality;
    }
}
