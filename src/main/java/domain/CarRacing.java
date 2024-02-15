package domain;

import io.InputView;
import io.OutputView;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: main 메서드 분리 (O)
 * - 외부에서 CarRacing을 시작시키는 역할과, CarRacing을 직접적으로 수행하는 역할의 분리 필요성을 느낌
 * - 네이밍은 CarRacingApplication?
 * <p>
 * TODO: IO 객체 초기화를 생성자 주입 방식으로 변경 (O)
 * - 테스트 상황 또는 다른 어떠한 특정 상황에는 다른 문구를 출력하거나 다른 처리를 해야할 수도 있음
 * - 이럴 때 현재 차용한 필드 초기화 방식을 사용하면 변경이 불가능한 딱딱한 설계가 문제가 됨
 * - 떄문에 IO 객체는 생성자 주입 방식으로 초기화해주었으면 좋겠다고 느낌
 * <p>
 * TODO: 메서드, 도메인 객체 네이밍 리팩토링
 * 코드와 현실의 패러타임 차이가 있지만 그래도 객체지향적으로 네이밍을 리팩토링했으면 함.
 * 예를 들어 TryCount?
 */
public class CarRacing {
    private final InputView inputView;
    private final OutputView outputView;

    public CarRacing(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void start() {
        Cars cars = createCars(inputView.readCarNames(), new CarAccelerator());
        TryCount tryCount = createTryCount(inputView.readTryAmount());

        printMoveResult(tryCount, cars);
        printWinners(cars);
    }

    private void printWinners(Cars cars) {
        outputView.printWinners(getWinners(cars));
    }

    private void printMoveResult(TryCount tryCount, Cars cars) {
        outputView.printMoveResultMessage();
        tryMove(tryCount, cars);
    }

    /**
     * TODO: Cars 생성자 매개변수 변경 (O)
     * carNames가 아니라 List<Car>를 입력하도록 Car 컬렉션을 먼저 생성하고
     * 해당 컬렉션을 통해 Cars 객체 생성
     * 이유는 Cars 객체 상단의 TODO를 참조
     */
    public Cars createCars(String carNames, CarAccelerator accelerator) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName, accelerator));
        }

        return new Cars(cars, new CarAccelerator());
    }

    public TryCount createTryCount(int amount) {
        return new TryCount(amount);
    }

    public void tryMove(TryCount tryCount, Cars cars) {
        for (int i = 0; i < tryCount.getAmount(); i++) {
            cars.tryMove();
            outputView.printCarsPosition(cars.getCars());
        }
    }

    public List<String> getWinners(Cars cars) {
        int maxPosition = cars.getCarsMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
