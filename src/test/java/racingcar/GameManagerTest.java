package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameManagerTest {

    GameManager gameManager = new GameManager();

    @Test
    void splitUserInputByComma() throws Exception {
        Method privateMethod = getPrivateMethod("splitUserInputByComma", String.class);

        String[] splitResult = (String[]) privateMethod.invoke(gameManager, "a,bc,bacon");

        assertThat(splitResult).containsExactly("a", "bc", "bacon");
    }

    @Test
    void initCars() throws Exception {
        Method privateMethod = getPrivateMethod("initCars", String[].class);
        String[] carNames = new String[]{"a", "bc", "bacon"};

        privateMethod.invoke(gameManager, (Object) carNames);

        assertThat(gameManager.cars.size()).isEqualTo(3);
        for (int idx = 0; idx < 3; idx++) {
            Car car = gameManager.cars.get(idx);
            assertThat(car.getName()).isEqualTo(carNames[idx]);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "10"})
    void getValidateTotalRounds_passesOnPositiveIntString(String totalRoundsInput) throws Exception {
        Method validateTotalRoundsMethod = getValidateTotalRoundsMethod();

        assertThatNoException().isThrownBy(
                () -> validateTotalRoundsMethod.invoke(gameManager, totalRoundsInput)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "eng", "$", "1.0"})
    void getValidateTotalRounds_errorOnNonInteger(String totalRoundsInput) throws Exception {
        Method validateTotalRoundsMethod = getValidateTotalRoundsMethod();

        assertThatThrownBy(
                () -> validateTotalRoundsMethod.invoke(gameManager, totalRoundsInput)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void getValidateTotalRounds_errorOnNonPositiveInteger(String totalRoundsInput) throws Exception {
        Method validateTotalRoundsMethod = getValidateTotalRoundsMethod();

        assertThatThrownBy(
                () -> validateTotalRoundsMethod.invoke(gameManager, totalRoundsInput)
        );
    }

    private Method getPrivateMethod(String methodName, Class<?>... argsType) throws NoSuchMethodException {
        Method privateMethod = gameManager.getClass()
                .getDeclaredMethod(methodName, argsType);
        privateMethod.setAccessible(true);
        return privateMethod;
    }

    private Method getValidateTotalRoundsMethod() throws NoSuchMethodException {
        String methodName = "getValidateTotalRounds";
        return getPrivateMethod(methodName, String.class);
    }
}
