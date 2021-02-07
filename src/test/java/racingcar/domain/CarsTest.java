package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    public void Cars_객체_생성_테스트() {
        Cars cars = new Cars(new String[]{"포비", "제이슨"}, new Rule());
        assertThat(cars.carList().size()).isEqualTo(2);
    }

//    @Test
//    void 자동차가_이동하는_함수_정상_작동_테스트() {
//        RuleTest ruleTest = new RuleTest();
//        Cars cars = new Cars(new String[]{"포비", "제이슨"}, ruleTest);
//
//        ruleTest.number = 1;  // 임의의 랜덤 함수가 1로 지정
//        cars.startRace();
//        assertThat(cars.getCarPositions()).containsExactly(0, 0);
//
//        ruleTest.number = 4;  // 임의의 랜덤 함수가 4로 지정
//        cars.startRace();
//        assertThat(cars.getCarPositions()).containsExactly(1, 1);
//    }
}