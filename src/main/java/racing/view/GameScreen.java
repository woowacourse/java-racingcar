package racing.view;

import racing.domain.dto.CarDto;

import java.util.List;

public class GameScreen extends Screen{
    private static final String RESULT = "\n실행 결과";
    private static final String DISTANCE = "-";
    private static final String STATUS_FORMAT = "%s : %s\n";
    private static final String WINNER = "가 최종 우승햇습니다.";

    @Override
    public void showMessage() {
        OutputView.printMessage(RESULT);
    }

    public void showCarStatus2(List<CarDto> carDtos) {
        StringBuilder stringBuilder = new StringBuilder();
        carDtos.forEach(carDto -> showEachCarStatus(carDto, stringBuilder));
        OutputView.printMessage(stringBuilder.toString());
    }

    public void showWinners(List<String> winnerNames){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.join(", ", winnerNames));
        stringBuilder.append(WINNER);
        OutputView.printMessage(stringBuilder.toString());
    }

    private void showEachCarStatus(CarDto carDto, StringBuilder stringBuilder) {
        String distance = getDistance(carDto);
        String carName = carDto.getCarName();
        String message = String.format(STATUS_FORMAT, carName, distance);
        stringBuilder.append(message);
    }

    private String getDistance(CarDto carDto) {
        int position = carDto.getPosition();
        String distance = "";
        for (int i = 0; i < position; i++) {
            distance += DISTANCE;
        }
        return distance;
    }
}
