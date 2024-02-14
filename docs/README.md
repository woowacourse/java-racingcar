# java-racingcar

## 개발 기능 목록

### Car

#### 이름과 함께 자동차를 생성한다
#### 난수가 일정 숫자 이상일 경우 위치를 전진한다. 

### Name

#### Name 이 공백이면 `IllegalArgumentException` 을 발생한다.

#### Name 이 5글자 이상이면 `IllegalArgumentException` 을 발생한다.

### RaceCount

#### RaceCount 가 숫자가 아니면 `IllegalArgumentException` 을 발생한다.

#### RaceCount 가 음수면 `IllegalArgumentException` 을 발생한다.

### RaceResult

#### 자동차들을 통해 경기 결과를 생성한다

#### 우승한 자동차들을 알려준다

### InputView

#### 중복되지 않은 Name 을 입력 받는다

##### 중복되는 Name 이 있으면 `IllegalArgumentException` 을 발생한다.