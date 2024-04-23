import { ButtonLanding } from "./ui/ButtonLanding";

const LandingPage = () => {
  return (
    <>
      <div className="h-screen flex flex-col justify-center items-center">
      <section className="md:text-9xl text-7xl font-bold font-serif titulo">Fitlux</section>
        <footer className="md:text-2xl text-xs mb-8">
          El gimnasio que ha llegado para revolucionar el mundo del deporte
        </footer>

        <ButtonLanding text="Comienza ahora"/>
      </div>
  </>
  );
};

export default LandingPage;
