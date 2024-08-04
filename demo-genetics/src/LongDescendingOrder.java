import java.util.Comparator;

public class LongDescendingOrder implements Comparator<Long> {
  @Override
  public int compare(Long l1, Long l2) {
    return l2.compareTo(l1); // l2 > l1 = 1
  }
}
