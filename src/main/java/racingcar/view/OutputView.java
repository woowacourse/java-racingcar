package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public class OutputView {
    private static final String NEWLINE = System.lineSeparator();
    private static final String RESULT_MESSAGE = NEWLINE + "실행 결과";
    private static final String COLON = " : ";
    private static final String POSITION_EXPRESSION_SYMBOL = "-";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<CarDto> cars) {
        for (CarDto car : cars) {
            printCarInformation(car);
        }
        System.out.println();
    }

    private void printCarInformation(CarDto car) {
        StringBuilder informationBuilder = new StringBuilder();

        informationBuilder.append(car.getName())
                .append(COLON)
                .append(POSITION_EXPRESSION_SYMBOL.repeat(car.getPosition()));

        System.out.println(informationBuilder);
    }
}
