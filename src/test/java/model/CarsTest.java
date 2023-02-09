package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 테스트")
    void createCarsTest(){
        Cars cars = new Cars("pobi,crong,honux");

        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}