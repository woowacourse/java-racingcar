package view;

import domain.Car;
import domain.Cars;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printStatus(Cars cars) {
        for (Car carDto : cars.getCars()) {
            String name = carDto.getName();
            int position = carDto.getPosition();
            String positionString = getPositionString(position);
            System.out.printf("%s : %s\n", name, positionString);
        }
        System.out.println();
    }

    private String getPositionString(int position) {
        String positionString = "";
        for (int i = 0; i < position; i++) {
            positionString += "-";
        }
        return positionString;
    }
}
