package deck;

public class Deck {
  // Player, Deck, Card
  private static String[] sults = new String[] {"Diamond", "Club", "Heart", "Spade"};
  private static String[] ranks = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

  public static int length = sults.length * ranks.length;

  private Card[] cards;

  public Deck() {
    this.cards = new Card[length];
    int index = 0;
    for (String sult : sults) {
      for (String rank : ranks) {
        this.cards[index++] = new Card(sult, rank);
      }
    }
  }

  public void shuffle(int times) {
    ShuffleManager sm = new ShuffleManager(getCards());
    sm.shuffle(times);
    this.cards = sm.getCards();
  }

  public Card[] getCards() {
    return this.cards;
  }

  public static void main(String[] args) {
    Deck deck = new Deck();
    /*
    Card[] cards = deck.getCards();
    for (Card card : cards) {
      System.out.println(card);
    }
    */

    deck.shuffle(100);
    // new ShuffleManager(deck.getCards()).shuffle(100);
    System.out.println("Card[] after shuffle(): ");
    for (Card card : deck.getCards()) {
      System.out.println(card);
    }
  }

}
