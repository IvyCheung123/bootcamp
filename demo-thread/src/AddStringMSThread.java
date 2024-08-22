import java.util.ArrayList;
import java.util.List;

public class AddStringMSThread extends Thread {
  // Class will 佔據 harddisk RAM -> will be re-use
  private List<String> strings = new ArrayList<>();

  public List<String> getStrings() {
    return this.strings;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1_000_000; i++) {
      this.strings.add("hello");
    }
    // but ... thread ends -> this object will disappear
  }
}
