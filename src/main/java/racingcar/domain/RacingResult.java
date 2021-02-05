package racingcar.domain;

public class RacingResult {

  private static final String ENTER = System.lineSeparator();
  private static final String LOG_FORM = "%s : %s" + ENTER;
  private static final String DISTANCE_SIGN = "-";
  private final StringBuilder log = new StringBuilder();
  private final Participants participants;

  public RacingResult(final Participants participants) {
    this.participants = participants;
  }

  public void appendLog() {
    participants.getCars()
        .forEach(car -> log.append(
            String.format(LOG_FORM, car.getName(), convertToDistanceSign(car.getPosition()))
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

  public String getLog() {
    return log.toString();
  }

  public String getWinner() {
    return participants.getWinner();
  }
}
