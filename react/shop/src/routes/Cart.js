import { Table } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { changeName, changeCount, changeAge } from "./../store.js";
function Cart() {
  let a = useSelector((state) => state);
  let dispatch = useDispatch();
  console.log(a.shoppingbag);
  console.log(a.user);
  // console.log(a["shoppingbag"]);
  return (
    <div>
      <button
        onClick={() => {
          dispatch(changeAge());
        }}
      >
        나이플러스
      </button>
      <div>{a.user.name}</div>
      <div>{a.user.age}</div>

      <Table>
        <thead>
          <tr>
            <th>#</th>
            <th>상품명</th>
            <th>수량</th>
            <th>변경하기</th>
          </tr>
        </thead>
        <tbody>
          {a.shoppingbag.map((e, i) => (
            <tr key={i}>
              <td>{e.id}</td>
              <td>{e.name}</td>
              <td>{e.count}</td>
              <td>{i + 1}</td>
              <td>
                <button
                  onClick={() => {
                    console.log();
                    dispatch(changeCount(e.id));
                  }}
                >
                  +
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}
export default Cart;
