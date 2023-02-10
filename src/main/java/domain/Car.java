package domain;

public class Car implements Comparable<Car> {

  private final String name;
  private final int MIN_MOVE_NUM = 4;

  private int position;

  public Car(String name) {
    this.name = name;
    this.position = 1;
  }

  public void move(int num) {
    if (num >= MIN_MOVE_NUM) {
      position++;
    }
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  @Override
  public int compareTo(Car o) {
    return position - o.position;
  }
}

