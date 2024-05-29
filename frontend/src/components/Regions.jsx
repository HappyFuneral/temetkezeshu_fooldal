
import Office from "./Office.jsx";
import React, {useEffect, useRef, useState} from "react";
import axiosClient from "../axios-client.js";
import {useParams} from "react-router-dom";

import {Carousel} from "flowbite-react";
import MapComponent from "./CodeMap.jsx";


export const RegionMap = () => {
    const {code}= useParams()
    const [offices,setOffices] = useState([])
    const [selectedLocation, setSelectedLocation] = useState({
        lat: 47.497746750606524,
        lng:  19.056156586745704
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
        <div className="grid lg:grid-cols-2 lg:gap-2 grid-cols-1">
            <div className="overflow-y-scroll overflow-visible h-screen w-full antialiased">
                {offices.map((office) => {
                    return (
                        <Office  office={office} key={office.id}/>
                    );
                })}
            </div>
            <MapComponent  selectedLocation={selectedLocation} offices={offices}/>

        </div>

    );
}
