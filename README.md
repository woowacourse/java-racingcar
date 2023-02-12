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
- [X] @ParameterizedTest 사용
  - [X] CarTest에 적용
  - [X] ValidationTest 적용
- [X] RacingGame 게임 결과 우승자 산출 로직 수정

## 변경 사항 2

- [X] Cars 일급 컬렉션 도입
- [X] 유효성 검증 로직을 각 객체에서 직접 수행하도록 수정
  - [X] Car 클래스 유효성 검증 추가
  - [X] Cars 클래스 유효성 검증 추가
  - [X] GameTime 유효성 검증 추가
- [X] 에러 메시지 상수도 객체가 가지도록!
- [X] 승자 객체 추가

# STEP2

- [X] Winners 객체에 역할 부여
- [X] 전략 패턴을 통한 테스트
- [X] Cars가 문자열을 받아 생성될 수 있게 수정

