package racingcar.view;

import racingcar.dto.CarResponseDto;
import racingcar.dto.CarsResponseDto;

import java.util.Collections;

public class OutputView {
    public static void output(String message){
        System.out.println(message);
    }

    public static void printLeaderBoard(CarsResponseDto carsResponseDto) {
        for (CarResponseDto car : carsResponseDto.getCarResponseDtoList()) {
            String positionStick = makeStick(car);
            System.out.println(String.format("%s : %s", car.getName(), positionStick));
        }
        System.out.println();
    }

    public static String makeStick(CarResponseDto car) {
        return String.join("", Collections.nCopies(car.getPosition(), "-"));
    }
}
