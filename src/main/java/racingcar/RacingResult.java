package racingcar;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Round;

public class RacingResult {

  private final Map<Round, RacingLogPerRound> logs;

  public RacingResult() {
    this.logs = new HashMap<>();
  }

  public void appendLog(int round, Car car) {
    Round key = new Round(round);
    logs.put(key, logs.getOrDefault(key, new RacingLogPerRound()));
    logs.get(key).addLog(new RacingLogDTO(car));
  }

  public RacingLogPerRound logByRound(int round) {
    return logs.get(new Round(round));
  }
}
