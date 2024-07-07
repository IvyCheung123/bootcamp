package deck;

public class Card {
  
  // private String sult;
  // private String rank;
  private Sult sult;
  private Rank rank;

  public Card(Sult sult, Rank rank) {
    this.sult = sult;
    this.rank = rank;
  }

  public Sult getSult() {
    return this.sult;
  }

  public Rank getRank() {
    return this.rank;
  }

  // Coding Style: Early Return (盡早return exceptional case)
  // when the method is defined small enough
  public boolean isCardHigherThan(Card card) {
    // compare rank first, if they are equal, then compare sult
    if (this.rank.isRankHigherThan(card.getRank()))
      return true; // exit method
    if (this.rank == card.getRank() && this.sult.isSultHigherThan(card.getSult()))
      return true;
    return false; // base condition ("most likely" fall into)
  }

  public String toString() {
    return "Sult: " + this.sult + ", Rank: " + this.rank;
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

    System.out.println(new Card(Sult.CLUB, Rank.NINE).isCardHigherThan(new Card(Sult.CLUB, Rank.TEN))); // false
    System.out.println(new Card(Sult.CLUB, Rank.NINE).isCardHigherThan(new Card(Sult.DIAMOND, Rank.NINE))); // true
  }
}
