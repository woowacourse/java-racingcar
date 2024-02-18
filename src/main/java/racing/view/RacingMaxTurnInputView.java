package racing.view;

import java.util.function.Supplier;

public class RacingMaxTurnInputView {

  public static int getMaxTurn(Supplier<String> inputSupplier) {
    int parsedNumber = getNumberAsInteger(inputSupplier.get());
    validateNumberSize(parsedNumber);
    return parsedNumber;
  }

  private static void validateNumberSize(int parsedNumber) {
    if (parsedNumber < 1 || parsedNumber > 100) {
      throw new RuntimeException("총 이동 횟수는 1 이상 100이하의 정수만 가능합니다.");
    }
  }

  private static int getNumberAsInteger(String input) {
    int parsedNumber;
    try {
      parsedNumber = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new RuntimeException("총 이동 횟수는 1 이상 100이하의 정수만 가능합니다.");
    }
    return parsedNumber;
  }
}
