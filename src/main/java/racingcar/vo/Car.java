package racingcar.vo;

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
}
