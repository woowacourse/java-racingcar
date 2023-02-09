# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 목록
### UI 기능
- [x] 경주할 자동차의 이름을 한줄로 입력받아 컴마 단위로 파싱하는 기능
- [x] 시도할 횟수를 입력받는 기능
    - 자연수가 아니면 IllegalArgumentException을 발생시킨다.
- [x] 실행 결과를 출력하는 기능
- [x] 최종 결과를 출력하는 기능

### 도메인 기능
- [x] 시도할 횟수를 전달받아 그 횟수만큼 아래 로직을 작동시키는 기능
- [x] 자동차의 정보를 전달받아 이름과 위치를 뷰에 넘겨주는 기능
- [x] 최종 결과를 넘겨받아 뷰에 넘겨주는 기능
- Game
    - [x] 전달받은 이름들로 자동차 여러 대를 생성하는 기능
      - 이름의 개수가 1개인 경우, IllegalArgumentException을 발생시킨다.
      - 중복된 이름이 존재하는 경우 IllegalArgumentException을 발생시킨다. (테스트 추가 필요)
    - [x] 전달받은 범위의 랜덤 숫자를 생성하는 기능
    - [x] 랜덤값에 따라 모든 자동차에게 움직이도록 하는 기능
        - 랜덤값이 0~9가 아니면 IllegalArgumentException을 발생시킨다.
        - 4 이상일 경우 전진하고, 3 이하면 멈춘다.
    - [x] 마지막 시도 후 자동차의 전진한 회수를 비교해 우승자를 판단하는 기능
- Car
    - [x] 이름을 전달받아 자동차를 생성하는 기능
        - 5자 초과면 IllegalArgumentException을 발생시킨다.
        - 빈 문자열이면 IllegalArgumentException을 발생시킨다. (테스트 추가 필요)
    - [x] 자동차를 전진하는 기능