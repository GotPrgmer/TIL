import { configureStore, createSlice } from "@reduxjs/toolkit";

let user = createSlice({
  //state하나를 slice라고함
  name: "user",
  initialState: { name: "kim", age: 11 },
  reducers: {
    changeAge(state) {
      state.age += 1;
    },
  },
});

let stock = createSlice({
  //state하나를 slice라고함
  name: "stock",
  initialState: [10, 11, 12],
});
let shoppingbag = createSlice({
  name: "shoppingbag",
  initialState: [
    { id: 0, name: "White and Black", count: 2 },
    { id: 2, name: "Grey Yordan", count: 1 },
  ],
  reducers: {
    changeCount(state, action) {
      let ans = state.find((e) => {
        return e.id == action.payload;
      });
      ans.count++;
    },
    addProduct(state, action) {
      state.push(action.payload);
    },
  },
});
export let { changeName, changeAge } = user.actions;
export let { changeCount, addProduct } = shoppingbag.actions;

export default configureStore({
  reducer: {
    user: user.reducer,
    stock: stock.reducer,
    shoppingbag: shoppingbag.reducer,
  },
});
