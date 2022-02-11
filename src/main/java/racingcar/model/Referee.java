package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<Name> judgeRacingWinners(List<Car> participantCars) {
        int maxLocation = Integer.MIN_VALUE;
        List<Name> winners = new ArrayList<>();

        for (Car participantCar : participantCars) {
            if (maxLocation < participantCar.getLocation()) {
                winners = new ArrayList<>();
                winners.add(participantCar.getName());
                maxLocation = participantCar.getLocation();
                continue;
            }
            if (maxLocation == participantCar.getLocation()) {
                winners.add(participantCar.getName());
            }
        }

        return winners;
    }
}
