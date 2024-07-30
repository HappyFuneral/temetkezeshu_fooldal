import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import AppContextProvider from "react"
import './index.css'
import {RouterProvider} from "react-router-dom";
import router from "./router.jsx";
import {ContextProvider} from "./contexts/ContextProvider.jsx";

import ProductProvider from "./contexts/ProductContext";
import SidebarProvider from "./contexts/SidebarContext";
import CartProvider from "./contexts/CartContext";


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
     <SidebarProvider>
      <CartProvider>
        <ProductProvider>
          <React.StrictMode>
              <ContextProvider>
              <RouterProvider router={router}/>
          </ContextProvider>
          </React.StrictMode>
        </ProductProvider>
      </CartProvider>
    </SidebarProvider>
  </React.StrictMode>,
)
