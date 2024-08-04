package deck.game;

import deck.Card;
import deck.Deck;
import deck.Rank;
import deck.Suit;

public class BigTwo extends Card {

  private Suit suit;
  private Rank rank;

  public BigTwo(Suit suit, Rank rank) {
    super(suit, rank);
  }

  public static boolean isFourKind(Card[] cards) {
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
