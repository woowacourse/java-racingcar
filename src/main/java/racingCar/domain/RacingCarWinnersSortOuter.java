package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarWinnersSortOuter {
    public static List<RacingCar> sortOut(RacingCar[] competitors) {
        int maxPosition = getMaxPostionOfCompetitors(competitors);

        List<RacingCar> winners = Arrays.stream(competitors).filter(racingCar -> racingCar.getPostion() == maxPosition)
                .sorted().collect(Collectors.toList());
        return winners;
    }

    private static int getMaxPostionOfCompetitors(RacingCar[] competitors) {
        return 4;
    }
}
