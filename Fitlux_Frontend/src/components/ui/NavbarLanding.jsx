import { MenuIcon } from "lucide-react";
import { Link } from "react-router-dom";
export const NavbarLanding = () => {
  return (
    <>
      <nav className="fixed top-0 z-10 w-full">
        <div className="max-w-7xl p-10 flex justify-between items-center m-[0_auto]">
          <img src="/logo-fitlux.png" className="w-12"/>
          <ul className="md:flex flex-row justify-center items-center gap-5 hidden">
            <Link to='/'>Inicio</Link>
            <Link to='/about'>Sobre nosotros</Link>
            <Link to='/login'>Log in</Link>
          </ul>
          <MenuIcon className="md:hidden block size-8 cursor-pointer"/>
        </div>
      </nav>
    </>
  );
};
