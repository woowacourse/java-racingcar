package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("Cars 객체 생성 성공")
    public void createCarsTest() {
        // given
        List<String> names = new ArrayList<>();
        names.add("오찌");
        names.add("연로그");

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("중복된 이름이 있으면 안된다")
    public void checkDuplicatedName() {
        // given
        List<String> names = new ArrayList<>();
        names.add("오찌");
        names.add("연로그");
        names.add("연로그");

        // when
        // then
        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }
}