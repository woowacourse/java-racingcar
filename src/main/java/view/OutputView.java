package view;

import dto.RacingCarStateDto;
import dto.RacingRoundStateDto;
import dto.WinnerCarDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RACE_START_MESSAGE = "\n실행 결과";
    private static final String ERROR_FORMAT = "[ERROR] %s";
    private static final String POSITION_STATE = "-";
    private static final String ROUND_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "\n%s가 최종 우승했습니다.";
    private static final String LINE_FEED = "\n";
    private static final String DELIMITER = ", ";

    public void printRacingTotalState(List<RacingRoundStateDto> racingTotalState) {
        print(RACE_START_MESSAGE);

        String racingTotalStateLog = racingTotalState.stream()
                .map(this::mapToRacingRoundStateLog)
                .collect(Collectors.joining(LINE_FEED + LINE_FEED));
        print(racingTotalStateLog);
    }

    private String mapToRacingRoundStateLog(RacingRoundStateDto racingRoundStateDto) {
        return racingRoundStateDto.getRacingCarStateDtos().stream()
                .map(this::mapToRacingCarStateLog)
                .collect(Collectors.joining(LINE_FEED));
    }

    private String mapToRacingCarStateLog(RacingCarStateDto racingCarStateDto) {
        return String.format(ROUND_FORMAT, racingCarStateDto.getName(),
                mapToRacingCarStateLog(racingCarStateDto.getPosition()));
    }

    private String mapToRacingCarStateLog(int position) {
        return POSITION_STATE.repeat(Math.max(0, position));
    }

    public void printWinners(List<WinnerCarDto> winnersDto) {
        String winners = winnersDto.stream()
                .map(WinnerCarDto::getName)
                .collect(Collectors.joining(DELIMITER));

        print(String.format(WINNER_FORMAT, winners));
    }

    public void printExceptionMessage(String message) {
        print(String.format(ERROR_FORMAT, message));
    }

    private void print(String message) {
        System.out.println(message);
    }
}
