package racingcargame.domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {

    private final List<CarSnapShot> carSnapShots;

    public RoundResult(List<CarSnapShot> carSnapShots) {
        this.carSnapShots = carSnapShots;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (CarSnapShot carSnapShot : carSnapShots) {
            sb.append(carSnapShot.getStatus() + "\n");
        }

        return sb.toString();
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
