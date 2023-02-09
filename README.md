# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
  
## 기능 요구사항
- 입력(뷰)
    - [X] 사용자: 자동차 이름 입력
      - [ ] 검증: 입력 최대 길이
    - [X] 사용자: 라운드 횟수
      - [X] 검증: 자연수가 입력되었는지
      - [ ] 검증: 자연수의 최대 크기

- 출력(뷰)
    - [X] 컨트롤 메세지
        - [X] 자동차 이름 및 시도 횟수 입력
        - [X] 실행 결과 메시지
    - [ ] 경주 실행 과정
    - [ ] 경주 실행 결과

- 도메인
    - [X] 자동차
      - [X] 검증: 이름이 5자 이하인지
      - [X] 전진 여부 판단하여 상태 업데이트
      - [X] toString

- 저장소
    - [X] 자동차 진행 저장소
      - [X] 검증: 중복된 이름을 가진 차가 있는지
      - [X] 모든 차의 위치를 문자열로 변환하는 기능

- 서비스
    - [ ] 모든 차의 진행 상황을 갱신
        - [ ] 랜덤 숫자

- 컨트롤러
    - [ ] 컨트롤 메세지 출력 및 자동차, 횟수 입력 받기 
    - [ ] 시도횟수만큼 서비스 로직 수행
