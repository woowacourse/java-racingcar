package vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Nested
    @DisplayName("of() 메소드 테스트")
    class OfTest {
        @Test
        @DisplayName("Position 객체는 생성자로 접근이 불가능하고, 정적 메소드 of() 를 통해 생성할 수 있다.")
        void givenPosition_whenGeneratingPosition_thenReturnsPosition() {
            long positionNumber = 30L;

            Position position = Position.of(positionNumber);

            assertThat(position)
                    .as("정상적으로 객체가 생성된다.")
                    .isNotNull();
        }
    }

    @Nested
    @DisplayName("객체 동일성 테스트")
    class EqualsAndHashcodeTest {
        @Test
        @DisplayName("Position VO 객체는 내부 필드의 값이 동일하면 동일한 객체로 간주한다.")
        void givenPositionsHavingSameNumber_whenCallingEquals_thenReturnsTrue() {
            Position position1 = Position.of(20L);
            Position position2 = Position.of(20L);

            assertThat(position1)
                    .as("equals() 메소드 결과가 true이다.")
                    .isEqualTo(position2);
            assertThat(position1.hashCode())
                    .as("hash값이 동일하다.")
                    .isEqualTo(position2.hashCode());
        }
    }

    @Nested
    @DisplayName("getValue() 테스트")
    class getValueTest {
        @Test
        @DisplayName("getValue()를 통해 내부의 원시값을 가져올 수 있다.")
        void givenPosition_whenGettingValue_thenReturnsValue() {
            long expected = 10L;
            Position position = Position.of(expected);

            Long value = position.getValue();

            assertThat(value)
                    .as("getValue() 호출시 내부 필드인 Long 타입의 수를 반환한다.")
                    .isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("plus() 메소드 테스트")
    class PlusTest {
        @Test
        @DisplayName("이동 거리를 1 늘리는 plus() 메소드 호출시, 필드 내부의 값은 변하지 않고 position 값이 1 증가한 새로운 객체를 반환한다.")
        void givenPosition_whenAddingPosition_thenReturnsNewPosition() {
            Position position = Position.of(3L);

            Position plusPosition = position.plus();

            assertThat(position.getValue())
                    .as("처음 생성한 position 객체의 내부 값은 그대로 있다.")
                    .isEqualTo(3L);
            assertThat(plusPosition.getValue())
                    .as("plus() 메소드 호출 후 새로 생성되어 반환된 객체는 position 값이 1 증가해 있다.")
                    .isEqualTo(4L);
        }
    }

    @Nested
    @DisplayName("isValueOf() 메소드 테스트")
    class IsValueOfTest {
        @Test
        @DisplayName("주어진 이동 정도 값을 나타내는 Position 객체인 지 확인하고 싶을 때에는 isValueOf 메소드를 호출할 수 있다.")
        void givenPositionNumber_whenCallingIsValueOf_thenReturnsIfPositionHavingGivenNumber() {
            long positionNumber = 30L;
            Position position = Position.of(positionNumber);

            assertThat(position.isValueOf(positionNumber))
                    .as("Position 객체가 주어진 long 값을 필드로 가지고 있으므로 true를 반환한다.")
                    .isTrue();
        }
    }
}