package racingcar.exception;

public enum RacingCarErrorMessage {
  CAR_NAME_LENGTH("자동차의 이름은 1글자 이상 5글자 이하이어야 합니다."),
  ROUND_ONLY_NUMBER("시도 횟수는 1 이상의 자연수이어야 합니다.");
  private String message;

  RacingCarErrorMessage(final String message) {
    this.message = message;
  }

  public String message() {
    return message;
  }
}
