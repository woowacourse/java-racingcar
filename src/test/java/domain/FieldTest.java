package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

public class FieldTest {
    @Test
    void test() {
        Field field = new Field(new CarFactory("pobi,weve"), new FixedNumberGenerator());
        field.race(2);

        String expected = "\n실행 결과\npobi : \nweve : \n\npobi : \nweve : -\n\nweve가 최종 우승했습니다.";
        String result = field.getResult();

        assertThat(result).isEqualTo(expected);
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
