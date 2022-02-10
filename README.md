# java-racingcar

 1. Model
    - Car
      - [x] 이름을 가져오는 기능 (getter)
      - [x] 위치 가져오는 기능 (getter)
      - [x] 전진하는 기능 (setter)
      - [x] 특정 위치와 비교하는 기능
    - CarList
      - [x] 자동차 중 가장 먼 위치 구하는 기능
 2. View
    - Input
      - [X] 자동차 이름
      - [x] 움직일 횟수
    - Output
      - [X] 각 턴마다 자동차의 이름, 위치
      - [x] 최종 우승한 자동차들의 이름
 3. Controller
    - CarListController
       - [x] 난수 생성
       - [x] CarList 움직이는 기능
    - OutputViewController
       - [x] OutputView에 HashMap 형태로 CarList 넘겨주기 
       - [x] 최종 우승한 자동차 명단 String[] 형태로 넘겨주기
    - 게임 전반적 실행 기능
 4. Utility
    - Const
      - [x] 전진 조건(0,4,9)
      - [x] 에러 메세지
      - [x] 이름 조건(5)
      - [x] OutputView 안내 메세지
      - [x] 위치 안내(-)
      - [x] 구분자(, :)
    - Error
      - [x] 차 이름이 5글자 이상일 경우
      - [x] 주어진 횟수가 1보다 작은 경우
      - [x] 입력이 공백 / null
      - [x] 차의 개수가 0개인 경우
      - [x] 차 이름에 특수기호가 들어간 경우
      - [x] 차 이름에 중복이 있는 경우
      - [x] 횟수가 숫자형 문자열이 아닌 경우
 5. Test Code
    - [x] 이름 입력 예외 테스트
    - [x] 횟수 입력 예외 테스트
    - [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
