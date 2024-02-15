package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("전진 여부를 정확히 구하는 지 테스트.")
    @Test
    public void test(){
        NumberGenerator numberGenerator = new NumberGenerator() {
            @Override
            public int generator() {
                return 4;
            }
        };
        RacingCar racingCar = new RacingCar("bito", numberGenerator);
        racingCar.race();
        Assertions.assertThat(racingCar.getMoveNumber()).isEqualTo(1);
    }

}