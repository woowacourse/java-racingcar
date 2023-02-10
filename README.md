# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구 사항 분석

- 자동차는 전진 혹은 멈출 수 있다.
- 자동차는 이름이 있다.
    - 자동차의 이름은 5자 이하이다.
    - 자동차의 이름은 공백이 불가하고 콤마로 구분한다.
    - 자동차는 n번 이동이 가능하다.
    - 자동차의 전진은 0~9 랜덤 값중 4이상일 경우이고, 그 외에는 멈춘다.
- 자동차 경주 게임의 라운드 한 번당 중간 결과를 출력해야한다.
- 자동차 경주 게임의 우승자는 한 명 이상일 수 있다.

## 기능 명세서

- ### 입력
    - 자동차 이름 입력
        - [x] 자동차를 한 대 이상 입력해야한다.
        - [x] 이름이 5자 이하인 경우 재시도한다.
        - [x] 자동차의 이름은 중복되면 안된다.
    - 자동차 이동 횟수 입력
        - [x] 시도할 회수는 0이상의 숫자만 입력해야한다.
    - 구체적인 입력에 대한 Validation
        - [x] 자동차를 한 대 이상 입력해야한다.
        - [x] 이름이 5자 이하인 경우 재시도한다.
        - [x] 자동차의 이름은 중복되면 안된다.
        - [x] 시도할 회수는 0이상의 숫자만 입력해야한다.

- ### 출력
    - [x] 실행 문구 출력
    - [x] 라운드마다의 자동차 별 이동 거리 출력
    - [x] 우승자 출력


- ### 메인 기능
    - Cars
        - [x] 전체 자동차가 경주하는 기능
          - 각각의 자동차에 대해 랜덤 값이 4이상이면 움직인 것으로 처리
        - [x] 라운드가 끝날 때마다 현재 자동차 경주의 상태를 나타내주는 기능
        - [x] 우승자를 구하는 기능

    - Car
        - [x] 이름과 움직인 거리를 반환해주는 기능
        - [x] 거리를 증가시켜주는 기능

