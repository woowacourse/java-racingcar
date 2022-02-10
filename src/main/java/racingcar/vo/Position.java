package racingcar.vo;

public class Position {

  private int position;

  public Position() {
    position = 0;
  }

  public void increase() {
    position++;
  }

  public int get() {
    return position;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < position; i++) {
      builder.append("-");
    }
    return builder.toString();
  }
}
