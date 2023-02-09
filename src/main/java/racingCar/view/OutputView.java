package racingCar.view;

import racingCar.dto.CarDto;

import java.util.List;

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
}
