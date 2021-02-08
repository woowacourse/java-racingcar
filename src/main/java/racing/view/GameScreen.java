package racing.view;

import racing.view.dto.CarDto;
import racing.view.dto.WinnersDto;

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

    public void showCarStatus(final List<CarDto> carDtos) {
        StringBuilder stringBuilder = new StringBuilder();
        carDtos.forEach(carDto -> showEachCarStatus(carDto, stringBuilder));
        OutputView.printMessage(stringBuilder.toString());
    }

    public void showWinners(final WinnersDto winnersDto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.join(DELIMITER, winnersDto.getWinnersName()));
        stringBuilder.append(WINNER);
        OutputView.printMessage(stringBuilder.toString());
    }

    private void showEachCarStatus(final CarDto carDto, final StringBuilder stringBuilder) {
        String carName = carDto.getCarName();
        String distance = getDistance(carDto);
        String message = String.format(STATUS_FORMAT, carName, distance);
        stringBuilder.append(message);
    }

    private String getDistance(final CarDto carDto) {
        StringBuilder stringBuilder = new StringBuilder();
        int position = carDto.getPosition();
        for (int i = ZERO; i < position; i++) {
            stringBuilder.append(DISTANCE);
        }
        return stringBuilder.toString();
    }
}
