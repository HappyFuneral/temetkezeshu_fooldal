import { Outlet} from "react-router-dom";
import Footer from "./Footer.jsx";
import Header from "./Header.jsx";

export default function RegionLayout() {



    return (
        <div id="regionLayout" className="text-gray-700 animated fadeInDown">
            <Outlet/>
            <Footer/>
        </div>
    );

}