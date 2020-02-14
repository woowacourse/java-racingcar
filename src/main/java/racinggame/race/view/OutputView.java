package racinggame.race.view;

import racinggame.race.car.Winners;
import racinggame.race.view.dto.RacingResponseBundleDTO;
import racinggame.race.view.dto.RacingResponseDTO;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";
    private static final String NAME_AND_DISTANCE_FORMAT = "%s : %s";
    private static final String WINNERS_NAMES = "%s가 최종 우승했습니다.";

    public static void showReady(RacingResponseBundleDTO cars) {
        System.out.println(RESULT_HEAD);
        showCars(cars);
    }

    public static void showCars(RacingResponseBundleDTO racingResponseBundleDTO) {
        for (RacingResponseDTO racingResponseDTO : racingResponseBundleDTO) {
            System.out.println(String.format(NAME_AND_DISTANCE_FORMAT, racingResponseDTO.getName(), racingResponseDTO.getDistance()));
        }
        System.out.println();
    }

    public static void showWinners(Winners winners) {
        System.out.println(String.format(WINNERS_NAMES, winners.getNames()));
    }
}
