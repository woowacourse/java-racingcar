package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    public void printPerRound(List<CarDto> carDtos) {
        carDtos.forEach(carDto -> System.out.println(carDto.name() + " : " + "-".repeat(carDto.position())));
        System.out.println();
    }
}
