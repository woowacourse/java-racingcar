package racingcar;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    GameManager gameManager = new GameManager();

    @Test
    void splitUserInputByComma() throws Exception {
        Method privateMethod = getPrivateMethod("splitUserInputByComma", String.class);

        String[] splitResult = (String[]) privateMethod.invoke(gameManager, "a,bc,bacon");

        assertThat(splitResult).containsExactly("a","bc","bacon");
    }

    private Method getPrivateMethod(String methodName, Class<?>... argsType) throws NoSuchMethodException {
        Method privateMethod = gameManager.getClass()
                .getDeclaredMethod(methodName, argsType);
        privateMethod.setAccessible(true);
        return privateMethod;
    }
}
