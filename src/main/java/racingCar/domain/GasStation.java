package racingCar.domain;

import java.util.function.Supplier;

public class GasStation {

  private Supplier<Integer> supplier;

  public GasStation(Supplier<Integer> supplier) {
    this.supplier = supplier;
  }

  public void fillInFuel(Car car) {
    car.fillInFuel(supplier.get());
  }
}
