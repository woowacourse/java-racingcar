package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarNameFactory;
import racingcar.domain.CarFactory;

public class RacingTest {

    @DisplayName("자동차 레이싱시 잘 달리고, 달린 정보를 리턴해주는지 확인")
    @Test
    void makeCars() {
        CarNameFactory carNameFactory = new CarNameFactory("aaa,bbb,ccc");
        CarFactory carFactory = new CarFactory(carNameFactory);
        String progress = Racing.run(carFactory, 10).toString();
        assertThat(progress).contains("aaa :")
            .contains("bbb :")
            .contains("ccc : ")
            .contains("-");
    }
}
