package racinggame;

import java.util.Arrays;
import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.Round;

class ObjectMapper {

    public List<Car> mapToCars(String input) {
        return Arrays.stream(input.split(","))
            .map(Car::new)
            .toList();
    }

    public Round mapToRound(String input) {
        return new Round(parseInt(input));
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력해주세요.");
        }
    }
}
