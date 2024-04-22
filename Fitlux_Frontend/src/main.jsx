import React from 'react'
import ReactDOM from 'react-dom/client'
import './globals.css'
import AppRouter from './router/AppRouter.jsx';


ReactDOM.createRoot(document.getElementById('root')).render(  //núcleo de la aplicación donde se renderiza todo
  <React.StrictMode>
    <AppRouter />
  </React.StrictMode>,
)
