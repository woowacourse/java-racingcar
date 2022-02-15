# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능구현 목록

### 사용자 입력

- [x] 사용자로부터 자동차 이름을 입력 받는다.
  - [x] 자동차 이름은 5자 이하만 가능하다.
  - [x] 중복된 이름은 불가능하다.
  - [x] 자동차 이름은 쉼표로 구분한다.
  - [x] 자동차 이름은 한 글자 이상이어야 한다.
  - [x] 최소 자동차 수는 두 개 이상이다.
- [x] 횟수를 입력받는다.
  - [x] 횟수는 1 이상 50 이하의 정수여야 한다.

### 자동차

- [x] 자동차 전진 기능
  - [x] 0에서 9사이의 난수를 생성해서 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- [x] 우승자 선정
  - [x] position이 가장 높은 자동차가 우승자가 된다.
  - [x] 우승자는 여러 명일 수 있다.



## 피드백 내용

1. 유효성 검사가 콘솔 뷰에 밀접하게 연관되어 있다. 이 경우 여러 뷰가 추가될 경우(예를 들어 웹) 검증 로직이 여러 곳에 분산될 수 있다. 검증 로직을 어떻게 응집시킬 수 있을까?
   1. 도메인에서 유효성 검사를 담당하도록 구현한다
2. `Car` 객체의 `attemptToMove` 메서드
   1. 객체 지향은 객체 간의 상호작용이 핵심이다. attemptToMove라는 네이밍은 Car 객체에 메시지를 전달하는 것처럼 보이지 않는다. 
   2. Car에게 움직이라는 명령을 보내는 객체는 실제로 Car가 움직일지 안 움직일지에 대해서는 신경쓰지 않아도 된다.
3. 난수를 생성할 책임이 `RacingGame`에 위치하는 것이 적절한가?
4. 구체적인 예외 클래스를 정의하면 좋을 것 같다