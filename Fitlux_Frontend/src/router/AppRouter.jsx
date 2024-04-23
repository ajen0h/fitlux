import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LandingPage from "@/components/LandingPage";
import { _404Page } from "@/components/404Page";
import { Login } from "@/components/Login";
import { About } from "@/components/About";
import { NavbarLanding } from "@/components/ui/NavbarLanding";

const AppRouter = () => {
  return (
    <>
      <Router>
        <NavbarLanding />
        <main className="h-full">
          <Routes>
            <Route exact path="/" element={<LandingPage />} />
            <Route exact path="/about" element={<About />} />
            <Route exact path="/login" element={<Login />} />
            <Route exact path="*" element={<_404Page />} />
          </Routes>
        </main>
      </Router>
    </>
  );
};

export default AppRouter;
