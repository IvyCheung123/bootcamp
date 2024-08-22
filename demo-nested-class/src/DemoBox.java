import java.util.LinkedList;
import java.util.List;

public class DemoBox {
  private List<Ball> balls;
  private int value;

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
    public void setValue(int value) {
      DemoBox.this.value = value;
    }
    
    public int getValue() {
      return DemoBox.this.value;
    }
  }
}
