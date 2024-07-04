
import Office from "./Office.jsx";
import React, {useEffect, useRef, useState} from "react";
import axiosClient from "../axios-client.js";
import {Link, useParams} from "react-router-dom";

import {GoogleMap, InfoWindow, MarkerF, useLoadScript} from "@react-google-maps/api";
import mapicon from "../img/mapicon.png";


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

        if(!loaded)
            getRegions()

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
            <div className="grid lg:grid-cols-2 lg:gap-2 grid-cols-1">
                <div className="overflow-y-scroll overflow-visible w-full antialiased h-flexible">
                    {offices.map((office) => {
                        return (
                            <div onClick={() =>
                            {

                                setSelectedLocation({lat: office.latitude, lng: office.longitude})
                                setZoom(17)
                                setSelectedMarker(office)
                            }
                            } >
                                <Office office={office} key={office.id}/>

                            </div>
                                  );
                    })}
                </div>
                <div className="h-flexible">
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
                                <MarkerF onClick={() => {
                                    setSelectedMarker(office)
                                    setSelectedLocation ({lat: office.latitude, lng: office.longitude})
                                    setZoom(17)
                                }}
                                         position={{lat: office.latitude, lng: office.longitude}}
                                         icon={mapicon}
                                />
                            );
                        })}
                        {selectedMarker &&
                            <InfoWindow position={{lat: selectedMarker.latitude+0.000252, lng: selectedMarker.longitude}}
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
