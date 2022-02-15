package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public List<Name> judgeRacingWinners(List<Car> participantCars) {
        int maxLocation = Integer.MIN_VALUE;
        List<Name> winners = new ArrayList<>();

        for (Car participantCar : participantCars) {
            if (maxLocation < participantCar.getCarPosition()) {
                winners = new ArrayList<>();
                winners.add(participantCar.getName());
                maxLocation = participantCar.getCarPosition();
                continue;
            }
            if (maxLocation == participantCar.getCarPosition()) {
                winners.add(participantCar.getName());
            }
        }
        return winners;
    }
}
