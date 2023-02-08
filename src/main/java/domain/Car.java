package domain;

import java.util.Random;

public class Car {

  private final String name;
  private int position = 0;

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
}

