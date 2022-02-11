package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameManagerTest {

    GameManager gameManager = new GameManager("a,bc","5");

    @Test
    void splitUserInputByComma() throws Exception {
        Method privateMethod = getPrivateMethod("splitUserInputByComma", String.class);

        String[] splitResult = (String[]) privateMethod.invoke(gameManager, "a,bc,bacon");

        assertThat(splitResult).containsExactly("a", "bc", "bacon");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,bc,bacon", "1,공 백,$!@#^"})
    void getValidateCarNames_returnSplitResultOnValidInput(String carNamesInput) throws Exception {
        Method validateCarNamesMethod = getValidateCarNamesMethod();

        assertThatNoException().isThrownBy(
                () -> validateCarNamesMethod.invoke(gameManager, carNamesInput)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", " ,a,bc", "ab,,cde"})
    void getValidateCarNames_errorOnBlank(String carNamesInput) throws Exception {
        Method validateCarNamesMethod = getValidateCarNamesMethod();

        assertThatThrownBy(
                () -> validateCarNamesMethod.invoke(gameManager, carNamesInput)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,a", "abc,abc,de"})
    void getValidateCarNames_errorDuplicate(String carNamesInput) throws Exception {
        Method validateCarNamesMethod = getValidateCarNamesMethod();

        assertThatThrownBy(
                () -> validateCarNamesMethod.invoke(gameManager, carNamesInput)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "carrots,1,2"})
    void getValidateCarNames_errorOnOverFiveCharacters(String carNamesInput) throws Exception {
        Method validateCarNamesMethod = getValidateCarNamesMethod();

        assertThatThrownBy(
                () -> validateCarNamesMethod.invoke(gameManager, carNamesInput)
        );
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

    private Method getValidateCarNamesMethod() throws NoSuchMethodException {
        String methodName = "getValidateCarNames";
        return getPrivateMethod(methodName, String.class);
    }

    private Method getValidateTotalRoundsMethod() throws NoSuchMethodException {
        String methodName = "getValidateTotalRounds";
        return getPrivateMethod(methodName, String.class);
    }
}
