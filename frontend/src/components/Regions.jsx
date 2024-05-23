
import Office from "./Office.jsx";
import React, {useEffect, useRef, useState} from "react";
import axiosClient from "../axios-client.js";
import {useParams} from "react-router-dom";

import 'maplibre-gl/dist/maplibre-gl.css';
import {Carousel} from "flowbite-react";
import MapComponent from "./CodeMap.jsx";


export const RegionMap = () => {
    const {code}= useParams()
    const [offices,setOffices] = useState([])
    const [selectedLocation, setSelectedLocation] = useState({
        lat: 28.7041,
        lng: 77.1025,
    });

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
            <MapComponent selectedLocation={[selectedLocation]}/>
        </div>

    );
}
