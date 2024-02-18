package domain;

import dto.CarStatus;
import dto.TurnResult;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private final List<TurnResult> raceResult;

    public RaceResult(List<TurnResult> raceResult) {
        validateEmptiness(raceResult);
        this.raceResult = raceResult;
    }


    private static void validateEmptiness(List<TurnResult> raceResult) {
        if (raceResult.isEmpty()) {
            throw new IllegalArgumentException("TurnResult가 존재하지 않습니다.");
        }
    }

    public List<TurnResult> getResult() {
        return raceResult;
    }

    public List<String> getWinners() {
        TurnResult lastTurnResult = raceResult.get(raceResult.size() - 1);
        int maxDistance = getMaxDistance(lastTurnResult);
        return getMaxDistanceCars(lastTurnResult, maxDistance);
    }

    private int getMaxDistance(TurnResult lastTurnResult) {
        return lastTurnResult.getCarStatuses().stream()
                .max(Comparator.naturalOrder())
                .orElseThrow()
                .getDistance();
    }

    private List<String> getMaxDistanceCars(TurnResult lastTurnResult, int maxDistance) {
        return lastTurnResult.getCarStatuses()
                .stream()
                .filter(carStatus -> carStatus.getDistance() == maxDistance)
                .map(CarStatus::getName)
                .collect(Collectors.toList());
    }
}
