package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {
    public static final String SPACE = " ";
    public static final String BLANK = "";
    public static final String COMMA = ",";

    private final String[] carsName;

    public CarFactory(String commaSeparatedCarsName) {
        this.carsName = splitCarsName(commaSeparatedCarsName);
        detectDuplicateName();
    }

    private String[] splitCarsName(String commaSeparatedCarsName) {
        return commaSeparatedCarsName.trim()
                .replace(SPACE, BLANK)
                .split(COMMA);
    }

    private void detectDuplicateName() {
        String[] carsNameWithoutDuplicate = Arrays.asList(carsName).toArray(new String[0]);
        if(carsName != carsNameWithoutDuplicate) {
            throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
        }
    }

    public List<Car> enrollCars() {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(carsName).forEach(x -> cars.add(new Car(x)));
        return cars;
    }
}
