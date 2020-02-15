# java-racingcar
자동차 경주 게임 미션 저장소

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구사항
- **모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외**
- **자바 코드 컨벤션을 지키면서 프로그래밍 한다.**
- **indent(인덴트, 들여쓰기) depth를 3을 넘지 않도록 구현한다. 2까지만 허용한다.**
- **else 예약어를 쓰지 않는다.**
- **함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.**


## 아키텍처
[Model]
- Car
- CarLineUp ... <Car>
- Position
- RandomNumber
- TrialTime
- WinnerCalculator
  - isMaxPosition
  - isWinner
  
[View]
- InputView
- OutputView

[Controller]
- RacingGame ...(main)


## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
