package view;

import model.CarInfoDto;
import model.ResultByRoundDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RACING_FORMAT = "%s : %s";
    private static final String TRACE_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RACING_RESULT_ANNOUNCE = "실행 결과";
    private static final String WINNERS_ANNOUNCE_FORMAT = "%s가 최종 우승했습니다.";

    private final List<String> racingRecord = new ArrayList<>();

    public void writeRacingResult(List<ResultByRoundDto> racingResult) {
        System.out.println(LINE_SEPARATOR + RACING_RESULT_ANNOUNCE);

        for (ResultByRoundDto roundResult : racingResult) {
            addRoundResultByFormat(roundResult.getResultByRound());
        }
//        racingResult.forEach(roundResult -> addRoundResultByFormat(roundResult));
//        racingResult.stream()
//                .forEach(this::addRoundResultByFormat);

        System.out.println(String.join(LINE_SEPARATOR, racingRecord));
    }

    private void addRoundResultByFormat(List<CarInfoDto> cars) {
        StringBuilder roundBuilder = new StringBuilder();
        for (CarInfoDto carInfo : cars) {
            String carInfoFormat = makeCarInfoByFormat(carInfo.name(), makeTraceByFormat(carInfo.position()));
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
