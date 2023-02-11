# 기능 구현 목록

## Domain

### Car

- [x] 자동차는 이름을 가진다.
  - [x] 자동차는 자신의 이름을 검증한다.
- [x] 자동차는 위치를 가진다.
- [x] 자동차는 움직일 수 있다.

### Cars

- [x] 경주할 자동차의 정보를 가진다.
- [x] 이름으로 자동차를 조회할 수 있다.
- [x] 우승자를 판단할 수 있다.
- [ ] 모든 자동차를 움직일 수 있다.

## View

### InputView

- [x] 자동차 이름을 입력 받을 수 있다.
- [x] 시도할 횟수를 입력 받을 수 있다.

### OutputView

- [x] 진행 상태를 출력할 수 있다.
- [x] 우승자를 출력할 수 있다.

## Controller

### RacingCarController

- [x] 게임의 전체적인 진행을 관리한다.

## Utils

### NumberValidator

- [x] 시도할 횟수가 숫자인지 검증한다.

### NumberGenerator

- [x] 임의의 정수 생성을 담당하는 인터페이스이다.

### RandomNumberGenerator

- [x] 0 ~ 9 사이의 임의의 정수를 생성한다.

### StringParser

- [x] 쉼표로 구분하여 자동차 이름들을 반환한다.

## Dto

### CarDto

- [x] 출력에 필요한 자동차의 정보들을 담을 수 있다.