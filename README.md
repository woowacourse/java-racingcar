
# java-racingcar

자동차 경주 미션 저장소

## 기능 요구사항 
- 주어진 횟수동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - 자동차가 입력되지 않을 경우 예외 처리 후 다시 입력 받는다.
- 각 자동차에 이름을 입력받는다.
    - 이름은 1자 이상 5자 이하만 가능하다.
    - 이름은 중복을 허용한다.
- 횟수를 입력한다.
  - 음수 제외한 정수는 입력이 가능하다.
- 각 자동차는 정해진 횟수를 반복하는 동안 전진한다.
  - 전진하는 조건은 0에서 9 사이의 random 값을 구한 후 random 값이 4 이상일 경우 전진, 3 이하의 값이면 멈춘다.
- 경주 게임을 완료한 후 누가 우승했는지 알려준다.
  - 한명 이상이 가능하다
  - 모든 자동차의 전진 횟수가 0일 경우 공동 우승으로 출력한다.

## 기능 구현사항
- Car
  - 필드: 차 이름, 차 위치
  - 자동차 이동 함수
  - getter
- CarName
  - 필드: 이름
  - getter
- CarLocation
  - 필드: 위치
  - 이동 함수
  - getter
- Cars
  - 필드: 자동차 리스트
  - getter
- Race
  - 필드: Cars
  - 경기 진행
  - 우승자 선정
  - 입력 받기
  - 출력하기

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
