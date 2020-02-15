package racingcar.view;

import racingcar.domain.CarData;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_CHANGER = "\n";
    private static final String SEPARATOR = " : ";
    private static final String DISTANCE_INDICATOR = "-";
    private static final String COMMA = ", ";

    public static void printResultStart() {
        System.out.println("\n실행 결과");
    }

    public static void printStatus(List<CarData> carsData) {
        System.out.println(carsData.stream()
                .map(OutputView::getStatus)
                .collect(Collectors.joining(LINE_CHANGER)));
        System.out.println();
    }

    public static void printWinners(List<CarData> winnerCarsData) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(winnerCarsData.stream()
                .map(carData -> carData.getName().getValue())
                .collect(Collectors.joining(COMMA)));
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    private static String getStatus(CarData carData) {
        StringBuilder SB = new StringBuilder();

        SB.append(carData.getName().getValue());
        SB.append(SEPARATOR);
        for (int i = 0; i < carData.getDistance(); i++) {
            SB.append(DISTANCE_INDICATOR);
        }
        return SB.toString();
    }
}
