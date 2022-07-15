# git정리/ git hub정리

# 7/14일 수업정리
## 깃과 깃허브는?

- 개발자의 협업을 위한 도구!
    - 근거
        - 프로그래밍은 글쓰기!
    

# 역할

1.분산 버전 관리 프로그램

버전 관리:컴퓨터 소프트웨어 버전 관리

분산은 각자 컴퓨터에 저장되어있다.

# 인터넷이 끊겨도 사용가능한 git

# 인터넷이 끊기면 안되는 git hub

# git에 익숙해지자

# git

사람과 컴퓨터를 연결하는

- cli=command line interface

- gui=graphic user interface 두가지가 있다.→유저가 이용하는 접점

# 명령어 정리

1. ls
    
    현재 폴더의 파일 리스트-list segment
    
    옵션:
    
    -a: 숨긴 파일을 볼 수 있다.
    

2 . touch:파일을 생성 할 수 있다.

3 . mkdir:폴더를 생성할 수 있다,

4 . cd(change directory)

1. rm
    
    rm a.txt
    
    rm -r a
    
    rm *.txt
    
    rm -rf *
    
    커밋메세지는 시간으로 작성하지 않는다.
    
    왜 사진을 찍는지에 대한 설명이 있어야 한다.
    
    커밋을 한건 고유한 시리얼 넘버(해시값)를 가진다.
    
    그 시리얼 번호를 알면 과거로 갈 수 있다.
    

리눅스 명령어는 모든 곳에서 가능하지만

깃 명령어는 .git이 있는 곳에서만 가능하다.

## 생성

---

touch -파일을 생성

mkdir-폴더를 생성

## 이동

---

cd

- ~(홈 디렉토리)로 간다.

## 커밋메시지

---

왜 커밋을 했는지 적는 것

ex) git commit -m “README.md added”

## 깃인지 아닌지

---

ls -a했을 때 .git이 있으면 깃의 관리를 받고 있다.

## stage에 올린 것을 다시 내리는 법

---

git rm —cached “파일명”

## 브랜치 바꾸는 방법

---

git checkout master or 해시값 or 브랜치 명

커밋

## 간편 명령어

git push -u origin master 에 익숙해지지 말자

이 명령어 다음에는 git push만 쓰면 뒤에는 생략할 수 있다.

하지만 이후에는 브런치가 달라지기 때문에 헷갈릴 수 있다.

이유: master가 아닌 다른 브런치 이름으로 대체 되기 때문에

## 주의

.git이 있는 폴더의 명은 바꿔도 됨.

## git과 github 브릿지가 있는지 확인

---

git remote -v

## 클론 하는 법

---

클론은 git init과 힘이 비슷

클론의 두가지 효과

- .git을 추가시킴.(init의 역할)
- 브릿지와 해당 레포지토리의 커밋 히스토리(내역)를 함께 가져옴.

## 클론과 init의 뉘앙스 차이

1. git init
    
    내가 밟고 있는 폴더를 스페셜하게 만들어줘(git으로 관리되는 폴더로 만듦)
    
    최초에 한번만 하는 
    
2. git clone
    
    내가 밟고 있는 위치에 복제된 폴더를 가져와줘(이건 홈 디렉토리에서 사용가능) log값도 가져옴.
    

## 브릿지의 유무에 따른 명령어 차이점

브릿지가 되어있는상태에서

clone이나 init 을 한 후에는 push pull

브릿지가 되어있지 않은 상태에서

clone이나 init하면 됨

최초로 프로젝트를 시작한사람은

origin/master

origin/head 허브가 현재 어디에 있는지

origin뭐시기 하면 (구글링 해보자) 깃허브가 알고 있는 내용

pull을 하면 로컬 git이 알게 되고(로컬과 github이 인터넷 연결됨)

push을 하게 되면 github가 알게 된다.

## 불편한점

로컬은 인터넷이 끊겨도 된다.(git 명령어)

수정 저장 add commit push하게 되면 다시 스테이지에서 나오게 된다.

같은 브랜치라 할지라도 .git에 담긴 히스토리가 다를 수 있기 때문에

최신의 내용을 가지지 못한 상태라면 pull을 해서 github의 최신내용을 받아오는 행동을 하고

github에게 나 로컬 변경했어요! 하면서 변경된 내용을 알리고 싶으면 push을 쓰면 된다.

# 자격 깃허브 관련

1. git config
    1. git config --global user.email "이메일주소"
    이메일 등록
    2. git config --global [user.name](http://user.name/) "깃허브이름"
    아이디 등록
    3. git config --global --list
    등록된 내역 확인
    4. 자격증명 지우기
        `git config --global --unset user.name`
        `git config --global --unset user.email`