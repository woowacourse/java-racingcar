# java-racingcar
자동차 경주 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 계산기 구현할 코드 목록

- [x] 쉼표 또는 기준으로 문자열 calculator.SplitTest
- [x] 문자열 앞에 “//”와 “\n” 사이에 있는 기호 기준으로 문자열 calculator.SplitTest
- [x] 음수 또는 숫자 이외의 값에 대한 예외처리 (RuntimeException throw)

## 레이싱카 구현할 코드 목록

### Input
- 사용자의 입력값을 받는다.
    - [ ] 자동차 이름
    - [ ] 시도할 횟수

### Domain
- [ ] 자동차 이름을 쉼표(,) 기준으로 분리
- [ ] [예외처리] 자동차 이름은 5자 이하
- [ ] 0-9 사이의 랜덤값을 생성한다.
    - [ ] 생성값이 4이상인 경우만 전진한다.
- [ ] 움직인 거리를 비교하여 우승자를 선정한다.
    - [ ] 우승자는 2명 이상일 수 있다.

### Output
- 실행 결과 출력
    - [ ] 시도 횟수마다 출력
    - [ ] 자동차 이름과 움직인 거리 출력
- 우승자 출력
    - [ ] 우승한 자동차 이름을 출력한다.

