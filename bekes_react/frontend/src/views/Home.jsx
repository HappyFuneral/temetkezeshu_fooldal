import { useEffect, useState } from "react";
import axiosClient from "../axios-client.js";

export default function Home(){
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
                setProducts(products)
            }).catch(({err}) =>{
            setLoading(false)
        })
    }
    return (
        <div>
            Home
        </div>
    );
}