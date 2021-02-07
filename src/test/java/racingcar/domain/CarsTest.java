package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    public void Cars_객체_생성_테스트() {
        Cars cars = new Cars(new String[]{"포비", "제이슨"}, new Rule());
        assertThat(cars.carList().size()).isEqualTo(2);
    }

    @Test
    void 임의의_자동차_외의_모든_자동차_전진_테스트() {
        RuleTest ruleTest = new RuleTest(); // 첫번째 자동차만 멈춤
        Cars cars = new Cars(new String[]{"포비", "제이슨"}, ruleTest); // 첫번째 자동차를 제외한 모든 자동차가 현재 최대 거리를 갖게 된다.

        cars.startRace();
        Car jason = cars.carList().get(1);
        Assertions.assertTrue(jason.isMaxPosition(1));
    }
}