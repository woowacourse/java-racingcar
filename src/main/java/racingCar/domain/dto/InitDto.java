package racingCar.domain.dto;

import java.util.Arrays;
import java.util.List;
import racingCar.utils.Util;

public class InitDto {
    private final List<String> names;
    private final int count;

    public InitDto(String namesInput, String countInput) {
        names = Arrays.asList(Util.separate(namesInput));
        count = Util.convertToInteger(countInput);
    }

    public List<String> getNames() {
        return names;
    }

    public int getCount() {
        return count;
    }
}
