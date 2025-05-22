import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from './components/NavBar';
import PaginaInicial from './pages/Inicial';
import PaginaCadastro from './pages/Cadastro';
import PaginaListaJogadores from './pages/Lista';
import './App.css';

function App() {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route path="/" element={<PaginaInicial />} />
        <Route path="/cadastrar" element={<PaginaCadastro />} />
        <Route path="/listar-jogadores" element={<PaginaListaJogadores />} />
        <Route path="*" element={<div className="container">404 - Página não encontrada</div>} />
      </Routes>
    </Router>
  );
}

export default App;