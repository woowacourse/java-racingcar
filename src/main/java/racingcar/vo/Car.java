package racingcar.vo;

import static racingcar.util.RandomUtil.generateRandomNumber;
import static racingcar.util.MovementUtil.isMoveForward;

public class Car implements Comparable<Car> {

  private static final String RESULT_DELIMITER = " : ";
  private static final int SAME_POSITION = 0;

  private CarName name;
  private Position position;

  public Car(CarName carName) {
    this.name = carName;
    this.position = new Position();
  }

  public CarName getName() {
    return name;
  }

  @Override
  public String toString() {
    return name.get() + RESULT_DELIMITER + position.toString();
  }

  @Override
  public int compareTo(Car car) {
    return position.compareTo(car.position);
  }

  public boolean isSameName(Car car) {
    return car.name.equals(this.name);
  }

  public boolean isSamePosition(Car car) {
    return position.compareTo(car.position) == SAME_POSITION;
  }

  // FIXME move의 테스트를 generateRandomNumber() 때문에 하지 못하고 있는데 해결방법은 없는가?
  public boolean move() {
    if (isMoveForward(generateRandomNumber())) {
      position.increase();
      return true;
    }
    return false;
  }
}
