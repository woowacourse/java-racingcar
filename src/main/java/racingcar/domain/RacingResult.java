package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

  private static final String ENTER = "\n";
  private static final String LOG_FORM = "%s : %s\n";
  private static final String DISTANCE_SIGN = "-";
  private static final int DEFAULT_MAX_POSITION = 0;
  private final StringBuilder log;
  private final Participants participants;

  public RacingResult(final Participants participants) {
    this.participants = participants;
    this.log = new StringBuilder();
  }

  public void appendLog() {
    participants.cars()
        .forEach(car -> log.append(
            String.format(LOG_FORM, car.name(), convertToDistanceSign(car.position()))
        ));
    log.append(ENTER);
  }

  private String convertToDistanceSign(final int position) {
    StringBuilder sign = new StringBuilder();
    for (int i = 0; i < position; i++) {
      sign.append(DISTANCE_SIGN);
    }
    return sign.toString();
  }

  public String log() {
    return log.toString();
  }

  public String winner() {
    int maxPosition = participants.cars().stream()
        .mapToInt(Car::position)
        .max()
        .orElse(DEFAULT_MAX_POSITION);

    List<Car> winners = participants.cars().stream()
        .filter(car -> car.position() == maxPosition)
        .collect(Collectors.toList());
    return new Winner(winners).winnerName();
  }
}
