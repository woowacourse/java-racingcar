package racingcar.domain;

import racingcar.exception.RacingCarErrorMessage;

public class Name {

  private static final int MIN_NAME_LENGTH = 1;
  private static final int MAX_NAME_LENGTH = 5;
  private final String name;

  public Name(final String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(final String name) {
    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
      throw new IllegalStateException(RacingCarErrorMessage.CAR_NAME.getMessage());
    }
  }

  public String getName() {
    return name;
  }
}
