import {Link, Navigate, Outlet} from "react-router-dom";
import Footer from "./Footer.jsx";
import {useStateContext} from "../contexts/ContextProvider.jsx";

export default function FormLayout() {
    const { token} = useStateContext()

    if (token) {
        return <Navigate to="/"/>
    } else {

        return (
            <div id="guestLayout">
                <Outlet/>
                <Footer/>
            </div>
        );
    }
}