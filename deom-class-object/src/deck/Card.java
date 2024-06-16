package deck;

public class Card {
  private String sult;
  private String rank;

  public Card(String sult, String rank) {
    this.sult = sult;
    this.rank = rank;
  }

  public String getSult() {
    return this.sult;
  }

  public String getRank() {
    return this.rank;
  }

  public String toString() {
    return "Sult: " + this.sult + ", Rank: " + this.rank;
  }

  public static void main(String[] args) {
    Deck deck = new Deck();
    /*
    Card[] cards = deck.getCards();
    for (Card card : cards) {
      System.out.println(card);
    }
    */

    // deck.shuffle(1000);
    new ShuffleManager(deck.getCards()).shuffle(100);

    for (Card card : deck.getCards()) {
      System.out.println(card);
    }
  }
}
