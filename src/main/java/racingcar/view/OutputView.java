package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.NameDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_GUIDE_MESSAGE = "실행 결과";
    private static final String PROGRESS_GAUGE = "-";
    private static final String RESULT_CONNECTOR = " : ";
    private static final String NAME_DELIMITER = ", ";
    private static final String WINNER_GUIDE_MESSAGE_SUFFIX = "가 최종 우승했습니다.";

    private OutputView() {
    }

    public static void printResultGuide() {
        printNewLine();
        System.out.println(RESULT_GUIDE_MESSAGE);
    }

    public static void printResults(final List<CarDto> carDtos) {
        carDtos.stream()
                .forEach(OutputView::printResult);

        printNewLine();
    }

    private static void printResult(final CarDto carDto) {
        final String name = carDto.getNameDto().getName();
        final int position = carDto.getPositionDto().getPosition();

        final StringBuilder result = new StringBuilder(name + RESULT_CONNECTOR);
        for (int i = 0; i < position; i++) {
            result.append(PROGRESS_GAUGE);
        }

        System.out.println(result);
    }

    public static void printWinnerNames(final List<NameDto> nameDtos) {
        final List<String> carNames = nameDtos.stream()
                .map(NameDto::getName)
                .collect(Collectors.toList());

        System.out.print(String.join(NAME_DELIMITER, carNames));
        System.out.println(WINNER_GUIDE_MESSAGE_SUFFIX);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
