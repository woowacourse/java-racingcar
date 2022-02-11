package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Board {

    public void announceRacingStart() {
        System.out.println("실행 결과");
    }

    public void recordCurrentScore(List<Car> participants) {
        for (Car participant : participants) {
            System.out.println(participant.getName() + " : " + "-".repeat(participant.getLocation()));
        }
        System.out.println();
    }
}
