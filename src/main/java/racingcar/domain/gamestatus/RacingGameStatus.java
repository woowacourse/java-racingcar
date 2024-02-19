package racingcar.domain.gamestatus;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.GameStatus;

public class RacingGameStatus implements GameStatus {
    private static final String CARS_STATUS_DELEMITER = "\n";
    private List<CarStatus> carStatus;

    public RacingGameStatus(List<CarStatus> carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public String showStatus() {
        return carStatus.stream()
                .map(CarStatus::showStatus)
                .collect(Collectors.joining(CARS_STATUS_DELEMITER));
    }

}
