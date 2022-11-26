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
    if (item.quality < 50) {
      if (item.sellIn > 0) {
        item.quality += 1;
      } else {
        item.quality += 2;
      }
    }
    item.sellIn -= 1;
  }

  private void updateBackstagePasses(Item item) {
    if (item.sellIn <= 0) {
      item.quality = 0;
    } else {
      if (item.quality < 50) {
        item.quality += 1;
        if (item.sellIn < 11) {
          if (item.quality < 50) {
            item.quality += 1;
          }
        }
        if (item.sellIn < 6) {
          if (item.quality < 50) {
            item.quality += 1;
          }
        }
      }
    }
    item.sellIn -= 1;
  }

  private void updateRegularItem(Item item) {
    if (item.quality > 0) {
      if (item.sellIn > 0) {
        item.quality -= 1;
      } else {
        item.quality -= 2;
      }
    }
    item.sellIn -= 1;
  }
}
