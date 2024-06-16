package demo;

public class StringHelper {
  private String str;

  public StringHelper(String str) {
    this.str = str;
  }

  // Instance method
  /*
  public void setCharAt(int index, char ch) {
    String s = new String("");
    for (int i = 0; i < this.str.length(); i++) {
      if (i == index) {
        s += ch;
      } else {
        s += this.str.charAt(i);
      }
    }
    this.str = s;
  }
  */

  // return StringHelper object
  public StringHelper setCharAt(int index, char ch) {
    String s = new String("");
    for (int i = 0; i < this.str.length(); i++) {
      if (i == index) {
        s += ch;
      } else {
        s += this.str.charAt(i);
      }
    }
    this.str = s;
    return this;
  }

  public StringHelper append(String s) {
    this.str += s;
    return this;
  }

  public String subString(int startIdx, int endIdx) {
    String s = new String("");
    for (int i = startIdx; i < endIdx; i++) {
      s += this.str.charAt(i);
    }
    return s;
  }

  public String toString() {
    return this.str;
  }

  public static void main(String[] args) {
    StringHelper sh = new StringHelper("hello");

    sh.setCharAt(4, 'A');
    System.out.println(sh.toString()); // hellA

    sh.append("world");
    System.out.println(sh.toString()); // hellAworld

    sh.append("!!!").append(" This is Java.").setCharAt(4, 'o');
    System.out.println(sh.toString()); // helloworld!!! This is Java.

    System.out.println(sh.subString(2, 5)); // llo
  }
}
