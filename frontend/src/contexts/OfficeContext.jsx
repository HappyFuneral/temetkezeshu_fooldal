// eslint-disable-next-line no-unused-vars
import React, { createContext, useState, useEffect } from "react";
import axiosClient from "../axios-client";

export const OfficeContext = createContext();

// eslint-disable-next-line react/prop-types
const OfficeProvider = ({ children }) => {
  // products state
  const [offices,setOffices] = useState([])

    const [loading,setLoading] = useState(false)
    const [codes, setCodes] = useState([])

  useEffect(()=>{
      getOffices()
      getCodes()

  },[])

  const getOffices = () => {
      setLoading(true)
      axiosClient.get("/offices")
          .then(({data}) => {
              setLoading(false)
              setOffices(data)
          }).catch(() =>{
          setLoading(false)
      })
  }
  const getCodes = () => {
      setLoading(true)
      axiosClient.get("/offices/codes")
          .then(({data}) => {
              setLoading(false)
              setCodes(data)
          }).catch(() =>{
          setLoading(false)
      })
  }

  return (
    <OfficeContext.Provider value={{ offices,codes }}>
      {children}
    </OfficeContext.Provider>
  );
};

export default OfficeProvider;

