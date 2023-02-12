package view;

import domain.Car;
import java.util.List;

public class OutputView {

  private final String DELIMITER = ", ";
  private final String BAR = "-";

  public void printStart(List<Car> cars) {
    System.out.println();
    System.out.println("실행 결과");
    printCarsStatus(cars);
  }

  public void printCarsStatus(List<Car> cars) {
    cars.forEach(this::printCarStatus);
    System.out.println();
  }

  private void printCarStatus(Car car) {
    System.out.printf("%s : %s\n", car.getName(), toBar(car.getPosition()));
  }

  private String toBar(int count) {
    return BAR.repeat(count);
  }

  public void printWinners(List<String> carNames) {
    String result = carNames.get(0);
    boolean isCoWinner = carNames.size() > 1;
    if (isCoWinner) {
      result = String.join(DELIMITER, carNames);
    }
    System.out.printf("%s가 최종 우승했습니다.", result);
  }

  public void printErrorMessage(Exception exception) {
    System.out.println(exception.getMessage());
  }
}
