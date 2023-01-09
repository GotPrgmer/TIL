import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function Detail(props) {
  let [alert, alertSet] = useState(true);
  let [alert2, alert2Set] = useState(false);
  let [text, textSet] = useState(null);
  const isEmpty = (e) => {
    if (e === undefined || e === null || e == "") {
      return true;
    } else {
      return false;
    }
  };

  useEffect(() => {
    setTimeout(() => {
      alertSet(false);
    }, 2000);

    if (text !== null || isEmpty(text) === false) {
      if (isNaN(text) === false && text.indexOf(" ") < 0) {
        console.log("숫자");
        alert2Set(false); //숫자
      } else {
        console.log("문자");
        alert2Set(true);
      }
    } else {
      return;
    }
    return () => {
      //기존타이머는 제거해주세요
      console.log("인풋값 검사");
      //기존 데이터요청은 제거해주세요
    };
  }, [text]);

  const { id } = useParams();
  console.log(props.shoes);
  return (
    <div className="container">
      {alert == true ? (
        <div className="alert alert-warning">2초이내 구매시 할인</div>
      ) : null}
      <div className="row">
        <div className="col-md-6">
          <img
            src={`https://codingapple1.github.io/shop/shoes${
              parseInt(id) + 1
            }.jpg`}
            width="100%"
          />
        </div>
        <div className="col-md-6">
          {alert2 == true ? (
            <div className="alert alert-warning">문자말고 숫자로 바꿔라</div>
          ) : null}
          <input
            onChange={(e) => {
              textSet(e.target.value);
            }}
          />
          <h4 className="pt-5">{props.shoes.find((e) => e.id == id).title}</h4>
          <p>{props.shoes.find((e) => e.id == id).title}</p>
          <p>{`${props.shoes.find((e) => e.id == id).price}원`}</p>
          <button className="btn btn-danger">주문하기</button>
        </div>
      </div>
    </div>
  );
}

export default Detail;
