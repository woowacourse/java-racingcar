package racingcar;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void isMakeCarTest(){
        List<String> nameList = Arrays.asList("a", "b");
        Cars cars = new Cars(nameList);
        assertThat(cars.isMakeCar(nameList)).isEqualTo(true);
    }
}
