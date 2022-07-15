# Collision

# 충돌이 나는 이유

꿰어져 있는 구슬이 다르기 때문

허브는 파 빨

로컬은 파 노

**pull은 가져오고 합쳐시키는 역할이다.**

### 세부이유

---

그때 합치는 과정이 내가 수정한 부분과 github에 올려진 내용의 순서들이 다르기 때문에 합치지 못한다 그래서 충돌이 발생

merging conflict

했을 때

원하는 모양으로 만들어서(집안싸움 해결) 후(커밋)  마지막으로 push를 해야한다. 

해결하는 순서

git push origin master을 했는데 어? 안되네?를 확인!

# git pull origin master 머징시켜보자!

---

 0. Git push origin master가 안되는지를 확인하고 난 후

원하는 내용으로 바꾼 후(어느 것이 맞는지 지워서 맞추자)

master|MERGING부분이 나오고 나서

1. 수정
2.  저장
3. git add .
4. git commit -m “메세지 내용”

(집안싸움해결)

---

git push origin master(해결) 구슬이 잘 꿰어졌으니 이제 해결된다!(GITHUB에 올려짐)