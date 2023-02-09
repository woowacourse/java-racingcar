package view;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

  private final String BAR = "-";

  public void printCarsStatus(List<Car> cars){
    cars.stream()
        .forEach(this::printCarStatus);
  }

  private void printCarStatus(Car car) {
    System.out.println(car.getName() + " : " + toBar(car.getPosition()));
  }

  private String toBar(int count) {
    return BAR.repeat(count);
  }
}