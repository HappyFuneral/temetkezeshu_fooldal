import React, { createContext, useState, useEffect } from "react";
import axiosClient from "../axios-client";

export const ProductContext = createContext();

const ProductProvider = ({ children }) => {
  // products state
  const [products,setProducts] = useState([])
  const [loading,setLoading] = useState(false)

  useEffect(()=>{
      getProducts()
  },[])

  const getProducts = () => {
      setLoading(true)
      axiosClient.get("/products")
          .then(({data}) => {
              setLoading(false)
              setProducts(data)
          }).catch(({err}) =>{
          setLoading(false)
      })
  }
  return (
    <ProductContext.Provider value={{ products }}>
      {children}
    </ProductContext.Provider>
  );
};

export default ProductProvider;

