package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import racing.domain.CarNameValidator;

public class CarNameInputView {

  private static final String SEPARATOR = ",";

  public static List<String> getName(Supplier<String> inputSupplier) {
    String input = inputSupplier.get();
    validateSeparator(input);
    validateEachName(input);
    return Arrays.stream(input.split(SEPARATOR)).toList();
  }

  private static void validateSeparator(String input) {
    boolean startsWithSeparator = input.startsWith(SEPARATOR);
    boolean endsWithSeparator = input.endsWith(SEPARATOR);
    if (startsWithSeparator || endsWithSeparator) {
      throw new RuntimeException("이름의 길이는 1 이상 5 이하여야 합니다.");
    }
  }

  private static void validateEachName(String input) {
    Arrays.stream(input.split(SEPARATOR))
        .forEach(CarNameValidator::validate);
  }
}
