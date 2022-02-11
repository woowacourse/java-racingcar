package racingcar.vo;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    @DisplayName("우승자는 쉼표로 구분지어 반환한다")
    void WinnersToString() {
        String result = new Winners(List.of(Name.create("hoho"), Name.create("pobi"))).toString();

        assertThat(result).isEqualTo("hoho, pobi");
    }
}