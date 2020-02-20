package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domian.Cars;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("예외 케이스: 게임에 참여하는 자동차(유저 이름)가 5대를 초과하는 경우")
    @Test
    void 자동자가_5대_초과로_오는_경우() {
        String names = "user1,user2,user3,user4,user5,user6";
        assertThatThrownBy(() -> {
            new Cars(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 5대 초과");
    }
}
