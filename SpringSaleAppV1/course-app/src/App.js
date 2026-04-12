import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Foorter";
import Home from "./screens/Home/Home"
import User from "./screens/User/User"
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from "react-bootstrap";



const App = () => {
  return (
    <BrowserRouter>
      <Header />

      <Container>
        <Routes>
          <Route path="/" element={ <Home/>} />
          <Route path="/profile" element={ <User/>} />
        </Routes>
      </Container>


      <Footer />

    </BrowserRouter>
  );
};

export default App;