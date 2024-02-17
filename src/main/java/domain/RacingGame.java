package domain;

import static constant.Numbers.MAX_CAR_LENGTH;
import static constant.Numbers.MIN_CAR_LENGTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import view.OutputView;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(String rawCarNames) {
        this.cars = makeCars(rawCarNames);
    }

    public void play(Round round) {
        System.out.println("실행 결과");
        for (int i = 0; i < round.getRound(); i++) {
            playOneRound();
            OutputView.printScore(cars);
        }
        OutputView.printCars(findWinners());
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> findWinners() {
        return cars.stream()
            .filter(car -> car.equals(Collections.max(cars)))
            .toList();
    }

    private List<Car> makeCars(String rawCarNames) {
        List<Car> carList = new ArrayList<>();
        List<String> carNames = Arrays.stream(rawCarNames.trim().split("\\s*,\\s*")).toList();
        validate(carNames);
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    private void validate(List<String> names) {
        validateCarAmount(names);
        validateNameDuplication(names);
    }

    private static void validateCarAmount(List<String> names) {
        if (names.size() < MIN_CAR_LENGTH || names.size() > MAX_CAR_LENGTH) {
            throw new IllegalArgumentException(
                "차는 " + MIN_CAR_LENGTH + " ~ " + MAX_CAR_LENGTH + "대만 입력 가능합니다.");
        }
    }

    private static void validateNameDuplication(List<String> names) {
        Set<String> nonDuplicatedNames = new HashSet<>(names);
        if (nonDuplicatedNames.size() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
}
