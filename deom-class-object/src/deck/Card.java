package deck;

import java.math.BigDecimal;

public class Card {
  
  // private String suit;
  // private String rank;
  private Suit suit;
  private Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public Rank getRank() {
    return this.rank;
  }

  // Coding Style: Early Return (盡早return exceptional case)
  // when the method is defined small enough
  public boolean isCardHigherThan(Card card) {
    // compare rank first, if they are equal, then compare suit
    if (this.rank.isRankHigherThan(card.getRank()))
      return true; // exit method
    if (this.rank == card.getRank() && this.suit.isSuitHigherThan(card.getSuit()))
      return true;
    return false; // base condition ("most likely" fall into)
  }

  public String toString() {
    return "Suit: " + this.suit + ", Rank: " + this.rank;
  }

  public static void main(String[] args) {
    // Coding Style: Early Return
    // else if (including "OR" logic): not safe
    // int x = 3;
    // if (x > 3) { // x = 3, will not jump to else if (x > 4)
    //   System.out.println("x > 3");
    // } else if (x > 4) {
    //   System.out.println("x > 4");
    // }

    System.out.println(new Card(Suit.CLUB, Rank.NINE).isCardHigherThan(new Card(Suit.CLUB, Rank.TEN))); // false
    System.out.println(new Card(Suit.CLUB, Rank.NINE).isCardHigherThan(new Card(Suit.DIAMOND, Rank.NINE))); // true
  }
}
