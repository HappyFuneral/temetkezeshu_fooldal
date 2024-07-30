import {Link, Navigate, Outlet} from "react-router-dom";
import Header from "./Header.jsx";
import Footer from "./Footer.jsx";
import Sidebar from "./Sidebar.jsx";
import {useStateContext} from "../contexts/ContextProvider.jsx";

export default function GuestLayout() {
    const { token} = useStateContext()

    if (token) {
        return <Navigate to="/"/>
    } else {

        return (
            <div id="guestLayout">
				<Header/>
                <Outlet/>
				<Sidebar/>
				<Footer/>
            </div>
        );
    }
}