import "./App.css";
import { useState } from "react";
import data from "./data.js";
import { Container, Nav, Navbar } from "react-bootstrap";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
import Detail from "./routes/detail";
import Main from "./routes/main";

function App() {
  let [shoes, shoesSet] = useState(data);
  let navigate = useNavigate();
  return (
    <div className="App">
      <Navbar className="navbar" bg="white">
        <Container>
          <Navbar.Brand
            onClick={() => {
              navigate("/");
            }}
            href="#home"
          >
            LookShop
          </Navbar.Brand>
          <Nav className="me-auto nav-flex">
            <Nav.Link href="#features">Ranking</Nav.Link>
            <Nav.Link href="#Products">Products</Nav.Link>
            <Nav.Link href="#Sale">Sale</Nav.Link>
            <Nav.Link href="#StyleRoom">StyleRoom</Nav.Link>
            <Nav.Link href="#Store">Store</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <Routes>
        <Route
          path="/"
          element={
            <Main shoesSet={shoesSet} navigate={navigate} shoes={shoes} />
          }
        />
        <Route path="/detail/:id" element={<Detail shoes={shoes} />} />
        <Route
          path="/event"
          element={
            <div>
              <h4>오늘의 이벤트</h4>
              <Outlet />
            </div>
          }
        >
          <Route
            path="one"
            element={<div>첫 주문시 양배추즙 서비스</div>}
          ></Route>
          <Route path="two" element={<div>생일기념 쿠폰받기</div>}></Route>
        </Route>
        <Route path="*" element={<div>없는 페이지에요</div>}></Route>
      </Routes>
    </div>
  );
}

export default App;
