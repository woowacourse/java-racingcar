package view;

import domain.Car;
import domain.Cars;
import dto.CarDto;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printStatus(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            String name = carDto.getName();
            int position = carDto.getPosition();
            String positionString = getPositionString(position);
            System.out.printf("%s : %s\n", name, positionString);
        }
        System.out.println();
    }

    private static String getPositionString(int position) {
        String positionString = "";
        for (int i = 0; i < position; i++) {
            positionString += "-";
        }
        return positionString;
    }

    public static void printWinner(Cars winnerCars) {
        List<Car> cars = winnerCars.getCars();
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        String winnerString = String.join(", ", carNames);
        System.out.printf("%s가 최종 우승했습니다.\n", winnerString);
    }
}
