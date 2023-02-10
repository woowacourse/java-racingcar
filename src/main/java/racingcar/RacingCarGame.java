package racingcar;

import java.util.List;

public class RacingCarGame {

    private static final int START_POSITION = 0;

    public void repeatRounds() {
//        TODO : 유효성 검사 validator 객체로 추출 => NumberOfTryValidator.validate(numberOfTry)
        // NumberOfTryValidator.validate(); => "숫자만 입력할 수 있습니다."
        for (Car car : CarRepository.findAll()) {
            car.move(new RandomBasedStrategy());
        }
    }

    public List<String> getWinners() {
        return CarRepository.findSamePositionWith(getMaxPosition());
    }

    private int getMaxPosition() {
        return CarRepository.findAll().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(START_POSITION);
    }
}
