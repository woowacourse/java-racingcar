package view;

import dto.CarDto;
import dto.GameResultDto;
import dto.RoundResultDto;
import java.util.List;
import java.util.stream.Collectors;

public class MessageResolver {

    private static final String WINNER_MESSAGE_POSTFIX = "가 최종 우승했습니다.";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String RACE_RESULT_PREFIX = "\n실행 결과\n";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String resolveGameResultMessage(GameResultDto gameResultDto) {
        String roundResultsMessage = resolveRoundResultsMessage(gameResultDto.getRoundResults());
        String winnersMessage = resolveWinnerMessage(gameResultDto.getWinners());
        return RACE_RESULT_PREFIX + roundResultsMessage + winnersMessage;
    }

    private String resolveRoundResultsMessage(List<RoundResultDto> roundResults) {
        return roundResults.stream()
                .map(this::resolveRoundResultMessage)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String resolveRoundResultMessage(RoundResultDto roundResultDto) {
        List<CarDto> roundResult = roundResultDto.getRoundResult();
        return roundResult.stream()
                .map(dto -> dto.getName() + NAME_POSITION_SEPARATOR + resolveCarPositionMessage(dto.getPosition()))
                .collect(Collectors.joining(LINE_SEPARATOR)) + LINE_SEPARATOR;
    }

    private String resolveCarPositionMessage(Integer carPosition) {
        String message = "";
        for (int i = 0; i < carPosition; i++) {
            message += "-";
        }
        return message;
    }

    private String resolveWinnerMessage(List<CarDto> winners) {
        return "\n" + winners.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(", ")) + WINNER_MESSAGE_POSTFIX;
    }
}
