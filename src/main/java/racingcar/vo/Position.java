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
}
