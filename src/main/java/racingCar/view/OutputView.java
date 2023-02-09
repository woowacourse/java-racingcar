package racingCar.view;

import racingCar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printError(String errorMsg) {
        System.out.println(errorMsg);
    }

    public static void printCarPosition(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            System.out.println(carDto.toString());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        String names = winnerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
