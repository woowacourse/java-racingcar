package racing.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CarNameInputManager {

  public static List<String> getNameFromConsole(Scanner scanner) {
    String input = scanner.next();
    return getName(input);
  }

  static List<String> getName(String input) {
    validateEachNameLength(input);
    validateEachNameCharacters(input);
    return Arrays.stream(input.split(",")).toList();
  }

  private static void validateEachNameLength(String input) {
    boolean startsWithSeparator = input.startsWith(",");
    boolean endsWithSeparator = input.endsWith(",");
    boolean isWrongNameLength = Arrays.stream(input.split(","))
        .anyMatch(s -> s.length() < 1 || s.length() > 5);
    if (isWrongNameLength || startsWithSeparator || endsWithSeparator) {
      throw new RuntimeException("이름의 길이는 1 이상 5 이하여야 합니다.");
    }
  }

  private static void validateEachNameCharacters(String input) {
    boolean hasWrongCharacterInName = Arrays.stream(input.split(","))
        .anyMatch(s -> !Pattern.matches("^[a-zA-Z]+$", s));
    if (hasWrongCharacterInName) {
      throw new RuntimeException("이름은 알파벳 대소문자로만 이루어져야 합니다.");
    }
  }
}
