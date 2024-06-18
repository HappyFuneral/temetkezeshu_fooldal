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
    const [regions,setRegions] = useState([])
    const [regionCode,setRegionCode] = useState([])


    useEffect(()=>{
        getOffices()
        getRegionCode()
        getCodes()
        getRegions()
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
    const getRegions = () => {
        setLoading(true)
        axiosClient.get("/offices/regions")
            .then(({data}) => {
                setLoading(false)
                setRegions(data)
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
    const getRegionCode = () => {
        setLoading(true)
        axiosClient.get("/offices/regionsAndCodes")
            .then(({data}) => {
                setLoading(false)
                setRegionCode(data)
            }).catch(() =>{
            setLoading(false)
        })
    }



  return (
    <OfficeContext.Provider value={{ offices,codes,regionCode,regions }}>
      {children}
    </OfficeContext.Provider>
  );
};

export default OfficeProvider;

