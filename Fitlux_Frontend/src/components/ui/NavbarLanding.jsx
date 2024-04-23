import { Link } from "react-router-dom";

export const NavbarLanding = () => {
  return (
    <nav className="fixed w-full p-8 top-0 z-10 bg-transparent ">
      <div className="max-w-7xl mx-auto px-4">
        <div className="flex items-center justify-between h-0">
          <span className="text-2xl font-semibold"><img className="w-36" src="/logo-fitlux.png"></img></span>
          <div className="flex space-x-6">
          <Link to="/">Inicio</Link>
          <Link to="/about">Sobre nosotros</Link>
          <Link to="/login">Log in</Link>
          </div>
        </div>
      </div>
    </nav>
  );
};
