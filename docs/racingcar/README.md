# 1단계 - 자동차 경주

## 요구사항 기능목록

**자동차 이름 입력받기**

- 자동차 이름을 쉼표(,)를 기준으로 구분한다.
- [예외] 자동차 이름이 5글자를 넘는 경우
  - `자동차의 이름은 5글자 이하여야 합니다.` 메세지를 출력한다.
- [예외] 자동차 이름이 빈 문자열인 경우
  - `자동차의 이름은 1글자 이상이어야 합니다.` 메세지를 출력한다.
- [예외] 자동차 수가 2대 미만인 경우
    - `자동차는 2대 이상이어야 합니다.` 메세지를 출력한다.
- 검증된 입력으로 자동차 정보를 저장한다.

<br>

**시도 횟수 입력받기**

- [예외] 입력값이 숫자가 아닌 경우
    - `시도 횟수는 숫자여야 합니다.` 메세지를 출력한다.
- [예외] 시도 횟수가 1 보다 작을 경우
    - `시도 횟수는 1회 이상이어야 합니다.` 메세지를 출력한다.

<br>

**게임 진행**

- 시도 횟수만큼 자동차들을 전진/정지 시킨다.
- 매 시도마다 0~9 사이 난수를 발생시켜 4 보다 작은 경우 자동차를 정지시키고, 4 이상인 경우 전진시킨다.
- 매 시도마다 자동차 이름, 현재 위치를 출력한다.
  - `실행결과` 메세지와 함게 출력한다.
  - `이름 : ---` 형식으로 출력한다. (`-` 하나 당 자동차가 한번 전진한 것을 의미한다. )

<br>

**게임 종료**

- 가장 전진을 많이 한 우승자를 계산한다.
- 우승자를 출력한다.
    - 우승자가 여러명인 경우 쉼표(,)로 구분한다.
    - `pobi, jun이 최종 우승했습니다.` 형식으로 출력한다.

<br>


## Class 구조
- domain
  - AttemptNumber
  - Car
  - Cars
  - RacingResult
  - Round
- service
  - dto
    - CarDto
  - RacingGame
- controller
  - RacingController
- view
  - InputView
  - OutputView
- util
  - MovingNumberPolicy
  - MovingNumberPolicyByRandom


### AttemptNumber
- 시도 횟수 VO

### Car
- 전진/정지한다.

### Cars
- Car List 를 저장하고 비즈니스 로직을 처리하며 관리한다.
- 우승한 Car 들을 계산한다.

### RacingResult
- 자동차 경주 결과를 Round 별로 저장한다.

### Round
- 게임 라운드 VO

### CarDto
- Car 객체의 name, position 필드를 갖는 DTO 이다.

### RacingGame
- 시도 횟수만큼 자동차들 경주를 시킨다.
- 게임별 RacingResult 를 관리한다.

### RacingController
- 애플리케이션 흐름을 제어한다.

### InputView
- 사용자에게 자동차 이름들을 입력 받는다.
- 사용자에게 시도 횟수를 입력받는다.

### OutputView
- 자동차 경주 결과를 출력한다.

### MovingNumberPolicy
- 자동차 이동 숫자 정책의 `interface` 이다.

### MovingNumberPolicyByRandom
- Random 숫자를 자동차 이동 숫자로 사용하는 구현 클래스이다.
