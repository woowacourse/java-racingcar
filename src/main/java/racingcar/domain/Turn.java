package racingcar.domain;

import racingcar.exception.RacingCarErrorMessage;

public class Turn {
  private static final int MIN_TURN = 1;
  private final int turn;

  public Turn(final int turn) {
    validateTurn(turn);
    this.turn = turn;
  }

  private void validateTurn(final int turn) {
    if (turn < MIN_TURN) {
      throw new IllegalStateException(RacingCarErrorMessage.TURN.getMessage());
    }
  }

  public int get() {
    return turn;
  }
}
