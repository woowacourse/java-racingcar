package racing.dto;

import java.util.Collections;
import java.util.Map;

public class RacingResult {

  private final Map<String, Integer> carsStatus;

  public RacingResult(Map<String, Integer> carsStatus) {
    this.carsStatus = Collections.unmodifiableMap(carsStatus);
  }

  public Map<String, Integer> getCarsStatus() {
    return carsStatus;
  }
}
