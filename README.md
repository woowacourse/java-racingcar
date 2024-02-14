# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 목록

### 입력

- [X] [출력] 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
- [X] [입력] ',' 단위로 나뉘어진 자동차 이름 리스트를 입력받음
  - [ ] [예외] 자동차 이름은 5자 이하
- [ ] [출력] 시도할 횟수는 몇회인가요?
- [ ] [입력] 시도할 횟수 입력받음

### 경주

- [ ] 주어진 횟수 만큼 자동차를 이동시킨다.
  - [ ] 0-9 사이 랜덤한 숫자를 생성한다.
  - [ ] 4 이상인 경우 전진한다.
  - [ ] 3 이하의 경우 전진하지 않는다.
  - [ ] 위를 매 자동차마다 시행한다.

### 출력

- [ ] [출력] 실행 결과
- [ ] 자동차 전진 현황을 출력한다.
  - [ ] 매 전진마다 시행한다.
  - [ ] [출력] 이름 + ' : ' + '-'*전진한 횟수
- [ ] 우승자를 출력한다.
  - [ ] [출력] 이름 + '가 최종 우승했습니다.'
  - [ ] 두 명 이상 우승한 경우 ', ' 로 구분한다.

### 예시

```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```