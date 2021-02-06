package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RandomNumberTest {
    @Test
    @DisplayName("지정된 범위의 난수 생성")
    void random_number_make(){
        for (int i = 0; i < 999999; i++) {
            int madeNumber = RandomNumber.make();
            assertThat(madeNumber).isBetween(0, 9);
        }
    }
}
