package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.CarResponseDto;
import racingcar.dto.CarsResponseDto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void output(String message){
        System.out.println(message);
    }

    public static void printLeaderBoard(CarsResponseDto carsResponseDto) {
        for (CarResponseDto car : carsResponseDto.getCarResponseDtoList()) {
            String positionStick = String.join("", Collections.nCopies(car.getPosition(), "-"));
            System.out.println(String.format("%s : %s", car.getName(), positionStick));
        }
        System.out.println();
    }
}
