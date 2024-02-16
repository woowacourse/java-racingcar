package racing.domain;

import java.util.regex.Pattern;

public class CarNameValidator {

  private static final int MIN_NAME_LENGTH = 1;
  private static final int MAX_NAME_LENGTH = 5;

  public static void validate(String name) {
    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
      throw new RuntimeException("이름의 길이는 1 이상 5 이하여야 합니다.");
    }
    if (!Pattern.matches("^[a-zA-Z]+$", name)) {
      throw new RuntimeException("이름은 알파벳 대소문자로만 이루어져야 합니다.");
    }
  }
}
