# java-racingcar
자동차 경주 게임 미션 저장소



## TDD - 문자열 덧셈 계산기

### 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 입력받는다.
  - 또는, 커스텀 구분자를 가지는 문자열을 입력받는다.
- 입력받은 문자열을 구분자를 통해 분리한다.
- 분리한 값을 정수로 변환하여, 모두 더한다.
- 더한 값을 출력한다.

### 구현단위

- 덧셈 테스트 코드 구현
- 빈 값이나 null값이 들어오는 경우에 대한 테스트 코드 구현
- 숫자 1개만 들어오는 경우에 대한 테스트 코드 구현
- 숫자 여러개가 들어오는 경우에 대한 테스트 코드 구현
- 숫자가 음수인 경우에 대한 테스트 코드 구현
- 숫자 이외의 값이 들어오는 경우에 대한 테스트 코드 구현
- 커스텀 구분자를 사용했을 경우에 대한 테스트 코드 구현

### 예외처리

- RuntimeException : 숫자 이외의 값이 들어가거나, 음수가 전달될 경우 발생



## 자동차 경주 게임

### 요구사항

- 임의의 개수의 자동차 이름을 입력한다.
  - 각 자동차의 이름은 쉼표로 구분된다.
  - 각 자동차의 이름은 5글자 이하만 가능하다.
- 이동할 횟수를 입력한다.
  - 이동할 횟수는 정수값만 입력이 가능하다.
- 자동차는 랜덤으로 전진하거나 그 자리에 머무른다.
  - 0부터 9 사이의 난수를 생성하여, 그 값이 4 이상이면 전진한다.
- 자동차 경주가 완료된 후, 누가 우승했는지 출력한다.
  - 우승자는 1명 이상이다.

### 구현단위

**[TDD]**

**Input**

- 이름 1개 입력 시 가능여부 검증
  - 빈 값이 들어오는 경우도 검증됨
- 이름 여러개 입력 시 분리 기능 검증
- 이름 여러개 입력 시 이름 길이 검증
- 횟수 입력 시 타입 에러 검증
- 횟수 입력 시 음수 입력 검증

**RacingGame**

- 자동차의 이동 기능 테스트
- 랜덤값 생성 테스트
- 우승자 확인 테스트
- 레이싱게임 실행 결과 테스트

**Output**

- 자동차 이동 시 출력되는 로그값 생성 테스트



**[UI 로직]**

**View**

- InputView 구현
- OutputView 구현



### 예외처리

- IllegalArgumentException : 이름의 길이가 1~5글자 사이가 아니거나, 횟수가 양수인 Integer값이 아닐 때 예외 발생

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)