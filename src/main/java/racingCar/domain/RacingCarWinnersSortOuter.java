package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarWinnersSortOuter {
    public static List<RacingCar> sortOut(RacingCar[] competitors) {
        int maxPosition = getMaxPostionOfCompetitors(competitors);

        return findWinnersByMaxPosition(competitors, maxPosition);
    }

    private static int getMaxPostionOfCompetitors(RacingCar[] competitors) {
        return 4;
    }

    private static List<RacingCar> findWinnersByMaxPosition(RacingCar[] competitors, int maxPosition) {
        return Arrays.stream(competitors).filter(racingCar -> racingCar.getPostion() == maxPosition)
                .sorted().collect(Collectors.toList());
    }
}
