package view;

import model.Car;
import model.Cars;
import response.OutputMessage;

public class OutputView {
  private static final String DELIMITER = " : ";
  private static final String FORWARD = "-";

  public void printResultComment() {
    System.out.println(System.lineSeparator() + OutputMessage.RESULT_COMMENT.getMessage());
  }

  public void printResult(Cars cars) {
    for (Car car : cars.participants()) {
      String carStatues = convertToOutput(car.countOfForward());
      System.out.println(car.getName() + DELIMITER + carStatues);
    }
    System.out.println();
  }

  private String convertToOutput(int count) {
    String statues = "";
    for (int i = 0; i < count; i++) {
      statues += FORWARD;
    }
    return statues;
  }

  public void printWinner(Cars cars) {
    String winnersName = String.join(", ", cars.participantsNames());
    System.out.printf((OutputMessage.WINNER.getMessage()) + "%n", winnersName);
  }
}
