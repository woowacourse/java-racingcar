package racingcar.view;

import racingcar.domain.dto.CarDto;
import racingcar.domain.result.Result;
import racingcar.view.message.Message;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void printCarNameInputGuide() {
        print(Message.CAR_NAME_INPUT_GUIDE.getMessage());
    }

    public void printGameRoundGuide() {
        print(Message.GAME_ROUND_INPUT_GUIDE.getMessage());
    }

    public void printResultGuide() {
        print(Message.GAME_RESULT_GUIDE.getMessage());
    }

    public void printResult(Result result) {
        printResultGuide();
        Map<Integer, Set<CarDto>> results = result.getResults();
        for (Map.Entry<Integer, Set<CarDto>> carDtosByRound : results.entrySet()) {
            Set<CarDto> carDtos = carDtosByRound.getValue();
            carDtos.forEach(this::printEachResult);
        }
    }

    private void printEachResult(CarDto carDto) {
        String positionMarker = Message.POSITION_MARKER.getMessage();
        String position = makePosition(carDto.getPosition(), positionMarker);
        print(makeResultMessage(carDto.getCarName(), position));
    }

    private String makePosition(int position, String positionMarker) {
        return positionMarker.repeat(position);
    }

    private String makeResultMessage(String key, String position) {
        return String.format(Message.RESULT_DELIMITER.getMessage(), key, position);
    }

    public void printWinner(List<String> winners) {
        String delimiter = Message.WINNER_DELIMITER.getMessage();
        print(makeWinnerMessage(winners, delimiter));
    }

    private String makeWinnerMessage(List<String> winners, String delimiter) {
        return String.format(Message.WINNER_GUIDE.getMessage(), String.join(delimiter, winners));
    }

    private void print(String message) {
        System.out.println(message);
    }
}
