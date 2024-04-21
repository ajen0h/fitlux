export const NavbarLanding = () => {
  return (
    <nav className="sticky top-10 z-10 bg-transparent">
      <div className="max-w-7xl mx-auto px-4">
        <div className="flex items-center justify-between h-0">
          <span className="text-2xl font-semibold">Logo</span>
          <div className="flex space-x-4">
            <a href="#">Mi App</a>
            <a href="#">Sobre nosotros</a>
            <a href="#">Alquileres</a>
            <a href="#">Log in</a>
          </div>
        </div>
      </div>
    </nav>
  );
};
