
import React, {useEffect, useRef, useState} from "react";
import axiosClient from "../axios-client.js";
import {Link, useParams} from "react-router-dom";

import {GoogleMap, InfoWindow, MarkerF, useLoadScript} from "@react-google-maps/api";
import mapicon from "../img/mapicon.png";
import bg from "../img/bg.jpg";
import {Avatar, Carousel} from "flowbite-react";


export const RegionMap = () => {
    const {code}= useParams()
    const [region,setRegion] = useState([])
    const [offices,setOffices] = useState([])
    const [selectedLocation, setSelectedLocation] = useState({

        lat: 47.497746750606524,
        lng:  19.056156586745704
    });
    const [zoom,setZoom] = useState(13)



    const getRegions = async () =>{

        await axiosClient.get("/offices/getbycode/"+code)
            .then(({data}) => {
                setOffices(data)
            }).catch((err) => {
                console.log(err)
            })
        await axiosClient.get("/offices/getRegionByCode/"+code)
            .then(({data}) => {
                setRegion(data)

            }).catch((err) => {
                console.log(err)
            })

        setLoaded(true)
    }


    useEffect(() => {

        if(!loaded) {
            document.body.style.zoom = "normal";
            document.body.scrollTop = 0;
            getRegions()
        }

    }, [offices]);




    const [loaded, setLoaded] = useState(false)
    const { isLoaded, loadError } = useLoadScript({
        googleMapsApiKey: "AIzaSyDWtnOf9mfiuz8Y8FZU-UxeJCCVOe8KLFU",
    });
    const mapRef = React.useRef();
    const onMapLoad = React.useCallback((map) => {
        mapRef.current = map;
    }, []);
    const [selectedMarker, setSelectedMarker] = useState()

    if (loadError) return "Error";
    if (!isLoaded) return "Maps";

    return (
        <div>
            <div className="w-full bg-black ">
                <div className="text-white container mx-auto p-5">
                    <p>
                        <Link className="" to="/">Főoldal</Link>
                        <svg xmlns="http://www.w3.org/2000/svg" style={{display: "unset"}} width="24" height="24"
                             fill="white">
                            <path
                                d="M7.293 4.707 14.586 12l-7.293 7.293 1.414 1.414L17.414 12 8.707 3.293 7.293 4.707z"/>
                        </svg>
                        <Link to="/">Térkép</Link>
                        <svg xmlns="http://www.w3.org/2000/svg" style={{display: "unset"}} width="24" height="24"
                             fill="white">
                            <path
                                d="M7.293 4.707 14.586 12l-7.293 7.293 1.414 1.414L17.414 12 8.707 3.293 7.293 4.707z"/>
                        </svg>
                        <Link to={"/map/regions/" + region.code}>{region.region}</Link>
                    </p>
                </div>
            </div>
            <div className="grid lg:grid-cols-4 lg:gap-2 grid-cols-1">
                <div className="overflow-y-scroll overflow-visible w-full antialiased h-flexible col">
                    {offices.map((office) => {
                        const { id, location, name, website,contacts } = office;

                        return (
                            <div key={id}>
                                <div
                                    className="mb-2 shadow-lg mx-auto max-w-full group transform duration-500 hover:-translate-y-1"

                                >

                                    <h1 className="text-2xl text-center font-semibold text-gray-700 bg-white mt-4 mb-5">
                                        {name}
                                    </h1>
                                    <div className="p-3">
                                        <div
                                            className="lg:text-xl text-center text-md cursor-pointer text-gray-700 mb-2 leading-relaxed"
                                            onMouseEnter={() => {

                                                setSelectedLocation({
                                                    lat: office.latitude,
                                                    lng: office.longitude
                                                })
                                                setZoom(17)
                                                setSelectedMarker(office)
                                            }
                                            }
                                            onClick={() => {

                                                setSelectedLocation({
                                                    lat: office.latitude,
                                                    lng: office.longitude
                                                })
                                                setZoom(17)
                                                setSelectedMarker(office)
                                            }
                                            }
                                        >
                                            <div className="">

                                                <div>{location}</div>
                                                <Avatar className="animate-bounce" alt="mapicon"
                                                        img={mapicon}/>
                                            </div>


                                        </div>


                                    </div>
                                    <div className="grid grid-cols-1 w-full justify-items-center lg:flex p-3">


                                        <div
                                            className="grid grid-cols-1 mx-auto"
                                        >

                                            {contacts.map((c) => {

                                                switch (c.slug) {
                                                    case "phone":
                                                        return (
                                                            <div
                                                                className="grid grid-cols-2 lg:text-md text-sm text-gray-700 leading-relaxed">

                                                                <div className="text-right">
                                                                    {c.type} ▶
                                                                </div>
                                                                <div className="pl-2 text-left">
                                                                    <a href={"tel:" + c.contact}>
                                                                        {c.contact}
                                                                    </a>
                                                                </div>

                                                            </div>
                                                        )
                                                    case "email":
                                                        return (
                                                            <div
                                                                className="grid grid-cols-2 lg:text-md text-sm text-gray-700 leading-relaxed">
                                                                <div className="text-right">
                                                                    {c.type} ▶
                                                                </div>
                                                                <div className="pl-2 text-left">
                                                                    <a href={"mailto:" + c.contact}>
                                                                        {c.contact}
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        );
                                                    default:
                                                        return (
                                                            <div
                                                                className="grid grid-cols-2 lg:text-md text-sm text-gray-700 leading-relaxed">
                                                                <div className="text-right">
                                                                    {c.type} ▶
                                                                </div>
                                                                <div className="pl-2 text-left">
                                                                   <div>{c.contact}</div>
                                                                </div>
                                                            </div>
                                                        );

                                                }

                                            })}
                                            <div className="mt-3 mb-2 items-center text-center">

                                                <a

                                                    href={website}
                                                    className="mt-3 sm:mt-0 py-2 px-5 md:py-3 md:px-6 bg-gray-200 hover:bg-gray-300 font-bold text-center text-gray-700 md:text-lg rounded-lg shadow-md">
                                                    Ugrás a weboldalra
                                                </a>
                                            </div>
                                        </div>

                                    </div>
                                    <div
                                        className="w-full bg-gray-200 p-3">
                                        <h1 className="text-2xl text-center font-semibold text-gray-700 mt-4 mb-5">Irodánkról</h1>
                                        <Carousel className="h-[426px]">
                                            <img className=""
                                                 src={"http://www.temetkezes.hu/assets/img/header-bg.jpg"}
                                                 alt=""/>
                                            <img className=""
                                                 src={"http://www.temetkezes.hu/assets/img/header-bg.jpg"}
                                                 alt=""/>

                                        </Carousel>
                                    </div>


                                </div>

                            </div>
                        );
                    })}
                </div>
                <div className="h-flexible lg:col-span-3">
                    <GoogleMap
                        mapContainerStyle={{
                            height: "100%",
                        }}
                        center={selectedLocation}
                        zoom={zoom}
                        onLoad={onMapLoad}
                    >
                        {offices.map((office) => {
                            return (
                                <MarkerF key={office.id} onClick={() => {
                                    setSelectedMarker(office)
                                    setSelectedLocation({lat: office.latitude, lng: office.longitude})
                                    setZoom(17)
                                }}
                                         position={{lat: office.latitude, lng: office.longitude}}
                                         icon={mapicon}
                                />
                            );
                        })}
                        {selectedMarker &&
                            <InfoWindow
                                position={{lat: selectedMarker.latitude + 0.000252, lng: selectedMarker.longitude}}
                                onCloseClick={() => {
                                    setSelectedMarker()
                                }}>
                                <>
                                    <h1>{selectedMarker.name}</h1>
                                    <p>{selectedMarker.location}</p>
                                </>
                            </InfoWindow>
                        }
                    </GoogleMap>
                </div>
            </div>
        </div>


    );
}
