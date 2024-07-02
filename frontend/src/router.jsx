import {createBrowserRouter } from "react-router-dom";
import Login from './views/Login.jsx';
import DefaultLayout from "./components/DefaultLayout.jsx";
import GuestLayout from "./components/GuestLayout.jsx";
import Signup from "./views/Signup.jsx";
import Landing from "./views/Landing.jsx";

import {RegionMap} from "./components/Regions.jsx";
import RegionLayout from "./components/RegionLayout.jsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <RegionLayout/>,
        children: [
            {
                path: '/',
                element: <Landing/>
            },
            {
                path: '/map/regions/:code',
                element: <RegionMap/>
            },
        ]
    }
]);

export default router;