import React from "react";
import { GoogleMap, useLoadScript, MarkerF } from "@react-google-maps/api";
import Office from "./Office.jsx";
import mapicon from "../img/mapicon.png";

const MapComponent = ({ selectedLocation, offices,zoom }) => {
    const { isLoaded, loadError } = useLoadScript({
        googleMapsApiKey: "AIzaSyDWtnOf9mfiuz8Y8FZU-UxeJCCVOe8KLFU",
    });
    const mapRef = React.useRef();
    const onMapLoad = React.useCallback((map) => {
        mapRef.current = map;
    }, []);
    if (loadError) return "Error";
    if (!isLoaded) return "Maps";

    return (
        <div style={{height: "50vh"}}>
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
                        <MarkerF
                            position={{lat: office.latitude, lng: office.longitude}}
                            icon={mapicon}
                        />
                    );
                })}

            </GoogleMap>
        </div>
    );
};

export default MapComponent;