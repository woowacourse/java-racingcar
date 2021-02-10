package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingLogPerRound {

  private static final int DEFAULT_POSITION = 0;
  private List<RacingLogDTO> racingLog;

  public RacingLogPerRound() {
    this.racingLog = new ArrayList<>();
  }

  public void addLog(RacingLogDTO racingLogDTO) {
    this.racingLog.add(racingLogDTO);
  }

  public List<RacingLogDTO> racingLog() {
    return Collections.unmodifiableList(racingLog);
  }

  public List<String> winners() {
    int maxPosition = maxPosition();
    return racingLog.stream()
        .filter(log -> log.hasSamePosition(maxPosition))
        .map(RacingLogDTO::getName)
        .collect(Collectors.toList());
  }

  private int maxPosition() {
    return racingLog.stream()
        .mapToInt(RacingLogDTO::getPosition)
        .max()
        .orElse(DEFAULT_POSITION);
  }
}
