package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemEnum;
import com.gildedrose.item.ItemWrapper;
import com.gildedrose.strategy.StrategyFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by bauer on 11.03.17.
 */
public class GildedRoseRefactoredTest {

    private List<ItemWrapper> itemWrapperList = new ArrayList<>();


    @Before
    public void init() {

        // special update strategy for Aged Brie
        itemWrapperList.add(
                new ItemWrapper(
                        new Item(ItemEnum.BRIE.getTitle(), 2, 0),
                        StrategyFactory.createStrategy(ItemEnum.BRIE)
                )
        );

        itemWrapperList.add(
                new ItemWrapper(
                        new Item(ItemEnum.BRIE.getTitle(), 2, 50),
                        StrategyFactory.createStrategy(ItemEnum.BRIE)
                )
        );

        // default strategy for Dexterity Vest
        itemWrapperList.add(
                new ItemWrapper(
                        new Item(ItemEnum.DEXTERITY.getTitle(), 10, 0),
                        StrategyFactory.createStrategy(ItemEnum.DEXTERITY)
                )
        );

        itemWrapperList.add(
                new ItemWrapper(
                        new Item(ItemEnum.DEXTERITY.getTitle(), 10, 50),
                        StrategyFactory.createStrategy(ItemEnum.DEXTERITY)
                )
        );

        // special update strategy for backstage passes
        itemWrapperList.add(
                new ItemWrapper(
                        new Item(ItemEnum.BACKSTAGEPASSES.getTitle(), 5, 49),
                        StrategyFactory.createStrategy(ItemEnum.BACKSTAGEPASSES)
                )
        );

        System.out.println();
        System.out.println();
    }

    /**
     * Checks against the bounds
     */
    @Test
    public void qualityShouldAlwaysStayInBounds() {

        int minQuality = 0;
        int maxQuality = 0;

        System.out.println("-- check lower and upper bounds for all udpate stratgies --");

        for (ItemWrapper iw : itemWrapperList) {

            System.out.print(iw + " --> ");

            // caching the min and max quality
            minQuality = iw.getStrategy().getMinQuality();
            maxQuality = iw.getStrategy().getMaxQuality();

            iw.update();

            assertTrue("quality should always be lower or equal maxQuality", iw.getQuality() <= maxQuality);
            assertTrue("quality should always be greater or equal minQuality", iw.getQuality() >= minQuality);

            System.out.println(iw);
        }
    }

    @Test
    public void qualityShouldIncreaseByTwoWhenSellInBetween10And5() {

        int quality = 20;

        ItemWrapper itemWrapper = new ItemWrapper(
                new Item(ItemEnum.BACKSTAGEPASSES.getTitle(), 10, quality),
                StrategyFactory.createStrategy(ItemEnum.BACKSTAGEPASSES)
        );

        itemWrapper.update();

        assertTrue("quality should increase by 2", itemWrapper.getQuality() == quality + 2);
    }

    @Test
    public void qualityShouldIncreaseByThreeWhenSellInBetween5And1() {

        int quality = 20;

        ItemWrapper itemWrapper = new ItemWrapper(
                new Item(ItemEnum.BACKSTAGEPASSES.getTitle(), 5, quality),
                StrategyFactory.createStrategy(ItemEnum.BACKSTAGEPASSES)
        );

        itemWrapper.update();

        assertTrue("quality should increase by 3", itemWrapper.getQuality() == quality + 3);
    }


    @Test
    public void qualityShouldFallBackToZeroAtPassedSellin() {

        ItemWrapper itemWrapper = new ItemWrapper(
                new Item(ItemEnum.BACKSTAGEPASSES.getTitle(), 1, 20),
                StrategyFactory.createStrategy(ItemEnum.BACKSTAGEPASSES)
        );

        itemWrapper.update();

        assertTrue("quality should fall back to zero when sellIn is zero", itemWrapper.getQuality() == 0);
    }
}
