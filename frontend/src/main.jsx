import React from 'react'
import ReactDOM from 'react-dom/client'

import './index.css'
import { RouterProvider} from "react-router-dom";
import router from "./router.jsx";

import OfficeProvider from "./contexts/OfficeContext.jsx";


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
        <OfficeProvider>
          <React.StrictMode>
              <RouterProvider router={router}/>
          </React.StrictMode>
        </OfficeProvider>
  </React.StrictMode>,
)
