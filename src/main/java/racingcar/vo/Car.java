package racingcar.vo;

import static racingcar.util.RandomUtil.createNumber;
import static racingcar.util.MovementUtil.isMoveForward;

public class Car {

  private CarName name;
  private Position position;

  public Car(CarName carName) {
    this.name = carName;
    this.position = new Position();
  }

  public boolean isSameName(Car car) {
    return car.name.equals(this.name);
  }

  public void move() {
    if (isMoveForward(createNumber())) {
      position.increase();
    }
  }
}
