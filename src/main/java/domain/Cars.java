package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Cars 생성자 매개변수 변경
 * 생성자를 Testable하게 만들고, 한 가지 역할만을 하게 만들려면 필드에 초기화시킬 값을 매개변수로 받는 것이 좋다고 생각
 * 지금 생성자는 "입력받은 매개변수를 검증하고 필드값을 초기화"한다는 역할 외에도 입력받은 carNames를 Car 컬렉션으로 만들어주는 역할까지 가지고 있음
 * Car 컬렉션을 만드는 건 외부에서 처리할 역할이고 생성자는 값 검증 및 초기화 역할만 주어야한다고 생각
 * 그게 아니라면 팩토리 메서드를 만드는 것이 좋겠는데 필드값도 1개고 외부에서 처리할 수 있는 부분이라 불필요.
 *
 * 또한 Test 과정에서 Car내부의 값들을 외부에서 조정할 수 없어서 Car를 이동시킨 후 특정 포지션으로 제대로 이동했는 지
 * 검증하는 Test 작성이 불가능한데 생성자 매개변수로 Car 컬렉션을 받게한다면 이러한 문제또한 해결이 가능하여 Testable 한 코드가 작성될 수 있음
 */
public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        // 자동차 개수 검증
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException();
        }

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    public void tryMove() {
        for (Car car : cars) {
            car.tryMove(RandomNumberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarsMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        return maxPosition;
    }
}
