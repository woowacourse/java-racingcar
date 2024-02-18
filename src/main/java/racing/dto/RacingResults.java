package racing.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RacingResults {

  private final List<RacingResult> racingResults;

  public RacingResults(List<RacingResult> racingResults) {
    this.racingResults = Collections.unmodifiableList(racingResults);
  }

  private static List<String> getWinners(Map<String, Integer> finalCarsStatus, int maxDistance) {
    return finalCarsStatus.keySet().stream().filter(carName ->
        finalCarsStatus.get(carName) == maxDistance).toList();
  }

  private static int getMaxDistance(Map<String, Integer> finalCarsStatus) {
    return finalCarsStatus.keySet()
        .stream()
        .mapToInt(finalCarsStatus::get)
        .max()
        .orElseThrow();
  }

  public List<String> getWinnerNames() {
    RacingResult finalResult = racingResults.get(racingResults.size() - 1);
    Map<String, Integer> finalCarsStatus = finalResult.carsStatus();
    int maxDistance = getMaxDistance(finalCarsStatus);
    return getWinners(finalCarsStatus, maxDistance);
  }

  public Stream<RacingResult> stream() {
    return racingResults.stream();
  }

  public boolean isSameResult(RacingResults other) {
    boolean containsAll = new HashSet<>(other.racingResults).containsAll(racingResults);
    boolean isSameSize = other.racingResults.size() == racingResults.size();
    return isSameSize && containsAll;
  }
}
