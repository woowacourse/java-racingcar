package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class CarTest {

    @DisplayName("자동차 이동 테스트 실패")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 3})
    void isMoveFail(int input) {
        Car car = new Car("test",new RandomGenerator(new Random(){
            @Override
            public int nextInt(int bound){
                return input;
            }
        }));

        assertThat(car.isMove()).isEqualTo(false);
    }

    @DisplayName("자동차 이동 테스트 성공")
    @ParameterizedTest
    @ValueSource(ints = {4, 100, 1000})
    void isMoveSuccess(int input) {
        Car car = new Car("test",new RandomGenerator(new Random(){
            @Override
            public int nextInt(int bound){
                return input;
            }
        }));

        assertThat(car.isMove()).isEqualTo(true);
    }
}