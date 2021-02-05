# java-racingcar
자동차 경주 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구 사항 정의
### Car
- [x] 자동차는 위치와 이름 정보를 가져야 한다.
- [x] 전진할 조건을 만족할 경우 전진한다.
- [x] 전진시, 현 위치를 1만큼 올린다.
- [ ] 자동차의 이름은 1글자 이상 5글자 이하이어야 한다.

### GasStation
- [x] 자동차에 전진할 수 있는 연료를 넣어 준다.

### RacingManager
- [ ] 참여자와 턴 수를 입력 받는다.
- [x] 턴 수만큼 게임을 진행한다.
    - [x] 자동차에 주유소를 이용하여 연료를 주입한다.
- [x] 결과(RacingResult)를 반환한다.

### RacingResult
- [x] 매 턴마다의 진행 상황
- [x] 우승자

### InputView
- [ ] 자동차의 이름
- [ ] 시도할 횟수
  - [ ] 1 이상의 자연수이어야 한다.

### OutputView
- [ ] 특정 메시지를 출력한다.
- [ ] 실행 결과를 출력한다.
- [ ] 우승자를 출력한다.