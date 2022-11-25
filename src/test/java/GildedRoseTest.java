import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
public class GildedRoseTest {

  @DisplayName("regular items")
  @Nested
  class RegularTestCases {

    @Test
    public void when_sellIn_greater_than_0_and_quality_greater_than_0_decrease_quality_by_1() {
      Item[] items = new Item[]{new Item("foo", 3, 10)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(2);
      assertThat(app.items[0].quality).isEqualTo(9);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(1);
      assertThat(app.items[0].quality).isEqualTo(8);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(7);
    }

    @Test
    public void when_sellIn_greater_than_0_and_quality_0_decrease_quality_by_0() {
      Item[] items = new Item[]{new Item("foo", 3, 0)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(2);
      assertThat(app.items[0].quality).isEqualTo(0);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(1);
      assertThat(app.items[0].quality).isEqualTo(0);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    public void when_sellIn_0_or_less_and_quality_greater_than_0_decrease_quality_by_2() {
      Item[] items = new Item[]{new Item("foo", 0, 7)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-1);
      assertThat(app.items[0].quality).isEqualTo(5);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-2);
      assertThat(app.items[0].quality).isEqualTo(3);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-3);
      assertThat(app.items[0].quality).isEqualTo(1);
    }

    @Test
    public void when_sellIn_0_or_less_and_quality_0_decrease_quality_by_0() {
      Item[] items = new Item[]{new Item("foo", 0, 0)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-1);
      assertThat(app.items[0].quality).isEqualTo(0);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-2);
      assertThat(app.items[0].quality).isEqualTo(0);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-3);
      assertThat(app.items[0].quality).isEqualTo(0);
    }

  }

  @DisplayName("Aged Brie")
  @Nested
  class AgedBrieTestCases {

    @Test
    void when_sellIn_greater_than_0_and_quality_less_than_50_increase_quality_by_1() {
      Item[] items = new Item[]{new Item("Aged Brie", 3, 0)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(2);
      assertThat(app.items[0].quality).isEqualTo(1);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(1);
      assertThat(app.items[0].quality).isEqualTo(2);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(3);
    }

    @Test
    void when_sellIn_greater_than_0_and_quality_50_increase_quality_by_0() {
      Item[] items = new Item[]{new Item("Aged Brie", 3, 50)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(2);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(1);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void when_sellIn_0_or_less_and_quality_less_than_50_increase_quality_by_2() {
      Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-1);
      assertThat(app.items[0].quality).isEqualTo(2);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-2);
      assertThat(app.items[0].quality).isEqualTo(4);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-3);
      assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    void when_sellIn_0_or_less_and_quality_50_increase_quality_by_0() {
      Item[] items = new Item[]{new Item("Aged Brie", 0, 50)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-1);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-2);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-3);
      assertThat(app.items[0].quality).isEqualTo(50);
    }

  }

  @DisplayName("Sulfuras, Hand of Ragnaros")
  @Nested
  class SulfurasTestCases {

    @Test
    void the_hand_is_eternal_and_unchanging() {
      Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(80);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(80);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(80);
    }

  }

  @DisplayName("Backstage passes")
  @Nested
  class BackstagePassesTestCases {

    @Test
    void when_sellIn_greater_than_10_and_quality_less_than_50_increase_quality_by_1() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 13, 0)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(12);
      assertThat(app.items[0].quality).isEqualTo(1);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(11);
      assertThat(app.items[0].quality).isEqualTo(2);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(10);
      assertThat(app.items[0].quality).isEqualTo(3);
    }

    @Test
    void when_sellIn_greater_than_10_and_quality_50_increase_quality_by_0() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 13, 50)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(12);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(11);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(10);
      assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void when_sellIn_10_or_less_and_quality_less_than_50_increase_quality_by_2() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 0)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(7);
      assertThat(app.items[0].quality).isEqualTo(2);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(6);
      assertThat(app.items[0].quality).isEqualTo(4);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(5);
      assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    void when_sellIn_10_or_less_and_quality_50_increase_quality_by_0() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(7);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(6);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(5);
      assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void when_sellIn_5_or_less_and_quality_less_than_50_increase_quality_by_3() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 0)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(2);
      assertThat(app.items[0].quality).isEqualTo(3);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(1);
      assertThat(app.items[0].quality).isEqualTo(6);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void when_sellIn_5_or_less_and_quality_50_increase_quality_by_0() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(2);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(1);
      assertThat(app.items[0].quality).isEqualTo(50);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(0);
      assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void when_sellIn_0_and_quality_less_than_50_increase_quality_to_0() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-1);
      assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void when_sellIn_0_and_quality_50_increase_quality_to_0() {
      Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50)};
      GildedRose app = new GildedRose(items);

      app.updateQuality();

      assertThat(app.items[0].sellIn).isEqualTo(-1);
      assertThat(app.items[0].quality).isEqualTo(0);
    }

  }
}
