package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("우승자 선정이 잘 되는지 테스트")
    public void check_get_winners() {
        List<Name> names = Arrays.asList(new Name("test1"), new Name("test2"), new Name("test3"));
        List<Position> positions = Arrays
            .asList(new Position(7), new Position(11), new Position(4));
        Cars cars = new Cars(names, positions);

        assertThat(cars.getWinners().get(0).getName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("자동차 이름 중복 예외 발생 테스트")
    public void check_name_duplicate_exception() {
        List<Name> names = Arrays.asList(new Name("test1"), new Name("test2"), new Name("test1"));

        assertThatThrownBy(() -> new Cars(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 중복이 불가능합니다.");
    }

}