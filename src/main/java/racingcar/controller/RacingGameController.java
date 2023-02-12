package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingGameController {

    public void run() {
        RacingCars cars = createCars();
        int tries = getTries();

        OutputView.printResultMessage();
        raceCars(cars, tries);
        showFinalResult(cars);
    }

    private void raceCars(RacingCars cars, int tries) {
        for (int i = 0; i < tries; i++) {
            cars.moveCars(new RandomNumberGenerator());
            OutputView.printRaceResult(cars.showRaceResult());
        }
    }

    private RacingCars createCars() {
        try {
            String input = InputView.inputCarNames();
            return new RacingCars(CarFactory.generate(input));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return createCars();
        }
    }

    /**
     * TODO : InputView에서 숫자아닌 값을 입력했을 경우, "숫자를 입력해주세요" 라는 에러 메시지를 전달하기 위해 아래와 같이 작성하였습니다
     * 하지만 예외처리를 controller에서 하드코딩으로 했다는 점과
     * TryCount라는 객체 또한 후에 시도횟수의 최소 입력값을 바꿀 수도 있기 떄문에 객체로 생성하였는데
     * 이러한 시도가 맞는지 의문이 듭니다.
     * 시도횟수(1이상), 차 이름(,구분자로 구분되고, n개 이상)의 유효성 검사를 inputView에서 해야하는지 도메인 객체에서 해야하는지 헷갈립니다.
     */
    private int getTries() {
        try {
            TryCount tries = new TryCount(InputView.inputTries());
            return tries.getTries();

        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getTries();
        }
    }

    /**
     * TODO : 최종 결과를 출력할 때, 차의 이름과 현재 차들의 위치를 다시 한번 출력하는데,
     * 이때  이미 생성된 DTO인스턴스(List<CarStatus>)를 저장하는 곳이 없어,
     * 또 다시 cars.showRaceResult()를 불러왔습니다.
     * 이러한 경우, 생성한 DTO를 다른 객체에 저장했다가(예를들면, List<CarStatus>를 저장하는 RaceResult 객체를 컨트롤러에서 생성)
     * 해당 dto가 필요할때 컨트롤러가 꺼내어 view에 넘겨도 DTO사용에 위배되지 않는지 궁금합니다.
     **/
    private void showFinalResult(RacingCars cars) {
        OutputView.printRaceResult(cars.showRaceResult());
        showWinners(cars);
    }

    private void showWinners(RacingCars cars) {
        List<String> winnersName = cars.pickWinnerCarsName();
        OutputView.printFinalResult(winnersName);
    }
}
