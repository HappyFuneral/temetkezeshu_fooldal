
import Office from "./Office.jsx";
import React, {useEffect, useRef, useState} from "react";
import axiosClient from "../axios-client.js";
import {useParams} from "react-router-dom";

import {Carousel} from "flowbite-react";
import MapComponent from "./CodeMap.jsx";


export const RegionMap = () => {
    const {code}= useParams()
    const [region,setRegion] = useState([])
    const [offices,setOffices] = useState([])
    const [selectedLocation, setSelectedLocation] = useState({
        lat: 47.497746750606524,
        lng:  19.056156586745704
    });

    useEffect(() => {
        getOffices()
        getRegions()

    }, [offices]);



    const getRegions = async () =>{
        await axiosClient.get("/offices/getRegionByCode/"+code)
            .then(({data}) => {
                setRegion(data)

            }).catch((err) => {
                console.log(err)
            })


    }

    const  getOffices  =  async () => {
        await axiosClient.get("/offices/getbycode/"+code)
            .then(({data}) => {
                setOffices(data)

            }).catch((err) => {
                console.log(err)
            })
    }

    return (
        <div>
            <div className="w-full bg-gray-700">
                <div className="w-1/2 text-white">
                    <p> Térkép {">"} {region.region} </p>
                </div>
            </div>
            <div className="grid lg:grid-cols-2 lg:gap-2 grid-cols-1">

                <div className="overflow-y-scroll overflow-visible h-screen w-full antialiased">
                    {offices.map((office) => {
                        return (
                            <Office office={office} key={office.id}/>
                        );
                    })}
                </div>
                <MapComponent selectedLocation={selectedLocation} offices={offices}/>
            </div>
        </div>


    );
}
