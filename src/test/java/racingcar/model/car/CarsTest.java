package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @DisplayName("add 메소드는")
    @Nested
    class Add {
        @Nested
        @DisplayName("중복 이름을 가진 차가 주어진다면")
        class Context_with_duplicate_name_of_car {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                Cars cars = new Cars();
                cars.add(new Car("car1"));
                assertThatThrownBy(() -> cars.add(new Car("car1")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이미 존재하는 자동차 이름입니다.");
            }
        }

        @Nested
        @DisplayName("중복되지 않는 이름을 가진 차가 주어진다면")
        class Context_with_not_duplicate_name_of_car {
            @Test
            @DisplayName("추가 시키고 예외를 발생시키지 않는다.")
            void it_add_car() {
                Cars cars = new Cars();
                cars.add(new Car("car1"));

                assertDoesNotThrow(() -> cars.add(new Car("car2")));
            }
        }
    }

    @Nested
    @DisplayName("race 메소드는")
    class Describe_race {
        @Nested
        @DisplayName("만약 모든 차에게 true 값을 주면")
        class Context_Number_of_4_or_more {
            @Test
            @DisplayName("모든 차의 위치는 1 증가한다.")
            void it_increase_position_of_cars() {
                Cars cars = new Cars();
                cars.add(new Car("car1"));
                cars.add(new Car("car2"));
                cars.add(new Car("car3"));
                cars.race(() -> true);
                for (Car carInformation : cars.getCars()) {
                    assertThat(carInformation.getPosition()).isEqualTo(1);
                }
            }
        }

        @Nested
        @DisplayName("참가한 자동차가 없다면")
        class Empty_Cars {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                Cars cars = new Cars();

                assertThatThrownBy(() -> cars.race(() -> true))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("아무 차량도 추가되지 않았습니다.");
            }
        }
    }

    @Nested
    @DisplayName("getWinnerNames 메소드는")
    class GetWinnerNames {
        @Test
        @DisplayName("가장 멀린 간 위치에 있는 차들의 이름 리스트로 리턴한다.")
        void it_returns_car_name_list() {
            Cars cars = new Cars();
            cars.add(new Car("car1", 10));
            cars.add(new Car("car2", 1));
            cars.add(new Car("car3", 10));

            assertThat(cars.getWinnersNames()).containsExactly("car1", "car3");
        }

        @Nested
        @DisplayName("참가한 자동차가 없다면")
        class Empty_Cars {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                Cars cars = new Cars();

                assertThatThrownBy(() -> cars.getWinnersNames())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("아무 차량도 추가되지 않았습니다.");
            }
        }

    }
}
