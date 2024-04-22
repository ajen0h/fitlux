import { Link } from "react-router-dom";

export const NavbarLanding = () => {
  return (
    <nav className="sticky top-10 z-10 bg-transparent">
      <div className="max-w-7xl mx-auto px-4">
        <div className="flex items-center justify-between h-0">
          <span className="text-2xl font-semibold">Logo</span>
          <div className="flex space-x-4">
          <Link to="/inicio">Inicio</Link>
          <Link to="/about">Sobre nosotros</Link>
          <Link to="/404">Log in</Link>
          </div>
        </div>
      </div>
    </nav>
  );
};
