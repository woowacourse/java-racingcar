package view;

import constant.Information;
import java.util.List;
import model.Car;
import model.CarStatus;

public class OutputView {
  private static final String DELIMITER = " : ";
  public void printResultComment() {
    System.out.println(Information.RESULT_COMMENT);
  }

  public void printResult(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + DELIMITER + printResultDetail(car.getStatuses()));
    }
    System.out.println();
  }

  public void printWinner(List<Car> cars) {
    System.out.println(
        String.format(Information.WINNER.toString(), String.join(", ", cars.stream().map(Car::getName).toList())));
  }

  private String printResultDetail(List<CarStatus> carStatuses) {
    return String.join("", carStatuses.stream().map(CarStatus::getOutput).toList());
  }
}
