import {createBrowserRouter } from "react-router-dom";
import Login from './views/Login.jsx';
import DefaultLayout from "./components/DefaultLayout.jsx";
import GuestLayout from "./components/GuestLayout.jsx";
import Signup from "./views/Signup.jsx";
import Landing from "./views/Landing.jsx";

import {RegionMap} from "./components/Regions.jsx";

const router = createBrowserRouter([

    {
        path: '/',
        element: <GuestLayout/>,
        children: [
            {
                path: '/landing',
                element: <Landing/>
            },

            {
                path: '/landing/map/:code',
                element: <RegionMap/>
            },

            {
                path: '/login',
                element: <Login/>
            },
            {
                path: '/signup',
                element: <Signup/>
            }
        ]
    },
]);

export default router;