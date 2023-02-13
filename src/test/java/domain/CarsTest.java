package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @DisplayName("중복된 이름이 있으면 예외 발생")
    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> Cars.from(List.of("a", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 중복될 수 없습니다");
    }

    @DisplayName("우승자는 가장 멀리 간 차들이다")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 5, 9})
    void getWinnersTest(int next) {
        //given
        Cars cars = Cars.from(List.of("a", "b", "c"));

        //when
        cars.move(generator(next));

        //then
        assertThat(cars.getWinners())
                .containsExactly("a", "b", "c");
    }

    private Random generator(int next){
        return new Random(){
            @Override
            public int nextInt(int bound){
                return next;
            }
        };
    }
}