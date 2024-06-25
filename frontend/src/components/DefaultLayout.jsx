import {Link, Navigate, Outlet} from "react-router-dom";
import {useStateContext} from "../contexts/ContextProvider.jsx";
import { useEffect } from "react";
import axiosClient from "../axios-client.js";

export default function DefaultLayout() {
    const {user, token, setUser, setToken} = useStateContext()

    if (!token) {
        return <Navigate to="/"/>
        
    } else {
        const Logout = (ev) => {
            ev.preventDefault();
            axiosClient.post('/logout',null,{validateStatus: false}).then(()=>{
                setUser({});
                setToken(null);
            })
        }
        useEffect (()=>{
            axiosClient.get('/user')
            .then(({data}) => {
                setUser(data)
            })
        },[])
        return (
            <div id="defaultLayout">
                <aside>
                    <Link to="/home">
                        Dashboard
                    </Link>
                </aside>
                <div className="content">
                    <header>
                        <div>Header</div>
                        <div>
                            {user.name}
                            <a href="#" onClick={Logout} className="btn-logout">Logout</a>
                        </div>
                    </header>
                    <main>
                        <Outlet/>
                    </main>
                </div>

            </div>
        );
    }
}