import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 5글자이하여야하며 빈칸은 허용하지 않는다.")
    @ValueSource(strings = {" ", "abcdefg", "  "})
    void createCarExceptionTest(String name){
        assertThrows(IllegalArgumentException.class, ()-> new Car(name));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(name));
        assertThat(e.getMessage()).isEqualTo("자동차 이름이 유효하지 않습니다.");
    }

    @Test
    @DisplayName("자동차가 제대로 이동하는지 확인한다.")
    void moveCarTest() {
        Car car = new Car("pika");
        car.movePosition();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    //    ## 기능 요구사항
//  - [x] 경주할 자동차 이름을 입력받는다.
//    - [x] 예외 : 플레이어수 2명 이상
//    - [x] 예외 : 중복 금지
//    - [x] 입력 처리 : 빈칸 trim 쉼표(,) 기준으로 split
//  - [x] 시도할 횟수를 입력받는다.
//  - [x] 0부터 9사이의 랜덤 값으로 자동차를 전진시킨다.
//    - [x] 전진 조건 : 랜덤 값 4 이상
//    - [x] 멈춤 조건 : 랜덤 값 3 이하
//  - [x] 실행 결과(전진 횟수)를 출력한다.
//            - [x] 최종 우승자를 출력한다.
//    - [x] 공동 우승자가 가능하다.

//    public class CarNamesInputTest {
//
//        @ParameterizedTest
//        @DisplayName("자동차 이름은 쉼표로 구분한다")
//        @MethodSource("provideInputsFor_자동차_이름_리스트_반환")
//        public void getCarNames_자동차_이름은_쉼표로_구분한다(String input, List<String> expected) {
//            CarNamesInput carNamesInput =  CarNamesInput.valueOf(input);
//            assertEquals(expected, carNamesInput.getCarNames());
//        }
//
//        private static Stream<Arguments> provideInputsFor_자동차_이름_리스트_반환() {
//            return Stream.of(
//                    Arguments.of("포비,로이드,워니", Arrays.asList("포비", "로이드", "워니")),
//                    Arguments.of("a,d", Arrays.asList("a", "d")),
//                    Arguments.of("q,d,e,g,c,s", Arrays.asList("q", "d", "e", "g", "c", "s"))
//            );
//        }
//
//        @ParameterizedTest
//        @DisplayName("자동차 이름에 중복이 있으면 예외")
//        @ValueSource(strings = {"a,a,a", "a,b,c,a", "a,b,c,d,e,f,f"})
//        public void getCarNames_자동차_이름에_중복이_있으면_예외(String input) {
//            assertThatExceptionOfType(CarNameDuplicateException.class)
//                    .isThrownBy(() -> CarNamesInput.valueOf(input))
//                    .withMessageContaining(new CarNameDuplicateException().getMessage());
//        }
}
