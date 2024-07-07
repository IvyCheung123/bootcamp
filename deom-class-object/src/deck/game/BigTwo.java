package deck.game;

import deck.Card;
import deck.Deck;

public class BigTwo {

  public static boolean isPourKind(Card[] cards) {
    return false;
  }

  public static boolean isStraight(Card[] cards) {
    return false;
  }

  public static boolean isFullHouse(Card[] cards) {
    return false;
  }

  public static boolean isRoyalFlush(Card[] cards) {
    return false;
  }

  public static void main(String[] args) {
    // Problem 1: How to design 2 Joker Card in the classes? (Parent Class / interface)
    Deck deck = new Deck(); // 52? rank?

    // Problem 2: How to handle the ranking in BigTwo? Rank.TWO is the highest
  }
}
