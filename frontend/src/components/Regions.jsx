
import Office from "./Office.jsx";
import React, {useEffect, useRef, useState} from "react";
import axiosClient from "../axios-client.js";
import {useParams} from "react-router-dom";

import maplibregl from "maplibre-gl";
import 'maplibre-gl/dist/maplibre-gl.css';
import {Carousel} from "flowbite-react";
import {Button, Typography} from "@material-tailwind/react";


export const RegionMap = () => {
    const {code}= useParams()
    const [offices,setOffices] = useState([])


    useEffect(() => {
        getOffices()



    }, [ offices]);



    const  getOffices  =  async () => {
        await axiosClient.get("/offices/getbycode/"+code)
            .then(({data}) => {
                setOffices(data)

            }).catch((err) => {
                console.log(err)
            })
    }

    return (
        <div className=" w-full">
            <Carousel className="h-screen rounded-none">

                {offices.map((office) => {
                    return (
                        <Office office={office} key={office.id}/>
                    );
                })}
            </Carousel>
        </div>

    );
}
