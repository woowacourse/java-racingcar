package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceCarsTest {

    @Nested
    @DisplayName("자동차 경주 생성 테스트")
    class CarNameTest {

        @ParameterizedTest
        @CsvSource(value = {"hi"})
        @DisplayName("이름은 중복일 수 없다")
        void invalidateCarName() {
            List<Car> cars = List.of(
                    new Car("hi"),
                    new Car("hi")
            );
            assertThatThrownBy(() -> new RaceCars(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("참여자는 두명 이상이다")
        void invalidateParticipant() {
            List<Car> cars = List.of(
                    new Car("hi")
            );
            assertThatThrownBy(() -> new RaceCars(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다")
    void getWinners() {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        List<Car> cars = new ArrayList<>(List.of(one, two, three));
        RaceCars raceCars = new RaceCars(cars);

        one.move(4);
        two.move(0);
        three.move(8);

        RacingGame racingGame = new RacingGame(raceCars, new Count(1));

        //when
        List<Car> winners = racingGame.judgeWinners();

        //then
        assertThat(winners).contains(one, three);
    }
}
