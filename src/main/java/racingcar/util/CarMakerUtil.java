package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.ErrorMessage;
import racingcar.vo.Car;

public class CarMakerUtil {
    
    public static List<Car> createCarsWith(String[] names) {
        validateDuplicateCarName(names);
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void validateDuplicateCarName(String[] names) {
        long countDuplication = Arrays.stream(names)
                .distinct()
                .count();
        if (countDuplication != names.length) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_DUPLICATE.getMessage());
        }
    }
}
