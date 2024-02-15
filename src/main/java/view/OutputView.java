package view;

import constant.Information;
import java.util.List;
import model.Car;
import model.MoveStatus;

public class OutputView {
  private static final String DELIMITER = " : ";
  public void printResultComment() {
    System.out.println(System.lineSeparator() + Information.RESULT_COMMENT);
  }

  public void printResult(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + DELIMITER + MoveStatus.join("", car.getStatuses()));
    }
    System.out.println();
  }

  public void printWinner(List<Car> cars) {
    System.out.println(
        String.format(Information.WINNER.toString(), String.join(", ", cars.stream().map(Car::getName).toList())));
  }


}
