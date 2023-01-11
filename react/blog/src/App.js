/* eslint-disable */
import "./App.css";
import { useState } from "react";
import React from "react";

function App() {
  let [글제목, 글제목Set] = useState([
    "남자 코트 추천",
    "여자 코트 추천",
    "강남 우동 추천",
  ]);

  let [like, likeSet] = useState(
    글제목.map(function () {
      return 0;
    })
  );
  let [titleNum, titleNumSet] = useState(0);

  let [modal, setModal] = useState(false);
  let [입력값, 입력값Set] = useState("");

  return (
    <div className="App">
      <div className="black-nav">
        <h4>ReactBlog</h4>
      </div>

      <button
        onClick={() => {
          let copy = [...글제목];
          if (copy[0] === "남자 코트 추천") {
            copy[0] = "여자 코트 추천";
          } else {
            copy[0] = "남자 코트 추천";
          }
          글제목Set(copy);
        }}
      >
        글제목변경
      </button>
      <button
        onClick={() => {
          let copy2 = [...글제목].sort();
          글제목Set(copy2);
        }}
      >
        가나다순 변경
      </button>

      {글제목.map(function (e, i) {
        return (
          <div className="list" key={i}>
            <h4
              onClick={() => {
                setModal(!modal);
                titleNumSet(i);
              }}
            >
              {글제목[i]}
              <span
                onClick={(e) => {
                  e.stopPropagation();
                  let copy = [...like];
                  copy[i]++;
                  likeSet(copy);
                }}
              >
                👍
              </span>
              {like[i]}
            </h4>
            <p>2월 17일 발행</p>
            <button
              onClick={() => {
                let del_tmp = [...글제목];
                del_tmp.splice(글제목[i], 1);
                글제목Set(del_tmp);
              }}
            >
              삭제
            </button>
          </div>
        );
      })}

      <input
        onChange={(e) => {
          입력값Set(e.target.value);
        }}
      />

      <button
        onClick={() => {
          let temp = [...글제목];
          temp.unshift(입력값);
          console.log(temp);
          글제목Set(temp);
        }}
      >
        발행
      </button>
      <Modal2></Modal2>
      {
        //여기는 jsx쓰는 부분이라서 if문쓰면 안됨
        //  조건식 ? 참일때 실행할 코드: 거짓일 때 실행할 코드
        modal == true ? (
          <Modal
            titleNum={titleNum}
            글제목Set={글제목Set}
            color={"skyblue"}
            글제목={글제목}
          />
        ) : null
        //null은 비어있는 값으로 사용
      }
    </div>
  );
}

function Modal(props) {
  return (
    <div className="modal" style={{ background: props.color }}>
      <h4>{props.글제목[props.titleNum]}</h4>
      <p>날짜</p>
      <p>상세내용</p>
      <button
        onClick={() => {
          props.글제목Set([
            "여자 코트 추천",
            "여자 코트 추천",
            "강남 우동 추천",
          ]);
        }}
      >
        글수정
      </button>
    </div>
  );
}

class Modal2 extends React.Component {
  constructor() {
    super();
    this.state = {
      name: "kim",
      age: 20,
    };
  }
  render() {
    return (
      <div>
        안녕{this.state.age}
        <button
          onClick={() => {
            this.setState({ age: 21 });
          }}
        >
          버튼
        </button>
      </div>
    );
  }
}

export default App;
