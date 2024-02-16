package view;

import common.Information;
import java.util.List;
import model.Car;
import model.MoveStatus;

public class OutputView {
  private static final String DELIMITER = " : ";

  public void printResultComment() {
    System.out.println(System.lineSeparator() + Information.RESULT_COMMENT.getMessage());
  }

  public void printResult(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + DELIMITER + MoveStatus.join("", car.getStatuses()));
    }
    System.out.println();
  }

  public void printWinner(List<Car> cars) {
    String winnersName = String.join(", ", cars.stream().map(Car::getName).toList());
    System.out.printf((Information.WINNER.getMessage()) + "%n", winnersName);
  }
}
