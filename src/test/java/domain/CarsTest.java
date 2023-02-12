package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차들이 ")
class CarsTest {
    private Cars defaultCars;

    @BeforeEach
    void beforeEach() {
        defaultCars  = Cars.from(List.of(
                "abc",
                "def",
                "ghi"
        ));
    }

    @DisplayName("이름에 중복이 있으면 예외 발생 O")
    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> Cars.from(List.of(
                "hi",
                "hi"
        ))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 중복될 수 없습니다");
    }


    @DisplayName("처음 초기화하면 현재의 위치(0)를 반환한다")
    @Test
    void getCarsPosition_자동차_이름_위치를_LinkedHashMap으로_반환한다2() {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("abc", 0);
        expected.put("def", 0);
        expected.put("ghi", 0);

        assertThat(defaultCars.getCarsPosition()).isEqualTo(expected);
    }

    @DisplayName("move는_각_자동차의_move메서드를_호출한다")
    @Test
    void move_각_자동차의_move메서드를_호출한다() {
        defaultCars.move(new TestNumberGenerator(4, 9, 3));

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("abc", 1);
        expected.put("def", 1);
        expected.put("ghi", 0);

        assertThat(defaultCars.getCarsPosition()).isEqualTo(expected);
    }

    @DisplayName("가장 많이 전진(모든 차가 위치가 0인 경우)하면 승자가 된다.")
    @Test
    void identifyWinners_위치가_가장_큰_자동차들_이름_반환1() {
        assertThat(defaultCars.identifyWinners()).containsExactly("abc", "def", "ghi");
    }

    @DisplayName("가장 많이 전진(모든 차가 위치가 0이 아닌 경우)하면 승자가 된다.")
    @Test
    void identifyWinners_위치가_가장_큰_자동차들_이름_반환2() {
        defaultCars.move(new TestNumberGenerator(3, 5, 9));
        assertThat(defaultCars.identifyWinners()).containsExactly("def", "ghi");
    }

    private class TestNumberGenerator implements NumberGenerator {
        private Iterator<Integer> iterator;

        public TestNumberGenerator(int... sequence) {
            iterator = Arrays.stream(sequence).iterator();
        }

        @Override
        public int generate() {
            if (!iterator.hasNext()) {
                throw new IllegalArgumentException();
            }
            return iterator.next();
        }
    }
}
