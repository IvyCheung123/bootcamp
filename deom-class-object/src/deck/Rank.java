package deck;

public enum Rank {
  ACE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13),
  ;

  private int rankRanking;

  private Rank(int rankRanking) {
    this.rankRanking = rankRanking;
  }

  public int getRankRanking() {
    return this.rankRanking;
  }

  public boolean isRankHigherThan(Rank rank) {
    return this.rankRanking > rank.getRankRanking();
  }
}
