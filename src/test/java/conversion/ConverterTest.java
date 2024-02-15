package conversion;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Car;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    @DisplayName("자동차 이름 변환 작업 테스트 (1): String -> List<Car>")
    void toCars() {
        // given
        String rawCarNames = "aa,bb,cc";

        // when
        List<Car> carsActual = Converter.toCars(rawCarNames);

        // then
        assertEquals("aa", carsActual.get(0).getName());
        assertEquals("bb", carsActual.get(1).getName());
        assertEquals("cc", carsActual.get(2).getName());
    }

    @Test
    @DisplayName("자동차 이름 변환 작업 테스트 (2): 공백 제거 테스트")
    void toCars_trimBlank() {
        // given
        String rawCarNames = "  aa  ,    bb , cc  ";

        // when
        List<Car> carsActual = Converter.toCars(rawCarNames);

        // then
        assertEquals("aa", carsActual.get(0).getName());
        assertEquals("bb", carsActual.get(1).getName());
        assertEquals("cc", carsActual.get(2).getName());
    }

    @Test
    @DisplayName("시도 횟수 변환 작업 테스트: String -> int")
    void toRound() {
        // given
        String rawRound = "100";

        // when
        int roundActual = Converter.toRound(rawRound);

        // then
        assertEquals(100, roundActual);
    }
}