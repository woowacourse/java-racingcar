package model.car;

import model.manager.ThresholdCarMoveManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StadiumTest {

    @Test
    @DisplayName("자동차가 경기장에 정상적으로 저장되는지 확인한다.")
    void carSetTest() {
        Car gitJjang = new Car("깃짱");
        Car irene = new Car("이리내");
        Stadium stadium = new Stadium(new Cars(Arrays.asList(gitJjang, irene)), new ThresholdCarMoveManager());

        assertThat(stadium.getCurrentResult().size()).isEqualTo(2);
        assertThat(stadium.getCurrentResult().containsAll(Arrays.asList(gitJjang, irene)));
    }

}
