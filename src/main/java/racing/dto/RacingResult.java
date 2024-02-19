package racing.dto;

import java.util.Collections;
import java.util.Map;

public record RacingResult(Map<String, Integer> carsStatus) {

  public RacingResult(Map<String, Integer> carsStatus) {
    this.carsStatus = Collections.unmodifiableMap(carsStatus);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    RacingResult other = (RacingResult) o;
    boolean containsAll = other.carsStatus.entrySet().containsAll(carsStatus.entrySet());
    boolean isSameSize = other.carsStatus.size() == carsStatus.size();
    return containsAll && isSameSize;
  }

}
