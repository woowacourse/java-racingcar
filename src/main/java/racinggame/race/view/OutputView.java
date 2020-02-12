package racinggame.race.view;

import racinggame.race.car.Winners;
import racinggame.race.view.dto.RacingResBundleDTO;
import racinggame.race.view.dto.RacingResDTO;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";
    private static final String NAME_AND_DISTANCE_FORMAT = "%s : %s";
    private static final String WINNERS_NAMES = "%s가 최종 우승했습니다.";

    public static void showReady(RacingResBundleDTO cars) {
        System.out.println(RESULT_HEAD);
        showCars(cars);
    }

    public static void showCars(RacingResBundleDTO racingResBundleDTO) {
        for (RacingResDTO racingResDTO : racingResBundleDTO) {
            System.out.println(String.format(NAME_AND_DISTANCE_FORMAT, racingResDTO.getName(), racingResDTO.getDistance()));
        }
        System.out.println();
    }

    public static void showWinners(Winners winners) {
        System.out.println(String.format(WINNERS_NAMES, winners.getNames()));
    }
}
