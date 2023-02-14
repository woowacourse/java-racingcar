package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.UserNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("중복 이름이 있을 때 예외가 발생한다")
    void duplicateTest() {

        assertThatThrownBy(() -> new Cars(new String[]{"aa", "aa"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("이름의 공백을 제거하고 중복 체크를 한다")
    void trimTest() {
        assertThatThrownBy(() -> new Cars(new String[]{"aa", " aa "}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("경기에 참여하는 차가 한대일때 예외가 발생한다")
    void oneCarTest() {

        assertThatThrownBy(() -> new Cars(new String[]{"aa"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("둘 이상");
    }

    @Test
    @DisplayName("UserNumberGenerator를 이용하면 차 전체가 1 이동한다.")
    void UserNumberGenerator_MoveCars_Test() {
        NumberGenerator numberGenerator = new UserNumberGenerator();
        Cars cars = new Cars(new String[]{"a", "b", "c", "d"});

        cars.moveCars(numberGenerator);
        List<Integer> result = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(result).containsOnly(1);

    }
}
