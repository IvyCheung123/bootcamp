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
      int startIdx = new Random().nextInt(Deck.length - 1) + 1;
      int endIdx = new Random().nextInt(Deck.length - startIdx) + startIdx;
      shuffleCards = new Card[Deck.length];
      int count = 0;
      for (int j = startIdx; j <= endIdx; j++) {
        shuffleCards[count++] = this.cards[j];
      }
      for (int j = 0; j < startIdx; j++) {
        shuffleCards[count++] = this.cards[j];
      }
      for (int j = endIdx + 1; j < Deck.length; j++) {
        shuffleCards[count++] = this.cards[j];
      }
      this.cards = shuffleCards;
    }
  }
  
}
