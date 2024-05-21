import React, { useRef, useEffect, useState } from 'react';
import maplibregl from 'maplibre-gl';
import 'maplibre-gl/dist/maplibre-gl.css';

export default function CodeMap({offices}) {
    const mapContainer = useRef(null);
    const map = useRef(null);
    const [lng] = useState(47.51094616501458);
    const [lat] = useState(19.028613720052647);
    const [zoom] = useState(7);
    const [API_KEY] = useState('41gaH5FUcDfw4EluMmMJ');

    useEffect(() => {
        if (map.current) return; // stops map from intializing more than once

        map.current = new maplibregl.Map({
            container: mapContainer.current,
            style: `https://api.maptiler.com/maps/streets-v2/style.json?key=${API_KEY}`,
            center: [lng, lat],
            zoom: zoom
        });
        map.current.addControl(new maplibregl.NavigationControl(), 'top-right');
        {offices.map((office) => {
            new maplibregl.Marker({color: "#FF0000"})
                .setLngLat([office.latitude,office.longitude]).addTo(map.current);
        })}

    }, [API_KEY, lng, lat, zoom, offices]);

    return (
        <div className="map-wrap">
            <div ref={mapContainer} className="map" />
        </div>
    );
}