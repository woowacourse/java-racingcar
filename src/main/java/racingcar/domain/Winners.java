package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    //위너를 도메인에서 계산해야하는가 컨트롤러에서 해야하는가..?
    private List<Car> winners = new ArrayList<>();

    // TODO: 1.생성자에서 위너를 계산해서 반환할지
    // 2. 생성자에서는 생성만 하고 계산은 함수에서 따로 할지
    //1의 경우 테스트코드에서 함수가 작동을 제대로 하는지 확인이 안됨
    //도메인의 기능을 잘 생각해보기..?
    public Winners(List<Car> cars) {
        int winPosition = getWinPosition(cars);
        this.winners = cars.stream()
                .filter(car -> car.getPosition() == winPosition)
                .collect(Collectors.toList());
    }

    public int getWinPosition(List<Car> cars) {
        cars.sort(Comparator.comparing(Car::getPosition));
        return cars.get(getLastIndex(cars)).getPosition();
    }

    private int getLastIndex(List<Car> cars) {
        return cars.size() - 1;
    }

    public List<Car> getWinners() {
        return this.winners;
    }

    public List<String> getWinnerNames() {
        return this.winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
