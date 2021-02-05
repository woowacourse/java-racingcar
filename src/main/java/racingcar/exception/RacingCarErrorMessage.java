package racingcar.exception;

public enum RacingCarErrorMessage {
  CAR_NAME("자동차의 이름은 1글자 이상 5글자 이하이어야 합니다."),
  TURN("시도 횟수는 1 이상의 자연수이어야 합니다.");
  private String message;

  RacingCarErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
