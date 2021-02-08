package racingcar.view;

import java.util.Scanner;
import racingcar.domain.Participants;
import racingcar.domain.Round;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String GET_TURN_MESSAGE = "시도할 횟수는 몇회인가요?";
  private static final String NAME_DELIMITER = ",";

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

  public static Round getRound() {
    try {
      OutputView.printMessage(GET_TURN_MESSAGE);
      return new Round(Integer.parseInt(scanner.nextLine().trim()));
    } catch (NumberFormatException | IllegalStateException e) {
      OutputView.printMessage("1 이상의 숫자를 입력해주세요.");
      return getRound();
    }
  }
}
