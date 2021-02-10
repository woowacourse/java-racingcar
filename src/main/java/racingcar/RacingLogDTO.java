package racingcar;

import racingcar.domain.Car;

public class RacingLogDTO {

  private String name;
  private int position;

  public RacingLogDTO(Car car) {
    this.name = car.name();
    this.position = car.position();
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public boolean hasSamePosition(int position) {
    return this.position == position;
  }
}
