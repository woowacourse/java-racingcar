package racingcar.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

public class WinnersTest {

    @Test
    @DisplayName("우승자 생성 확인")
    void winners_make() {
        AssertionsForClassTypes.assertThat(
            Winners.award(new Cars("1,2,3").getCars()).size()).isEqualTo(3);
    }

}
