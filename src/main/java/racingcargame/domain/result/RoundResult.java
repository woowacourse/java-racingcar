package racingcargame.domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {

    private static final String CAR_STATUS_DELIMITER = "\n";
    private static final int DEFAULT_POSITION = 0;

    private final List<CarSnapShot> carSnapShots;

    public RoundResult(List<CarSnapShot> carSnapShots) {
        this.carSnapShots = carSnapShots;
    }

    public String getStatus() {
        List<String> carSnapShotsStatus = carSnapShots.stream()
                .map(CarSnapShot::getStatus)
                .collect(Collectors.toList());

        return String.join(CAR_STATUS_DELIMITER, carSnapShotsStatus);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return carSnapShots.stream()
                .filter(carSnapShot -> carSnapShot.isSamePositionWith(maxPosition))
                .map(CarSnapShot::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carSnapShots.stream().mapToInt(CarSnapShot::getPosition).max().orElse(DEFAULT_POSITION);
    }

}
