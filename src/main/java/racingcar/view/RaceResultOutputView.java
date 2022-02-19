package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.domain.CarDto;

public class RaceResultOutputView {
    private static final String ROUND_RESULT = "실행 결과";
    private static final String CAR_INFO_SEPARATOR = " : ";
    private static final String CAR_POSITION_BAR = "-";

    public static void printRaceResults(Map<Integer, List<CarDto>> raceResult) {
        System.out.println(ROUND_RESULT);
        for (Integer round : raceResult.keySet()) {
            raceResult.get(round).forEach(RaceResultOutputView::printCarPositionInfo);
            System.out.println();
        }
    }

    private static void printCarPositionInfo(CarDto carDto) {
        System.out.println(
                carDto.getName() + CAR_INFO_SEPARATOR + CAR_POSITION_BAR.repeat(Math.max(0, carDto.getPosition())));
    }
}
