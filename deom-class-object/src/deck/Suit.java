package deck;

public enum Suit {
  DIAMOND(1),
  CLUB(2),
  HEART(3),
  SPADE(4),
  ;

  private final int suitRanking;

  private Suit(int suitRanking) {
    this.suitRanking = suitRanking;
  }

  public int getSuitRanking() {
    return this.suitRanking;
  }

  // Most of the instance methods should refer to "this"
  // If there is no "this" keyword in your method
  // then probably you should consider to use "static method"
  public boolean isSuitHigherThan(Suit suit) {
    return this.suitRanking > suit.getSuitRanking();
  }

  public static void main(String[] args) {
    // why do we have isSuitHigherThan()?
    Suit currentSuit = Suit.CLUB;
    Suit targetSuit = Suit.DIAMOND;
    if (currentSuit.isSuitHigherThan(targetSuit)) {

    }
  }
}
