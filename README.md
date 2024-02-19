# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## Git commit 메세지

- 접두어로 `docs`, `test`, `feat`, `fix`, `refactor`, `chore` 사용
- example `feat: 사용자 입력 후 도메인 사용`

## 기능 요구사항

### 입출력

- [X] 사용자로부터 자동차 이름을 입력받는다.
    - [X] 자동차 이름은 쉼표로 구분한다.
    - [X] 자동차 이름의 앞뒤 빈칸을 제거한다.
    - [X] 이름 중복은 허용하지 않는다.
    - [X] 빈 입력을 허용하지 않는다.
- [X] 사용자로부터 시도할 횟수를 입력받는다.
    - [X] 시도할 횟수가 자연수인지 검증한다.
- [X] 시도 횟수를 자연수로 변환한다.
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [X] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- [X] 게임 완료 후 가장 많이 전진한 자동차를 최종 우승자로 출력한다.
    - [X] 우승자는 한 명 이상일 수도 있으면, 컴마(',')로 구분하여 모두 출력한다.
- [X] 게임 라운드마다 모든 자동차의 전진 진행 상황을 출력한다.

### 게임 진행

- [X] 랜덤 값이 0과 9 사이로 제한한다.
- [X] 랜덤값이 4 이상일 경우, 전진한다.
- [X] 랜덤값이 3 이하일 경우, 멈춘다.
- [X] 시도 횟수만큼 게임 라운드를 진행한다.
- [X] 구분된 자동차 이름은 5자 이하만 가능하다.
- [X] 최종 우숭자를 반환한다.

## 프로그래밍 진행상황

- UI를 제외한 모든 로직에 단위 테스트를 구현한다.
- 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
- else 예약어를 사용하지 않는다.
- 한 메서드의 길이가 15 라인을 넘어가지 않도록 구현한다.
- 함수가 한 가지의 일을 하도록 구현한다.

## 피드백 수정사항 (step 1)

- [X] Car 도메인의 View 로직을 분리한다.
- [X] `cars`에 List 자료형을 `unmodifiableList`로 변경한다.
- [X] 변경이 안될 매개변수에 final 키워드를 붙인다.
- [X] IntStream 내에 불필요 관호 제거한다.
- [X] Winner 테스트의 불필요 코드 제거한다.
- [X] `Car`가 `Random`에 직접적으로 의존하지 않도록 수정한다.
- [X] `getBiggestCars`에 좀 더 적절한 이름으로 수정한다.
- [X] 도메인 단위 테스트를 추가적으로 진행한다.
- [X] 거리를 나타내는 용어를 통일한다.
- [X] 랜덤에 대한 테스트를 추가한다.
- [X] 확장성을 고려해 `forward` 증가량을 상수화한다.

## 리펙터링 요구사항

- [X] UI 관련한 객체를 `view` 패키지에 구현한다.
- [X] MVC 패턴으로 리팩터링 후의 main 메소드 예시는 다음과 같을 수 있도록 한다.
    - [X] TryCount를 분리된 클래스로 관리한다.

```java  
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

- [X] 불필요한 상수화 제거한다.
- [X] `Vehicles`의 클래스명을 `Cars`로 변경한다.

## 피드백 수정사항 (step 2)

- [X] 각각의 클래스에서 인스턴스 변수, 메소드, 생성자 등의 순서에 일관된 순서를 적용한다.
    - [X] [오라클의 문서](https://www.oracle.com/java/technologies/javase/codeconventions-fileorganization.html)를 참고한다.
- [X] Winner 클래스명도 복수형을 명시한다.
- [X] 인스턴스로 생성하지 않아도 된다는 의미를 부여하기 위해 private 기본 생성자를 생성한다.
- [X] Command 상수들은 변경의 여지가 없는 값들이니 불변으로 변경한다.
- [X] `RandomUtil`의 주석을 삭제한다.
- [X] 실제로 `Vehicles.from`에서 예외 상황을 고려해, `Game.from`만을 테스트할 수 있게 리팩토링한다.
- [X] 사용자의 입력을 파싱하는 것은 도메인 로직이라고 보기 어려우므로 `view` 레이어에 위임한다.
- [X] 테스트 DisplayName에 의미가 제대로 담기게 수정한다.
- [X] Stream 관련 체이닝 메소드를 사용할 때 줄바꿈을 적용한다.
- [X] 익명 클래스보단 명시적으로 `CarMoveStrategy`를 구현한 구체 클래스를 작성한다.
- [X] `getWinners()`로 메서드명 수정한다.
- [X] `doesNotThrowAnyException`을 사용하기보다 실제로 예측 가능한 게임을 만들어서 각 객체의 값들을 확인한다.
- [X] `랜덤값이 4보다 작으면 움직이지 않는 것`을 테스트할 수 있도록 설계를 변경한다.
- [X] `getter`을 사용해 값을 가져와서 비교하는 것보다 `Car`이 지금 위치에 있는지 물어보는 별도 메소드를 구현한다.
- [X] `carMoveStrategy` 변수명으로 변경한다.
- [X] `record` 클래스를 활용하면 조금 더 값 객체스럽게 사용할 수 있게 한다.
- [X] `@FunctionalInterface`를 사용하여 익명 함수 대신 람다식으로 줄여서 사용할 수 있게 한다.
- [X] `RandomNumber`의 네이밍을 `class RandomNumberGenerator implements NumberGenerator`로 변경한다.