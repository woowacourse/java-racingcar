package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    GameManager gameManager = new GameManager();

    @Test
    void splitUserInputByComma() throws Exception {
        Method privateMethod = getPrivateMethod("splitUserInputByComma", String.class);

        String[] splitResult = (String[]) privateMethod.invoke(gameManager, "a,bc,bacon");

        assertThat(splitResult).containsExactly("a","bc","bacon");
    }

    @Test
    void initCars() throws Exception {
        Method privateMethod = getPrivateMethod("initCars", String[].class);
        String[] carNames = new String[] {"a","bc","bacon"};

        privateMethod.invoke(gameManager, (Object) carNames);

        assertThat(gameManager.cars.size()).isEqualTo(3);
        for (int idx = 0; idx < 3; idx++) {
            Car car = gameManager.cars.get(idx);
            assertThat(car.getName()).isEqualTo(carNames[idx]);
        }
    }

    private Method getPrivateMethod(String methodName, Class<?>... argsType) throws NoSuchMethodException {
        Method privateMethod = gameManager.getClass()
                .getDeclaredMethod(methodName, argsType);
        privateMethod.setAccessible(true);
        return privateMethod;
    }
}
