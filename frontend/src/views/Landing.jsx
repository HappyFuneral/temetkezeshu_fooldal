
import MapG from '../components/Map.jsx';
import {Link} from "react-router-dom";
import React from "react";

const Landing = () => {
  // get products from product context



  // get only men's and women's clothing category
    return (

        <div className="text-white">
            <div className="w-full bg-black">
                <div className="text-white  container mx-auto p-5">
                    <p>
                        <Link className="" to="/">Főoldal</Link>
                        <svg xmlns="http://www.w3.org/2000/svg" style={{display: "unset"}} width="24" height="24"
                             fill="white">
                            <path
                                d="M7.293 4.707 14.586 12l-7.293 7.293 1.414 1.414L17.414 12 8.707 3.293 7.293 4.707z"/>
                        </svg>
                        <Link to="/">Térkép</Link>
                    </p>
                </div>
            </div>
            <section className="grid mx-auto w-auto items-center justify-items-center"
                     style={{
                         backgroundColor: "#403e3e",
                         backgroundRepeat: "no-repeat",
                         backgroundSize: "cover",
                         backgroundPosition: "center center",
                         zIndex: "-1",
                         height: "100%"

                     }}
            >
                <div className="w-full lg:w-5/12 md:w-3/5" style={{}}>
                    <MapG className=""/>
                </div>
                <div>

                </div>
            </section>
        </div>
    );
}
export default Landing;