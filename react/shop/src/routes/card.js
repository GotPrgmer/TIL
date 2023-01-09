function Card(props) {
  return (
    <div className="col-md-4">
      <img
        onClick={() => {
          props.navigate(`/detail/${props.copy_shoes.id}`);
        }}
        src={`https://codingapple1.github.io/shop/shoes${
          props.copy_shoes.id + 1
        }.jpg`}
        width="80%"
      />

      <h4>{props.copy_shoes.title}</h4>
      <p>{props.copy_shoes.price}원</p>
    </div>
  );
}

export default Card;
