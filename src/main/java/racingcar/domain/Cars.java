package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;
    private Rule rule;

    public Cars(String[] names) {
        carList = new ArrayList<>();
        this.carList.addAll(Arrays.stream(names)
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
        rule = new Rule();
    }

    public List<String> getCarNames() {
        return carList.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public void startRace() {
        for (Car car : carList) {
            car.move(rule.execute());
        }
    }
}
/*
* move() --> getRanomNO() : 난수 생성으로 인해서 테스가 어려움 즉, 테스트 하고자 하는게
* "4 이상이면 position++ " 기능을 테스트하고 싶음.
*
* 4 이상인 경우 (즉, 규칙에 대한 검증)
* RuleTest : 규칙이 완료됐으면 true/false
*
* position++ (이동 거리 검증)
* car.move(true) / car.move(false) :: car.position == 원래 거리 + 1
* */
