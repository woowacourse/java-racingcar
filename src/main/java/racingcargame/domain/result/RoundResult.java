package racingcargame.domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {

    private final List<CarSnapShot> carSnapShots;

    public RoundResult(List<CarSnapShot> carSnapShots) {
        this.carSnapShots = carSnapShots;
    }

    public String getStatus() {
        List<String> carSnapShotsStatus = carSnapShots.stream()
                .map(CarSnapShot::getStatus)
                .collect(Collectors.toList());

        return String.join("\n", carSnapShotsStatus);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return carSnapShots.stream()
                .filter(carSnapShot -> carSnapShot.getPosition() == maxPosition)
                .map(CarSnapShot::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carSnapShots.stream().mapToInt(CarSnapShot::getPosition).max().orElse(0);
    }

}
