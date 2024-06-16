package deck;

import java.util.Random;

public class ShuffleManager {

  // Attribute / Dependency
  private Card[] cards;

  public ShuffleManager(Card[] cards) {
    this.cards = cards;
  }

  public Card[] getCards() {
    return this.cards;
  }

  // Behavior
  public void shuffle(int times) {
    Card[] shuffleCards = null;
    for (int i = 0; i < times; i++) {
      int index = new Random().nextInt(Deck.length); // 0 - 51
      System.out.println("Random Index = " + index);
      shuffleCards = new Card[Deck.length];
      int count = 0;
      for (int j = index; j < Deck.length; j++) {
        shuffleCards[count++] = this.cards[j];
      }
      for (int j = 0; j < index; j++) {
        shuffleCards[count++] = this.cards[j];
      }
      this.cards = shuffleCards;
    }
  }
}
