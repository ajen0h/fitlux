import { ButtonLanding } from "./ui/ButtonLanding";
import { NavbarLanding } from "./ui/NavbarLanding";

const LandingPage = () => {
  return (
    <>
    <NavbarLanding></NavbarLanding>
      <div className="h-screen flex flex-col justify-center items-center">
      <section className="text-9xl font-bold font-serif titulo">Fitlux</section>
        <footer className="text-2xl mb-8">
          El gimnasio que ha llegado para revolucionar el mundo del deporte
        </footer>

        <ButtonLanding>Comienza ahora</ButtonLanding>
      </div>
  </>
  );
};

export default LandingPage;
