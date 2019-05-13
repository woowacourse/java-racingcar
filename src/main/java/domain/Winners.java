package domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 우승차를 구하는 클래스
 * <br> Winenrs winners = new Winners(raceCars)
 * <br> winners.getWinnersName()
 *
 * @author heebg
 * @version 1.0 2019-05-12
 */
public class Winners {
    private int maxPosition;
    private List<Car> winners;

    /**
     * Winners 생성자
     * <br> 자동차들을 받으면 우승차와 우승 위치를 계산 후 초기화
     *
     * @param raceCars 자동차들
     */
    public Winners(List<Car> raceCars) {
        this.maxPosition = setMaxPosition(raceCars);
        this.winners = setWinner(raceCars);
    }

    private int setMaxPosition(List<Car> raceCars) {
        Car maxCar = raceCars.stream().max(Car::compareTo).get();
        int max = Const.CAR_OBJ_INIT_POSITION;
        while (maxCar.isGreater(max)) {
            ++max;
        }
        return max;
    }

    private List<Car> setWinner(List<Car> raceCars) {
        winners = raceCars.stream().filter(x -> x.isMatchPosition(maxPosition))
                .collect(toList());
        return winners;
    }

    /**
     * 우승차들의 이름을 반환
     *
     * @return , 로 연결된 우승차 이름들
     */
    public String getWinnersName() {
        List<String> names = new ArrayList<>();
        winners.stream().forEach(x -> names.add(x.toString().split(" ")[0]));
        return String.join(",", names);
    }

    /**
     * 우승 위치가 맞는지 확인
     *
     * @param position 위치
     * @return true : 우승 위치가 맞는 경우
     */
    public boolean isMatchMaxPosition(int position) {
        if (maxPosition == position) {
            return true;
        }
        return false;
    }
}
