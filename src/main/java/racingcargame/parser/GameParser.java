package racingcargame.parser;

import racingcargame.domain.car.Car;
import racingcargame.domain.trialtimes.TrialTimes;
import racingcargame.game.CarRace;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameParser {

    public static CarRace generateCarRace(String carNamesInput) {
        List<String> names = Arrays.asList(carNamesInput.split(","));
        List<Car> cars = names.stream().map(Car::new).collect(Collectors.toList());
        return new CarRace(cars);
    }

    public static TrialTimes generateTrialTimes(String trialTimesInput) {
        try {
            return new TrialTimes(Integer.parseInt(trialTimesInput));
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}
