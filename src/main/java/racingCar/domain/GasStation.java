package racingCar.domain;

import java.util.function.Supplier;

public class GasStation {

  private final Supplier<Integer> supplier;

  public GasStation(final Supplier<Integer> supplier) {
    this.supplier = supplier;
  }

  public void fillInFuel(final Car car) {
    car.fillInFuel(supplier.get());
  }
}
