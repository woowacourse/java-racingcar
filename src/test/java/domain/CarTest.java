package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"","abcdef"})
    void carGenerateTest(String name){
        //When
        Throwable result = catchThrowable(()->{new Car(name);});

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

}
