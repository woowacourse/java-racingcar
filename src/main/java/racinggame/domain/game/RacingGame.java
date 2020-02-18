package racinggame.domain.game;

import racinggame.domain.car.Cars;
import racinggame.domain.car.generatenumber.MovAbleStrategy;
import racinggame.domain.data.Names;
import racinggame.domain.data.GameStatus;
import racinggame.domain.car.Car;

import java.util.List;

/**
 * RacingGame 클래스는 자동차 리스트를 만들어 경주를 진행하고 그 결과를 출력한다.
 * 클래스 메서드를 통해 수행되도록 설계되었다.
 */
public class RacingGame {
    private Cars cars;

    /**
     * 이 메서드는 이름 인스턴스 외에 숫자 생성 인터페이스를 추가로 받고,
     * 이 인터페이스를 Car에 적용시킨다.
     * 이 생성자를 이용한다.
     *
     * @param names Cars 생성을 위한 이름 인스턴스이다.
     * @param movAbleStrategy Cars에서 이동 여부를 판단하기 위한 숫자 생성 인터페이스이다.
     */
    public RacingGame(Names names, MovAbleStrategy movAbleStrategy) {
        cars = new Cars(movAbleStrategy);
        initCars(names);
    }

    private void initCars(Names names) {
        List<String> splitName = names.splitNamesByComma();

        for (String name : splitName) {
            cars.add(new Car(name));
        }
    }


    /**
     * moveCars는 RacingGame에 포함되어 있는 자동차 인스턴스들 전체에 대해 accelerate를 호출하여,
     * 전진하거나 혹은 그 자리에 멈추도록 하는 메서드이다.
     * 각각의 Car 인스턴스의 accelerate 호출이 종료되면, 파라미터로 전달받은 gameStatus에 로그를 전달한다.
     * 이를 통해 자동차의 진행을 컨트롤러에서 뷰로 전달할 수 있다.
     *
     * @param gameStatus
     */
    public void moveCars(GameStatus gameStatus) {
        cars.moveCars(gameStatus);
    }
}