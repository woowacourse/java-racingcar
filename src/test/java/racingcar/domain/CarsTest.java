package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domian.Car;
import racingcar.domian.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("예외 케이스 테스트: 게임에 참여하는 자동차 이름값이 null or empty인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void 참여자_이름이_Null_Or_Empty인_경우(String inputNames) {
        assertThatThrownBy(() -> {
            new Cars(inputNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("예외 케이스: 게임에 참여하는 자동차(유저 이름)가 5대를 초과하는 경우")
    @Test
    void 자동자가_5대_초과로_오는_경우() {
        String names = "user1,user2,user3,user4,user5,user6";
        assertThatThrownBy(() -> {
            new Cars(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 5대 초과");
    }

    @DisplayName("가장 멀리 이동한 자동차의 위치 찾기")
    @Test
    void 가장_먼_자동차의_거리() {
        String inputNames = "user1,user2,user3,user4";
        Cars cars = new Cars(inputNames);
        Car testCar = cars.getCars().get(0);
        testCar.moveByRandom(5);
        assertThat(cars.findMaxPosition()).isEqualTo(1);
    }

}
