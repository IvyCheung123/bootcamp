package deck.game;

public enum BigTwoRank {
  THREE(1),
  FOUR(2),
  FIVE(3),
  SIX(4),
  SEVEN(5),
  EIGHT(6),
  NINE(7),
  TEN(8),
  JACK(9),
  QUEEN(10),
  KING(11),
  ACE(12),
  TWO(13),
  ;

  private int bigTwoRankRanking;

  private BigTwoRank(int bigTwoRankRanking) {
    this.bigTwoRankRanking = bigTwoRankRanking;
  }

  public int getBigTwoRankRanking() {
    return this.bigTwoRankRanking;
  }

  public boolean isBigTwoRankHigherThan(BigTwoRank bigTwoRank) {
    return this.bigTwoRankRanking > bigTwoRank.getBigTwoRankRanking();
  }
}
