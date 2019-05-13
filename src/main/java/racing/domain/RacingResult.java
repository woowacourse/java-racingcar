package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 한 라운드(실행횟수)를 실행한 차들의 결과를 처리를 하는 클래스
 *
 * @author imkimheejoo
 * @version 2.0.0
 */

public class RacingResult {
    private List<Car> cars;

    RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public String makeRoundResult() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.positionResult());
        }
        return sb.toString();
    }

    public List<String> searchWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.matchPosition(getMaxPosition())) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    int getMaxPosition() {
        return Collections.max(cars).getPosition();
    }

}
