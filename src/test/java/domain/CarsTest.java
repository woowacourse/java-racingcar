package domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void carsGenerateTest(){
        //Given
        List<Car> testCase = new ArrayList<>();

        //When
        Throwable result = catchThrowable(()->{new Cars(testCase);});

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}