# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 구현 기능 목록

### Main

* Application
    * `RacingController`를 통해 자동차 경주 프로그램을 시작한다.

### Domain

* Car
    * 자동차 경주에서 자동차 역할을 담당한다.
    * 자동차 이름을 상태로 갖는다.
    * 이동한 거리를 상태로 갖는다.
    * 앞으로 전진한다.
    * 자동차 이름에 대한 정보를 제공한다.
    * 현재 이동 거리에 대한 정보를 제공한다.
* RacingCars
    * `Car` 도메인에 대한 일급 컬렉션이다.
    * 자동차 경주 라운드를 진행한다.
    * 매 라운드 별 경주 결과 정보를 제공한다.
    * 최종 우승자 정보를 제공한다.
* Racing
    * 자동차 경주에서 경주 역할을 담당한다.
    * 0부터 9사이의 난수를 발생한다.
    * 자동차의 전진 여부에 대한 정보를 제공한다.
* ExceptionMessages
    * 자동차 경주의 다양한 예외 메시지를 관리하는 열거형이다.

### View

* InputView
    * 사용자로부터 자동차 경주 라운드 횟수와 자동차 이름을 입력받는 UI 역할을 담당한다.
* OutputView
    * 자동차 경주의 매 라운드 별 결과를 출력하고 최종 우승자 정보를 출력하는 UI 역할을 담당한다.

### Controller

* RacingController
    * 자동차 경주의 전체적인 흐름을 제어한다.
    * `InputView`로부터 사용자의 입력을 받는다.
    * 자동차 경주의 핵심 로직들을 `Domain`을 통해 수행한다.
    * `OutputView`를 통해 자동차 경주의 결과를 출력한다.