package racing.domain;

import java.util.Collections;
import java.util.List;
/**
 * 한 라운드(실행횟수)에 따른 경주경기에 대한 처리를 하는 클래스
 */
class RacingResult {
    private List<Car> roundCars;

    RacingResult(List<Car> roundCars) {
        this.roundCars = roundCars;
    }

    String makeRoundResult() {
        StringBuilder sb = new StringBuilder();
        for (Car car : roundCars) {
            sb.append(car.positionResult());
        }
        sb.append("\n");

        return sb.toString();
    }

    void compareTiePosition(List<String> winners) {
        for (Car car : roundCars) {
            if (car.matchPosition(getMaxPosition())) {
                winners.add(car.getName());
            }
        }
    }
    private int getMaxPosition() {
        return Collections.max(roundCars).getPosition();
    }

}
