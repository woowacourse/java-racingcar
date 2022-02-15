# java-racingcar
## 기능 요구사항 
- 자동차
  - [x] 이름, 위치 가짐 
    - [x] `예외처리`: 이름 5자 초과 or 빈 문자열 예외
  -  [x] 0~9 사이의 random 값을 받아 4 이상일 경우 전진, 3 이하이면 정지
- 자동차 경주 
  - [x] n 대의 자동차 생성
    - [x] 쉼표 기준 구분, 공백 제거
  - [x] 진행 횟수만큼 게임 진행
    - [x] random 값 생성
    - [x] n 대의 자동차 게임 진행
  - [x] 우승자 목록 생성
- 입출력
  - 입력
    - [x] 자동차 이름 입력
      - [x] `예외처리`: 자동차 이름 중복
    - [x] 진행 횟수 입력
      - [x] `예외처리`: 양수 아닌 입력 or 빈 문자열 입력
  - 출력
    - [x] 각 게임 결과 출력
    - [x] 최종 우승자 출력

## 객체 설계
### Model
- Car
  - 이름, 위치 가짐
  - 전진 기능
  - 이름 검증 기능 
- CarDto
  - 이름, 위치와 getter 만 존재
  - 각 계층간 data 전달
- CarRepository
  - Car Collection 상태 관리
  - 전달된 int List에 따라 전체 Car 전진
  - 우승자 반환
- RandNo
  - 0~9 정수 반환 

### Controller
- CarController
  - CarRepository 생성, 관리
  - 각 Car 게임 진행
  - Random 값 List 생성하여 CarRepository에 전달
- RacingController
  - InputView, ResultView 사이 데이터 전달
  - Car 이름 CarController에 전달
  - 진행 횟수 만큼 경주 진행

### View
- InputView
  - 자동차 이름 입력
  - 진행 횟수 입력
  - 입력 예외 검증 기능
- ResultView
  - 각 게임 결과 출력
  - 최종 우승자 출력