package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static final String SPACE = " ";
    public static final String BLANK = "";
    public static final String COMMA = ",";

    private final List<String> carsName;

    public CarFactory(String commaSeparatedCarsName) {
        this.carsName = splitCarsName(commaSeparatedCarsName);
        detectDuplicateName();
    }

    private List<String> splitCarsName(String commaSeparatedCarsName) {
        if(!commaSeparatedCarsName.contains(",")) {
            throw new IllegalArgumentException("1대만 있으면 경기를 진행할 수 없습니다.");
        }
        return Arrays.asList(commaSeparatedCarsName.trim()
                .replace(SPACE, BLANK)
                .split(COMMA));
    }

    private void detectDuplicateName() {
        HashSet<String> carsNameWithoutDuplicate = new HashSet<>(carsName);
        if (carsName.size() != carsNameWithoutDuplicate.size()) {
            throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
        }
    }

    public Cars enrollCars() {
        List<Car> cars = carsName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }
}
