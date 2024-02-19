# 1단계 - 자동차 경주 구현

### 구현할 기능 목록

- [X] 경주할 자동차 이름 입력받기: InputView.inputRacingCars
- [X] 자동차 이름 목록 콤마를 기준으로 분리: Cars.parseWithComma
- [X] 올바른 형식의 문자열인지 확인: Cars.validate
- [X] 자동차 이름이 유효한지 확인: Car.validate
- [X] 자동차 이름이 5자 이하인지 확인: Car.nameUnderFive
- [X] 시도할 회수 입력받기: InputView.inputTryCount
- [X] 시도 회수가 유효한지 확인: TryCount.validate
- [X] 시도 회수가 숫자인지 확인: TryCount.isNumeric
- [X] 시도 회수가 0 이상인지 확인: TryCount.isOverZero
- [X] 숫자 생성: Generator.generate
- [X] 우승자가 누구인지 계산: Cars.calculateWinner
- [X] 실행 결과 메시지 출력: OutputView.printResult
- [X] 차들의 최종 상태 출력: OutputView.printCarStatus
- [X] 최종 우승자 출력: OutputView.printWinner
- [X] 시도 횟수 1씩 감소: TryCount.consume
- [X] 시도 횟수가 0보다 큰지 확인: TryCount.untilZero
- [X] 차 위치 1 증가: Car.move
- [X] 랜덤넘버에 따른 차들의 위치 증가: Cars.moveCars

## 1차 리뷰 반영 사항

### 명확한 의미를 담은 네이밍 사용

Java Naming Conventions가이드를 참고하여 메서드 이름 수정

#### model

- [X] Car의 nameUnderFive 네임 변경
- [X] Cars의 isValidInput 내 regex
- [X] Cars의 moveCars 내 매직 넘버(4)
- [X] Trycount untilZero 네임 변경

#### view

- [X] BufferedReader br 메서드 변경 (constant)

### 메서드 분리

- [X] model/Trycount validateInput 메서드 분리
    - [X] 입력 값이 숫자가 아닌 경우 
    - [X] 입력 값이 음수인 경우

### 테스트 코드와 프로덕션 코드 분리

- [X] model/Trycount getValue 접근제어자 변경
    - [X] test에 racingcar.model 패키지 생성
    - [X] CarsTest, CarTest 패키지 이동

---

# 2단계 - 자동차 경주 리팩터링

## 리펙터링 요구사항

- [X] 핵심 비지니스 로직을 가지는 객체를 domain 패키지에 구현한다.
    - [X] CarController내에 InputView, OutputView를 분리한다.
        - [X] InputView를 분리한다.
        - [X] CarController의 생성자를 Cars와 TryCount로 받도록 수정한다.
            - [X] CarController에 NumericGenerator를 구성하도록 변경한다.
            - [X] Cars내 moveCars를 NumericGenerator를 받도록 변경한다.
        - [X] CarController 내에서 게임 결과를 반환하도록 변경
            - [X] 우승자들을 관리하는 객체 생성
            - [X] 자동차들의 상태값을 받는 객체 생성

- [X] UI 관련한 객체를 view 패키지에 구현한다.
    - [X] view 패키지의 객체가 domain 패키지 객체에 의존 가능하도록 구현한다.
        - [X] inputView가 domain 패키지 객체에 의존하도록 구현
            - [X] Cars를 반환
            - [X] TryCount를 반환

- [X] 테스트 가능한 부분과 테스트하기 힘든 부분을 분리한다.
    - [X] 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.

### 리뷰어 요구사항

- [X] validatedInput 네이밍 변경
- [X] 클래스 내에 메서드들이 상수 값 공유하도록 맴버 변수로 변경. 


#### 코드 예시
``` java
import view.InputView;
import view.ResultView;
import domain.RacingGame;

public class RacingMain {
    public static void main(final String... args) {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);
        racingGame.race();
        
        ResultView.printWinners(racingGame.getWinners());
    }
}
```

## 2단계 리뷰 반영 사항

- [X] CarController를 RacingGame으로 변경
