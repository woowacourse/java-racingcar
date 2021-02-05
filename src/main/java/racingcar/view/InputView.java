package racingcar.view;

import java.util.Scanner;
import racingcar.domain.GasStation;
import racingcar.domain.Participants;
import racingcar.domain.RacingManager;
import racingcar.exception.RacingCarErrorMessage;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String GET_TURN_MESSAGE = "시도할 횟수는 몇회인가요?";
  private static final String NAME_DELIMITER = ",";
  private static final int MIN_TURN = 1;

  public static Participants getNames() {
    try {
      OutputView.printMessage(GET_CAR_NAME_MESSAGE);
      String names = scanner.nextLine().trim();
      return new Participants(names.split(NAME_DELIMITER));
    } catch (IllegalStateException e) {
      OutputView.printMessage(e.getMessage());
      return getNames();
    }
  }

  public static int getTurn() {
    try {
      OutputView.printMessage(GET_TURN_MESSAGE);
      int turn = Integer.parseInt(scanner.nextLine().trim());
      validateTurn(turn);
      return turn;
    } catch (NumberFormatException | IllegalStateException e) {
      OutputView.printMessage(RacingCarErrorMessage.TURN.getMessage());
      return getTurn();
    }
  }

  private static void validateTurn(int turn) {
    if (turn < MIN_TURN) {
      throw new IllegalStateException(RacingCarErrorMessage.TURN.getMessage());
    }
  }
}
