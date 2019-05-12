package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    @Test
    void 문자열을받아서_자동차리스트_반환() {
        List<Car> resultList = new ArrayList<>();
        resultList.add(new Car("pobi"));
        resultList.add(new Car("crong"));
        resultList.add(new Car("honux"));

        assertThat(new RacingGame("pobi,crong,honux").getCars()).isEqualTo(resultList);
    }
}
