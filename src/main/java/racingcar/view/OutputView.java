package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    public void printCarsPosition(final List<CarDto> carDtos) {
        carDtos.forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(final CarDto carDto) {
        System.out.println(carDto.name() + " : " + "-".repeat(carDto.position()));
    }

    public void printWinners(final List<String> winners) {
        final String winnerJoining = String.join(", ", winners);
        System.out.printf("%s가 최종 우승했습니다.", winnerJoining);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
