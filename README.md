# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 구현할 기능
- *는 요구사항에 명시된 필수 구현 기능

### 자동차 이름 입력
- [ ] 쉼표 기준으로 구분해서 받기 *
  - [x] 5자 이하 (초과일 경우 예외 처리 후 다시 입력) *
  - [ ] null, 공백일 경우 예외 처리 후 다시 입력
  - [x] 중복 이름일 경우 예외 처리 후 다시 입력

### 이동 횟수 입력
- [ ] 숫자가 아닌 입력은 예외 처리 후 다시 입력 *
- [ ] 0 이하의 값 입력은 예외 처리 후 다시 입력 *

### 랜덤 값 생성
- [x] 0 ~ 9 사이의 랜덤 숫자 생성 *
 
### 자동차 전진
- [x] 4 이상의 값이면 전진, 3 이하의 값이면 멈춤 *

### 전진 결과 출력
- [ ] 자동차 이름과 함께 전진 값 출력 *

### 우승자 판별
- [x] 우승자는 1명 이상일 수 있음 *
  - [x] 모든 차가 우승자가 될 수 있다

### 우승자 출력
- [ ] 우승자의 이름을 쉼표로 구분해서 멘트 출력 *
