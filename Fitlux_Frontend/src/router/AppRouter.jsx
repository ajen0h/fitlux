import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LandingPage from '@/components/LandingPage';
import { _404Page } from '@/components/404Page';
import { Login } from '@/components/Login';
import { About } from '@/components/About';
import App from '@/App';

const AppRouter = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<App/>} />
        <Route exact path="/inicio" element={<LandingPage/>} />
        <Route exact path="/about" element={<About/>} />
        <Route exact path="/404" element={<_404Page/>} />
        <Route exact path="/login" element={<Login/>} />
      </Routes>
    </Router>
  );
};

export default AppRouter;

