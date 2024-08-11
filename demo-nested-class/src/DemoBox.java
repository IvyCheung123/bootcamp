import java.util.LinkedList;
import java.util.List;

public class DemoBox {
  private List<Ball> balls;
  private int capacity;

  public DemoBox() {
    balls = new LinkedList<>();
  }

  public List<Ball> getBalls() {
    return this.balls;
  }

  public void add(Ball ball) {
    balls.add(ball);
  }

  public class Ball {
    public int getCapacity() {
      return capacity;
    }
  }
}
