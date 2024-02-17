## 구현할 기능 목록

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

## 2단계 - 자동차 경주 리팩터링

### 리펙터링 요구사항

- [ ] 핵심 비지니스 로직을 가지는 객체를 domain 패키지에 구현한다.
    - [ ] domain 패키지의 객체는 view에 의존하지 않도록 구현한다.
        - [ ] CarController내에 InputView, OutputView를 때어낸다.
            - [ ] CarController의 생성자를 Cars와 TryCount로 받도록 수정한다.
                - [X] CarController에 NumericGenerator를 구성하도록 변경한다.
                - [X] Cars내 moveCars를 NumericGenerator를 받도록 변경한다.
        - [ ] Main인 Application.java 를 RacingMain.java 으로 변경한다.
            - [ ] Main 코드의 유명한 컨벤션이 있는지 여쭈어 보기
        

- [ ] UI 관련한 객체를 view 패키지에 구현한다.
    - [ ] view 패키지의 객체가 domain 패키지 객체에 의존 할 수 있도록 구현한다.

- [ ] 테스트 가능한 부분과 테스트하기 힘든 부분을 분리한다.
    - [ ] 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.

### 피드백 요구사항

- [ ] Java Naming Conventions을 만족하도록 네이밍을 관리한다.

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