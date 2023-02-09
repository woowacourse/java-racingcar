package view;

import domain.Car;
import java.util.List;

public class OutputView {

  private final String DELIMITER = ", ";
  private final String BAR = "-";

  public void printStart(List<Car> cars) {
    System.out.println("실행 결과");
    printCarsStatus(cars);
  }

  public void printCarsStatus(List<Car> cars) {
    cars.forEach(this::printCarStatus);
    printNewLine();
  }

  private void printCarStatus(Car car) {
    System.out.printf("%s : %s\n", car.getName(), toBar(car.getPosition()));
  }

  private String toBar(int count) {
    return BAR.repeat(count);
  }

  private void printNewLine(){
    System.out.println();
  }

  public void printWinners(List<String> carNames) {
    String result = carNames.get(0);
    if (carNames.size() > 1) {
      result = String.join(DELIMITER, carNames);
    }
    System.out.printf("%s가 최종 우승했습니다.", result);
  }

}