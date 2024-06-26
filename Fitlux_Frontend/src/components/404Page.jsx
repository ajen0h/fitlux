import { Link } from "react-router-dom"

export const _404Page = () => {
    return (
        <main className="grid min-h-full place-items-center px-6 py-24 sm:py-32 lg:px-8">
  <div className="text-center">
    <p className="text-base font-semibold text-slate-100">404</p>
    <h1 className="mt-4 text-3xl font-bold tracking-tight text-red- sm:text-5xl">Página no encontrada</h1>
    <p className="mt-6 text-base leading-7 text-gray-400">Lo siento, no se ha podido encontrar la página que intentabas buscar.</p>
    <div className="mt-10 flex items-center justify-center gap-x-6">
      <Link to={"/inicio"} className="rounded-md bg-indigo-600 px-3.5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Volver al inicio</Link>
    </div>
  </div>
</main>
    )
}