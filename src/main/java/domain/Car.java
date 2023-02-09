package domain;

public class Car {

  private final String name;
  private int position = 1;

  public static final int MIN_MOVE_NUM = 4;

  public Car(String name) {
    this.name = name;
  }

  public void move(int num){
    if(num >= MIN_MOVE_NUM) position++;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}

