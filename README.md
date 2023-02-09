# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 입력 기능

- [X] 자동차 이름 입력 
  - [X] 쉼표로 구분
  - [X] 다섯 글자 이하인지 검증
  - [X] 미입력 예외 처리
- [X] 시도 횟수 입력
  - [X] 미입력 예외 처리
  - [X] 정수인지 검증
  - [X] 양수인지 검증

## 출력 기능

- [X] 입력 요구 메시지 출력
  - [X] 자동차 이름
  - [X] 시도 횟수
- [X] 실행 결과 출력
- [X] 최종 결과 출력

## 비즈니스 로직

- [X] 자동차 이동
  - [X] 0~3일 경우 정지, 4~9일 때 전진
- [X] 우승자 확인
  - [X] 복수 우승 가능

## 변경 사항

- [X] Car.move의 파라미터 이름 수정
- [X] RacingGame 객체의 역할 분리
- [X] 유효성 검증 방법 검토
- [X] 승자 출력 로직의 가시성 검토
- [ ] @ParameterizedTest 사용
  - [X] CarTest에 적용
- [X] RacingGame 게임 결과 우승자 산출 로직 수정