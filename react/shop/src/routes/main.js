import axios from "axios";
import Card from "./Card";
import { useState } from "react";

function Main(props) {
  let [hit, hitSet] = useState(0);

  return (
    <>
      <div className="main-bg"></div>
      <div className="container">
        <button
          onClick={() => {
            props.shoes.sort((a, b) => {
              if (0 < a.title.toLowerCase() - b.title.toLowerCase()) return 1;
              else if (0 === a.title.toLowerCase() - b.title.toLowerCase())
                return 0;
              else return -1;
            });
            let shoes = [...props.shoes];
            props.shoesSet(shoes);
          }}
          className="sortButton"
        >
          가나다 내림차순
        </button>
        <span className="스팬">이거 스팬태그</span>
        <div className="row">
          {props.shoes.map(function (e, i) {
            let copy_shoes = e;
            let num = i + 1;

            return (
              <Card
                navigate={props.navigate}
                copy_shoes={copy_shoes}
                num={num}
                i={i}
                key={i}
              />
            );
          })}
        </div>
        <button
          //axios로 상품 불러오면 상품 더보기 버튼 없애기
          onClick={(e) => {
            // hit == 1 ? console.log("asdf"):console.log('null');
            if (hit == 0) {
              axios
                .get("https://codingapple1.github.io/shop/data2.json")
                .then((response) => {
                  let shoes = [...props.shoes].concat(response.data);
                  props.shoesSet(shoes);
                  hitSet(hit + 1);
                })
                .catch((res) => {
                  console.log(res);
                });
            } else if (hit == 1) {
              axios
                .get("https://codingapple1.github.io/shop/data3.json")
                .then((response) => {
                  let shoes = [...props.shoes].concat(response.data);
                  props.shoesSet(shoes);
                  hitSet(hit + 1);
                })
                .catch((res) => {
                  console.log(res);
                });
            } else if (hit == 2) {
              e.target.style.display = "none";
            } else {
              return null;
            }
          }}
        >
          상품 더보기
        </button>
      </div>
    </>
  );
}

export default Main;
