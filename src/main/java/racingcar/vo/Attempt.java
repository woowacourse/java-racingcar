package racingcar.vo;

public class Attempt {

  public static final String NUMBER_FORMAT_ERROR_MESSAGE = "시도 회수는 숫자로 입력해야합니다.";
  private int attempt;

  public Attempt(String attempt) {
    validNumberFormat(attempt);
    this.attempt = toInteger(attempt);
  }

  private int toInteger(String string) {
    return Integer.parseInt(string);
  }

  public int get() {
    return attempt;
  }

  public boolean isLeft() {
    return attempt > 0;
  }

  public void decrease() {
    attempt--;
  }

  private void validNumberFormat(String attempt) {
    try {
      Integer.parseInt(attempt);
    } catch (NumberFormatException numberFormatException) {
      throw new RuntimeException(NUMBER_FORMAT_ERROR_MESSAGE);
    }
  }
}
