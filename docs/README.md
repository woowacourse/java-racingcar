# java-racingcar

## 개발 기능 목록

## Domain

### Name

-[x] 문자열을 통해 이름을 생성한다

- [x] Name 이 공백이면 `IllegalArgumentException` 을 발생한다.

- [x] Name 이 5글자 이상이면 `IllegalArgumentException` 을 발생한다.

### NameCatalog

-[x] 이름이 중복이면 'IllegalArgumentException' 을 발생한다. 

### Car

-[x] 이름을 통해 자동차를 생성한다.

-[x] 들어온 숫자가 일정 숫자 이상일 경우 위치를 전진한다.

### RaceCount

-[x] RaceCount 가 숫자가 아니면 `IllegalArgumentException` 을 발생한다.

-[x] RaceCount 가 음수면 `IllegalArgumentException` 을 발생한다.

### RaceProgress

-[x] 자동차들을 통해 경기 진행 결과를 생성한다

### RaceResult

-[x] 자동차들 위치를 통해 우승 자동차들을 결정한다

## Util

### NumberGenerator

-[x] 0부터 입력한 숫자 중 랜덤한 숫자를 생성한다

### Splitter

-[x] 문자열을 쉼표를 구분자로 분리한다
