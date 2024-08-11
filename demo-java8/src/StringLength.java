import java.util.function.Function;

public class StringLength implements Function<String, Integer> {
  @Override
  // public R apply(T t)
  public Integer apply(String s) {
    return s.length();
  }
}
