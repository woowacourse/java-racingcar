package racinggame.domain;

import racinggame.view.OutputView;

import java.util.Random;

public class RacingGame {
    public static final int NUMBER_BOUND = 10;

    /* 인스턴스를 사용하지 않으므로 추가 */
    private RacingGame() {
    }

    public static int generateRandom() {
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        return rand.nextInt(NUMBER_BOUND);
    }

    public static Cars makeCars(Names names){
        return new Cars(names);
    }

    public static int moveCars(Cars cars, int maxPosition) {
        for(Car car: cars){
            if(car.move(generateRandom())){
                maxPosition = car.getMaxPosition(maxPosition);
            }
        }
        return maxPosition;
    }
}
