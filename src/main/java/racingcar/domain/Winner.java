package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

  private static final String WINNER_NAME_DELIMITER = ", ";
  private final Participants participants;

  public Winner(final Participants participants) {
    this.participants = participants;
  }

  public String winnerName() {
    return winner().stream()
        .map(Car::name)
        .collect(Collectors.joining(WINNER_NAME_DELIMITER));
  }
  private List<Car> winner() {
    return participants.winner();
  }
}

