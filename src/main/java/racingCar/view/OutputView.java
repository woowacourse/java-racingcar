package racingCar.view;

import racingCar.dto.CarDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printError(String errorMsg) {
        System.out.println(errorMsg);
    }

    public static void printRacing(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            System.out.println(carDto.toString());
        }
        System.out.print(System.lineSeparator());
    }

    public static void printWinners(List<String> winnerNames) {
        String winners = winnerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
