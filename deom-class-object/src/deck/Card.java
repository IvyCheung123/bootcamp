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

}
