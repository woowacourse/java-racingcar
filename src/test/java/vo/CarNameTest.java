package vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    @Nested
    @DisplayName("of() 메소드 테스트")
    class OfTest {
        @Test
        @DisplayName("CarName 객체는 생성자로 접근이 불가능하고, 정적 메소드 of() 를 통해 생성할 수 있다.")
        void givenCarName_whenGeneratingCarName_thenReturnsCarName() {
            String name = "Car";

            CarName carName = CarName.of(name);

            assertThat(carName)
                    .as("정상적으로 객체가 생성된다.")
                    .isNotNull();
        }

        @Test
        @DisplayName("다양한 이름의 여러 CarName 객체를 만들고 싶다면, 이름값이 담긴 리스트를 인자로 넘겨 List를 반환받을 수 있다.")
        void givenCarNames_whenGeneratingCarName_thenReturnsCarNames() {
            List<String> names = List.of("Car", "Car2", "Car3");

            List<CarName> carNames = CarName.of(names);

            assertThat(carNames)
                    .containsExactly(
                            CarName.of("Car"),
                            CarName.of("Car2"),
                            CarName.of("Car3")
                    );
        }
    }

    @Nested
    @DisplayName("객체 생성시 검증 테스트")
    class ValidationTest {
        @Test
        @DisplayName("자동차 이름의 길이가 5 이하인 경우 정상적으로 객체를 생성할 수 있다.")
        void givenCarNameUnder5Length_whenGeneratingCarName_thenSuccess() {
            String name = "AmCar";

            assertThatCode(() -> CarName.of(name))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("자동차 이름의 길이가 5 초과인 경우 IllegalArgumentException이 발생한다.")
        void givenCarNameOver5Length_whenGeneratingCarName_thenThrowsException() {
            String name = "CarOver5";

            assertThatThrownBy(() -> CarName.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(CarName.INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
        }

        @Test
        @DisplayName("여러 CarName 객체를 생성하는 of 메소드를 호출할 때에도 검증 로직은 똑같이 적용된다.")
        void givenCarNamesHavingInvalid_GeneratingCarNames_thenThrowsException() {
            List<String> names = List.of("Car", "Car2", "CarOver5", "Car3");

            assertThatThrownBy(() -> CarName.of(names))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(CarName.INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    @Nested
    @DisplayName("객체 동일성 테스트")
    class EqualsAndHashcodeTest {
        @Test
        @DisplayName("CarName VO 객체는 내부 필드의 값이 동일하면 동일한 객체로 간주한다.")
        void givenCarNamesHavingSameName_whenCallingEquals_thenReturnsTrue() {
            CarName carName = CarName.of("Car");
            CarName carName2 = CarName.of("Car");

            assertThat(carName)
                    .as("equals() 메소드 결과가 true이다.")
                    .isEqualTo(carName2);
            assertThat(carName.hashCode())
                    .as("hash값이 동일하다.")
                    .isEqualTo(carName2.hashCode());
        }
    }

    @Nested
    @DisplayName("getValue() 테스트")
    class getValueTest {
        @Test
        @DisplayName("getValue()를 통해 내부의 원시값을 가져올 수 있다.")
        void givenCarName_whenGettingValue_thenReturnsValue() {
            String expected = "Car";
            CarName carName = CarName.of(expected);

            String value = carName.getValue();

            assertThat(value)
                    .as("getValue() 호출시 내부 필드인 String 타입의 이름을 반환한다.")
                    .isEqualTo(expected);
        }
    }

}