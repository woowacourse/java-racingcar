package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dto.CarDto;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

public class FieldTest {
    @Test
    @DisplayName("자동차의 Race 결과를 반환하는지 테스트")
    void racing_record_test() {
        Field field = new Field(new RacingCars(List.of("pobi", "weve")), new FixedNumberGenerator());
        field.race(2);

        HashMap<Integer, List<CarDto>> expected = new LinkedHashMap<>();
        expected.put(1, List.of(new CarDto("pobi", 0), new CarDto("weve", 0)));
        expected.put(2, List.of(new CarDto("pobi", 0), new CarDto("weve", 1)));

        HashMap<Integer, List<CarDto>> result = field.getRacingRecord();

        assertEquals(result.size(), expected.size());
        assertTrue(result.keySet().equals(expected.keySet()));
        assertTrue(result.entrySet().equals(expected.entrySet()));
    }

    @Test
    @DisplayName("자동차 경주의 우승자(position이 가장 큰 자동차)의 리스트를 반환하는가")
    void get_winners_test() {
        Field field = new Field(new RacingCars(List.of("pobi", "weve")), new FixedNumberGenerator());
        field.race(2);

        List<CarDto> expected = List.of(new CarDto("weve", 1));
        List<CarDto> result = field.getWinners();

        assertThat(result).containsExactlyElementsOf(expected);
    }
}

class FixedNumberGenerator implements NumberGenerator {
    private static List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static Integer index = 0;

    @Override
    public int getNumber() {
        return numbers.get(index++);
    }
}
