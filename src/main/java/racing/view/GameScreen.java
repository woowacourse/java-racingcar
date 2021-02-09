package racing.view;

import racing.view.dto.CarMoveStatusDto;
import racing.view.dto.WinnersStatusDto;

import java.util.List;

public class GameScreen implements Screen {
    private static final String RESULT = "\n실행 결과";
    private static final String DISTANCE = "-";
    private static final String STATUS_FORMAT = "%s : %s\n";
    private static final String DELIMITER = ", ";
    private static final String WINNER = "가 최종 우승했습니다.";
    private static final int ZERO = 0;

    @Override
    public void showMessage() {
        OutputView.printMessage(RESULT);
    }

    public void showCarStatus(final List<CarMoveStatusDto> carMoveStatusDtos) {
        StringBuilder stringBuilder = new StringBuilder();
        carMoveStatusDtos.forEach(carMoveStatusDto -> showEachCarStatus(carMoveStatusDto, stringBuilder));
        OutputView.printMessage(stringBuilder.toString());
    }

    public void showWinners(final WinnersStatusDto winnersStatusDto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.join(DELIMITER, winnersStatusDto.getWinnersName()));
        stringBuilder.append(WINNER);
        OutputView.printMessage(stringBuilder.toString());
    }

    private void showEachCarStatus(final CarMoveStatusDto carMoveStatusDto, final StringBuilder stringBuilder) {
        String carName = carMoveStatusDto.getCarName();
        String distance = getDistance(carMoveStatusDto);
        String message = String.format(STATUS_FORMAT, carName, distance);
        stringBuilder.append(message);
    }

    private String getDistance(final CarMoveStatusDto carMoveStatusDto) {
        StringBuilder stringBuilder = new StringBuilder();
        int position = carMoveStatusDto.getPosition();
        for (int i = ZERO; i < position; i++) {
            stringBuilder.append(DISTANCE);
        }
        return stringBuilder.toString();
    }
}
