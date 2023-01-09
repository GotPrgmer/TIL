import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Nav } from "react-bootstrap";

function Detail(props) {
  let [alert, alertSet] = useState(true);
  let [alert2, alert2Set] = useState(false);
  let [text, textSet] = useState(null);
  let [tab, tabSet] = useState(0);
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
      <Nav variant="tabs" defaultActiveKey="link-1">
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              tabSet(0);
            }}
            eventKey="link-1"
          >
            버튼0
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              tabSet(1);
            }}
            eventKey="link-2"
          >
            버튼 1
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              tabSet(2);
            }}
            eventKey="link-3"
          >
            버튼 2
          </Nav.Link>
        </Nav.Item>
      </Nav>
      <TabContent tab={tab} />
    </div>
  );
}

function TabContent({ tab }) {
  console.log(tab);
  //방법1
  // if (props.tab == 0) {
  //   return <div>내용0</div>;
  // } else if (props.tab == 1) {
  //   return <div>내용1</div>;
  // } else {
  //   return <div>내용2</div>;
  // }
  let [fade, fadeSet] = useState("");
  useEffect(() => {
    let a = setTimeout(() => {
      fadeSet("end");
    }, 100);

    return () => {
      clearTimeout(a);
      fadeSet("");
    };
  }, [tab]);
  //방법2
  return (
    <div className={`start ${fade}`}>
      {[<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tab]}
    </div>
  );
}
export default Detail;
