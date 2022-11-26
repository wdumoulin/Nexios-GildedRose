import java.util.Arrays;

class GildedRose {

  static final String AGED_BRIE = "Aged Brie";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    Arrays.stream(items).forEach(item -> {
      switch (item.name) {
        case SULFURAS -> updateSulfuras(item);
        case AGED_BRIE -> updateAgedBrie(item);
        case BACKSTAGE_PASSES -> updateBackstagePasses(item);
        default -> updateRegularItem(item);
      }
    });
  }

  private void updateSulfuras(Item item) {

  }

  private void updateAgedBrie(Item item) {
    if (item.sellIn > 0) {
      increaseQualityBy(item, 1);
    } else {
      increaseQualityBy(item, 2);
    }
    item.sellIn -= 1;
  }

  private void updateBackstagePasses(Item item) {
    if (item.sellIn > 10) {
      increaseQualityBy(item, 1);
    } else if (item.sellIn > 5) {
      increaseQualityBy(item, 2);
    } else if (item.sellIn > 0) {
      increaseQualityBy(item, 3);
    } else {
      decreaseQualityBy(item, item.quality);
    }
    item.sellIn -= 1;
  }

  private void updateRegularItem(Item item) {
    if (item.sellIn > 0) {
      decreaseQualityBy(item, 1);
    } else {
      decreaseQualityBy(item, 2);
    }
    item.sellIn -= 1;
  }

  private void increaseQualityBy(Item item, int quality) {
    if (item.quality < 50) {
      item.quality += quality;
    }
  }

  private static void decreaseQualityBy(Item item, int quality) {
    if (item.quality > 0) {
      item.quality -= quality;
    }
  }
}
