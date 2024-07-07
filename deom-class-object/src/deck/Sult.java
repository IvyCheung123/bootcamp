package deck;

public enum Sult {
  DIAMOND(1),
  CLUB(2),
  HEART(3),
  SPADE(4),
  ;

  private final int sultRanking;

  private Sult(int sultRanking) {
    this.sultRanking = sultRanking;
  }

  public int getSultRanking() {
    return this.sultRanking;
  }

  // Most of the instance methods should refer to "this"
  // If there is no "this" keyword in your method
  // then probably you should consider to use "static method"
  public boolean isSultHigherThan(Sult sult) {
    return this.sultRanking > sult.getSultRanking();
  }

  public static void main(String[] args) {
    // why do we have isSultHigherThan()?
    Sult currentSult = Sult.CLUB;
    Sult targetSult = Sult.DIAMOND;
    if (currentSult.isSultHigherThan(targetSult)) {

    }
  }
}
