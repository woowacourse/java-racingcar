package racingcar.domain;

import java.util.Objects;

public class Round {

  private static final int MIN_ROUND = 1;
  private final int round;

  public Round(final int round) {
    if (round < MIN_ROUND) {
      throw new IllegalStateException("1 이상의 숫자를 입력해주세요.");
    }
    this.round = round;
  }

  public int get() {
    return round;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Round round1 = (Round) o;
    return round == round1.round;
  }

  @Override
  public int hashCode() {
    return Objects.hash(round);
  }
}
