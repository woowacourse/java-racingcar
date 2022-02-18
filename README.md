# java-racingcar

자동차 경주 미션 저장소

## Participants
 - BE_바니
 - BE_앤지

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 구현 목록
1. 게임 시작 기능
2. 사용자 입력 받는 기능
   1. 자동차 이름 입력 받는 기능
      1. 자동차 이름은 쉼표(,)로 구분
      2. 각 자동차의 이름은 5자 이하만 가능
      3. 중복되지 않은 값 입력
      4. 공백 입력 시 예외 처리
         1. 아무런 값을 입력하지 않을 경우
         2. 자동차 이름 중 공백으로 이루어진 이름이 있을 경우
   2. 시도 횟수 입력 받는 기능
      1. 숫자가 아닌 값 입력 시 예외 처리
      2. 1보다 작은 값 입력 시 예외 처리
      3. 공백 입력 시 예외 처리
3. 각각의 자동차에 대해 전진 or 그대로 구현하는 기능
   1. 0~9 사이의 무작위 값 생성하는 기능
   2. 무작위 값이 4이상인 경우에만 전진하는 기능
4. 각각 회차의 실행 결과를 출력하는 기능
5. 우승자를 알려주는 기능
   1. 우승자가 여러명일 때 출력하는 기능
   2. 우승자가 한 명일 때 출력하는 기능




## Step2 리팩토링 목록

- MainController
- view
   - InputView
      - 사용자 입력 받는 View
   - OutputView
      - 자동차 경주 게임 결과 출력 View
- domain
   - Game
      - 생성자 생성 public Game(carNames, tryNo)
      - tryNo valid 유효성 검증
   - Car
      - CarName 유효성 검증
   - Cars
      - car name 중복 검사
      - winner 판별 로직
   - MoveCondition
     - Car이 이동가능한지 판별하는 인터페이스
- utils
   - ErrorCode
     - 에러코드 상수
   - GameMessage
     - 게임 메세지 상수

