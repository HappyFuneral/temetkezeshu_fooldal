import { Outlet} from "react-router-dom";
import Footer from "./Footer.jsx";
import Header from "./Header.jsx";

export default function GuestLayout() {



        return (
            <div id="guestLayout" className="text-gray-700 animated fadeInDown">
                <Header/>
                <Outlet/>
				<Footer/>
            </div>
        );

}