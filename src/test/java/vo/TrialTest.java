package vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Trial VO객체 테스트")
class TrialTest {
    @Nested
    @DisplayName("of() 메소드 테스트")
    class OfTest {
        @Test
        @DisplayName("Trial 객체는 생성자로 접근이 불가능하고, 정적 메소드 of() 를 통해 생성할 수 있다.")
        void givenNumber_whenGeneratingTrial_thenReturnsTrial() {
            long trialNumber = 30L;

            Trial trial = Trial.of(trialNumber);

            assertThat(trial)
                    .as("정상적으로 객체가 생성된다.")
                    .isNotNull();
        }
    }

    @Nested
    @DisplayName("객체 동일성 테스트")
    class EqualsAndHashcodeTest {
        @Test
        @DisplayName("Trial VO 객체는 내부 필드의 값이 동일하면 동일한 객체로 간주한다.")
        void givenTrialsHavingSameNumber_whenCallingEquals_thenReturnsTrue() {
            Trial trial1 = Trial.of(20L);
            Trial trial2 = Trial.of(20L);

            assertThat(trial1)
                    .as("equals() 메소드 결과가 true이다.")
                    .isEqualTo(trial2);
            assertThat(trial1.hashCode())
                    .as("hash값이 동일하다.")
                    .isEqualTo(trial2.hashCode());
        }
    }

    @Nested
    @DisplayName("getValue() 메소드 테스트")
    class GetValueOfTest {
        @Test
        @DisplayName("getValue()를 통해 내부의 원시값을 가져올 수 있다.")
        void givenTrial_whenGettingValue_thenReturnsValue() {
            long expected = 10L;
            Trial trial = Trial.of(expected);

            Long value = trial.getValue();

            assertThat(value)
                    .as("getValue() 호출시 내부 필드인 Long 타입의 수를 반환한다.")
                    .isEqualTo(expected);
        }
    }
}