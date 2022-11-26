class GildedRose {

  static final String AGED_BRIE = "Aged Brie";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {

      if (SULFURAS.equals(item.name)) {
        // Do nothing
      } else if (AGED_BRIE.equals(item.name)) {
        if (item.quality < 50) {
          if (item.sellIn > 0) {
            item.quality = item.quality + 1;
          } else {
            item.quality = item.quality + 2;
          }
        }
        item.sellIn = item.sellIn - 1;
      } else if (BACKSTAGE_PASSES.equals(item.name)) {
        if (item.sellIn <= 0) {
          item.quality = 0;
        } else {
          if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }
            if (item.sellIn < 6) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }
          }
        }
        item.sellIn = item.sellIn - 1;
      } else {
        if (item.quality > 0) {
          if (item.sellIn > 0) {
            item.quality = item.quality - 1;
          } else {
            item.quality = item.quality - 2;
          }
        }
        item.sellIn = item.sellIn - 1;
      }
    }

  }
}
