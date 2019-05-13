# string-calculator
문자열 계산기 + 테스트 코드

# java-racingcar
자동차 경주 게임 미션 저장소

목표
1. getter, setter를 사용하지 않음
2. 유효한 테스트 코드 작성
3. 뎁스 2 준수 ( 가능한 1 유지 )

문제점
1. 입력검증 테스트 코드는 private라 작성이 불가능함
2. 복수의 우승자 판별 코드 뎁스 2 

###기능 구현 목록
- [x] 이름 입력
    - [x] 입력 예외 처리
        - [x] 콤마 연속입력
        - [x] 공백 이름
    - [x] 객체 내 예외 처리
        - [x] 중복된 이름
- [x] 자동차 생성 
    - [x] 레이스 객체에 자동차 배열 저장
- [x] 횟수 입력
    - [x] 레이스 객체에 횟수 저장
    - [x] 예외 처리
        - [x] 정수 입력 여부
    - [x] 객체내 예외 처리
        - [x] 자연수 여부
- [x] 레이싱 진행
    - [x] 난수 발생
    - [x] 자동차 전진 기능
    - [x] 횟수 만큼 반복
    - [x] 자동차 상태 출력
    - [x] 경기 진행 상황 출력
    - [x] 우승자 판별
- [x] 우승자 출력
- [x] 리팩토링
*******
###테스트 구현 목록
- [x] 이름 입력
    - [x] 입력 예외 처리
        - [x] 콤마 연속입력
        - [x] 공백 이름
    - [x] 객체 내 예외 처리
        - [x] 중복된 이름
- [x] 횟수 입력
    - [x] 객체내 예외 처리
        - [x] 자연수 여부
- [x] 레이싱 진행
    - [x] 난수 발생
    - [x] 우승자 찾기
*******
###리팩토링 목록
- [x] Car 내부 equals(), hashcode() 사용
- [x] 테스트 가능 코드 추가 및 분리
- [x] Class 내부 코드 순서 (public -> priavate 관련된 것 끼리 엮어서)
- [x] 값이 변하지 않는 지역 변수 인자는 final로 변경 확인
- [x] 자료구조나 자료형이 들어간 변수명 변경
- [x] 도메인에 sout을 뷰로 분리
- [x] 컬렉션 api 사용가능한 부분 대체

*******
###코드 리뷰 후 수정 목록
- [x] 계산기 
    - [x] 상수구현 enum화
    - [x] operator, calculator 분리
- [ ] 자동차
    - [ ] 뷰와 도메인 operator 내에서 분리
        - [x] toString 아웃풋뷰로 분리
        - [x] view와 domain 맞닿아 있는 부분 제거
        - [x] view 조작 컨트롤러에서 Main으로 분리
    - [ ] 초기화 static factory method 사용
    - [x] 자동차 이름입력 재귀 실행 수정
    - [x] Race클래스 내 cars 생성 위치 수정
    - [ ] RandomNumberGenerator 인터페이스 분리
    - [ ] 핵심 로직 테스트
 