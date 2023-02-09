package util;

import domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class FinderTest {
    @DisplayName("자동차 객체들 중 가장 높은 step값 찾기")
    @Test
    void 가장_높은_스텝값_찾기() {
        Car carA = new Car("carA");
        carA.increaseStep();

        Car carB = new Car("carB");
        carB.increaseStep();
        carB.increaseStep();

        Car carC = new Car("carC");
        carC.increaseStep();
        carC.increaseStep();
        carC.increaseStep();

        Assertions.assertEquals(Finder.findMaxStep(Arrays.asList(carA, carB, carC)), 3);
    }

    @DisplayName("자동차들이 모두 이동하지 않았을 때 0을 반환해야 한다.")
    @Test
    void 스텝이_모두_0인경우() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        Assertions.assertEquals(Finder.findMaxStep(Arrays.asList(carA, carB, carC)), 0);
    }

}