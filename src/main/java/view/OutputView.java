package view;

import model.Car;
import model.RacingResultByRoundDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RACING_FORMAT = "%s : %s";
    private static final String TRACE_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RACING_RESULT_ANNOUNCE = "실행 결과";
    private static final String WINNERS_ANNOUNCE_FORMAT = "%s가 최종 우승했습니다.";

    private final List<String> racingRecord = new ArrayList<>();

    public void writeRacingResult(List<RacingResultByRoundDto> racingResult) {
        System.out.println(LINE_SEPARATOR + RACING_RESULT_ANNOUNCE);

        for (RacingResultByRoundDto roundResult : racingResult) {
            addRoundResultByFormat(roundResult);
        }

        System.out.println(String.join(LINE_SEPARATOR, racingRecord));
    }

    private void addRoundResultByFormat(RacingResultByRoundDto cars) {
        StringBuilder roundBuilder = new StringBuilder();
        for (Car carInfo : cars.getRacingResultByRound()) {
            String carInfoFormat = makeCarInfoByFormat(carInfo.getName(), makeTraceByFormat(carInfo.getPosition()));
            roundBuilder.append(carInfoFormat).append(LINE_SEPARATOR);
        }
        racingRecord.add(roundBuilder.toString());
    }

    private String makeCarInfoByFormat(String name, String trace) {
        return String.format(RACING_FORMAT, name, trace);
    }

    private String makeTraceByFormat(int count) {
        return TRACE_SYMBOL.repeat(count).trim();
    }

    public void writeWinners(List<String> names) {
        String winners = names.stream().collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(String.format(WINNERS_ANNOUNCE_FORMAT, winners));
    }
}
