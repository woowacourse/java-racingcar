package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
            assertThatThrownBy(() -> new RaceCars(cars, new RandomNumberGenerator()))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("참여자는 두명 이상이다")
        void invalidateParticipant() {
            List<Car> cars = List.of(
                    new Car("hi")
            );
            assertThatThrownBy(() -> new RaceCars(cars, new RandomNumberGenerator()))
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
        RaceCars raceCars = new RaceCars(cars, new RandomNumberGenerator());

        one.move(4);
        two.move(0);
        three.move(8);

        RacingGame racingGame = new RacingGame(raceCars, new Count(1));

        //when
        List<Car> winners = racingGame.judgeWinners();

        //then
        assertThat(winners).contains(one, three);
    }


    @Nested
    @DisplayName("경주 테스트")
    class PlayTest {

        @ParameterizedTest
        @ValueSource(ints = {4, 9})
        @DisplayName("랜덤값이 4이상이면 한 칸 전진한다.")
        void playWithMove(int random) {
            NumberGenerator numberGenerator = () -> random;

            Car one = new Car("one");
            Car two = new Car("two");
            List<Car> cars = new ArrayList<>(List.of(one, two));
            RaceCars raceCars = new RaceCars(cars, numberGenerator);

            raceCars.play();

            Car car = raceCars.getCar(0);

            assertThat(car.getRoundLocation(1)).isEqualTo(1);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 3})
        @DisplayName("랜덤값이 4미만이면 정지한다.")
        void playWithStop(int random) {
            NumberGenerator numberGenerator = () -> random;

            Car one = new Car("one");
            Car two = new Car("two");
            List<Car> cars = new ArrayList<>(List.of(one, two));
            RaceCars raceCars = new RaceCars(cars, numberGenerator);

            raceCars.play();

            Car car = raceCars.getCar(0);

            assertThat(car.getRoundLocation(1)).isEqualTo(0);
        }
    }

}
