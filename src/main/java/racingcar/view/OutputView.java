package racingcar.view;

import racingcar.vo.Winners;

public class OutputView {

  public static void printRaceResult(String raceResult) {
    System.out.print(raceResult);
  }

  public static void printWinners(Winners winners) {
    System.out.print(winners.toString());
  }
}
