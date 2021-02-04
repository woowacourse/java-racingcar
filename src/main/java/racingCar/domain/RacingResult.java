package racingCar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

  private static final String LOG_FORM = "%s : %s \n";
  private static final String DISTANCE_SIGN = "-";
  private static final String ENTER = "\n";
  private static final int DEFAULT_MAX_POSITION = 0;
  private StringBuilder log = new StringBuilder();
  private Participants participants;

  public RacingResult(Participants participants) {
    this.participants = participants;
  }

  public void appendLog() {
    participants.getCars()
        .forEach(car -> log.append(
            String.format(LOG_FORM, car.getName(), convertToDistanceSign(car.getPosition()))
        ));
    log.append(ENTER);
  }

  private String convertToDistanceSign(int position) {
    StringBuilder sign = new StringBuilder();
    for (int i = 0; i < position; i++) {
      sign.append(DISTANCE_SIGN);
    }
    return sign.toString();
  }

  public String getLog() {
    return log.toString();
  }

  public Winner getWinner() {
    int max = participants.getCars().stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(DEFAULT_MAX_POSITION);

    List<Car> winners = participants.getCars().stream()
        .filter(car -> car.getPosition() == max)
        .collect(Collectors.toList());
    return new Winner(winners);
  }
}
