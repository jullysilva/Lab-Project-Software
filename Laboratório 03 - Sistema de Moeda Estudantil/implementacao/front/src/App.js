import { Grid } from "@mui/material";
import { Component, useEffect } from "react";
import criarCarros from "./services/Carros";
import Home from "./components/Home";
import ListPedido from "./components/ListPedidos";
function App() {
  return (
    <div className="container">
      <Home />
      <ListPedido />
    </div>
  );
}

export default App;
