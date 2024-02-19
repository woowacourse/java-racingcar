package racing.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RacingResults {

  private final List<RacingResult> racingResults;

  public RacingResults(List<RacingResult> racingResults) {
    this.racingResults = Collections.unmodifiableList(racingResults);
  }

  public List<String> getWinnerNames() {
    RacingResult finalResult = racingResults.get(racingResults.size() - 1);
    Map<String, Integer> finalCarsStatus = finalResult.carsStatus();
    int maxDistance = getMaxDistance(finalCarsStatus);
    return getWinners(finalCarsStatus, maxDistance);
  }

  private int getMaxDistance(Map<String, Integer> finalCarsStatus) {
    return finalCarsStatus.values()
        .stream()
        .max(Comparator.naturalOrder())
        .orElseThrow();
  }

  private List<String> getWinners(Map<String, Integer> finalCarsStatus, int maxDistance) {
    return finalCarsStatus.entrySet().stream()
        .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == maxDistance)
        .map(Entry::getKey)
        .toList();
  }

  public List<RacingResult> toList() {
    return racingResults;
  }

  public boolean isSameResult(RacingResults other) {
    boolean containsAll = new HashSet<>(other.racingResults).containsAll(racingResults);
    boolean isSameSize = other.racingResults.size() == racingResults.size();
    return isSameSize && containsAll;
  }
}
