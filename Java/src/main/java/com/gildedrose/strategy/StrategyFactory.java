package com.gildedrose.strategy;

import com.gildedrose.item.ItemEnum;

/**
 * Created by bauer on 10.03.17.
 */
public class StrategyFactory {

    public static IStrategy createStrategy(ItemEnum itemEnum) {

        IStrategy iStrategy = null;

        switch (itemEnum) {

            case BRIE:
                iStrategy = new AgedBrieStrategy();
                break;

            case DEXTERITY:
            case ELEXIR:
                iStrategy = new DefaultStrategy();
                break;

            case BACKSTAGEPASSES:
                iStrategy =new BackstagePassesStrategy();
                break;
        }

        return iStrategy;
    }
}
