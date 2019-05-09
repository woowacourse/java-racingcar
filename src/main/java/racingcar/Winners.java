package racingcar;

import java.util.*;

public class Winners {
    private List<Car> Winners = new ArrayList<>();

    Winners(List<Car> listOfCars) {
        //listOfCars에서 가장 높은 position탐색
        int maxPosition = decideMaxPosition(listOfCars);
        //for loop롤 cars돌면서 가장 높은 position를 갖고 있는 차들 Winners등록
    }

    public static int decideMaxPosition(List<Car> listOfCars) {
        int max = 0;
        for (int i=0, n=listOfCars.size(); i<n; i++) {
            max = listOfCars.get(i).compare(max);
        }
        return max;
    }

}
