package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;

public class OutputView {

    public void printPerRound(List<CarDto> carDtos) {
        carDtos.forEach(carDto -> System.out.println(carDto.name() + " : " + "-".repeat(carDto.position())));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerJoining = winners.stream()
                        .collect(Collectors.joining(", "));
        System.out.printf("%s가 최종 우승했습니다.", winnerJoining);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
