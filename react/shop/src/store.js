import { configureStore, createSlice } from "@reduxjs/toolkit";

let user = createSlice({
  //state하나를 slice라고함
  name: "user",
  initialState: "kim",
});

let stock = createSlice({
  //state하나를 slice라고함
  name: "stock",
  initialState: [10, 11, 12],
});

export default configureStore({
  reducer: {
    user: user.reducer,
    stock: stock.reducer,
  },
});
