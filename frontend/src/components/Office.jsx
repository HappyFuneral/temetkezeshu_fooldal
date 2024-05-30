// eslint-disable-next-line no-unused-vars
import { Link } from "react-router-dom";
import officeImage from "../img/office.jpg";
import {Button, Typography} from "@material-tailwind/react";
import React from "react";

// eslint-disable-next-line react/prop-types
const Office = ({ office }) => {

  // destructure product
  // eslint-disable-next-line react/prop-types
    const { id, location, name, website } = office;
  return (
      <div
          className="mb-2 flex flex-wrap md:flex-nowrap shadow-lg mx-auto max-w-full group cursor-pointer transform duration-500 hover:-translate-y-1">
          <img className="w-full md:w-52"
               src="https://i.ibb.co/Kr4b0zJ/152013403-10158311889099633-8423107287930246533-o.jpg" alt=""/>
          <div className="w-full">
              <div className="p-5 pb-10">
                  <h1 className="text-2xl font-semibold text-gray-800 mt-4">
                      {office.name}
                  </h1>
                  <p className="text-xl text-gray-400 mt-2 leading-relaxed">
                      {office.location}
                  </p>
              </div>
              <div className="bg-blue-50 p-5">
                  <div className="sm:flex sm:justify-between">
                      <div>
                          <div className="text-lg text-gray-700">
                              <span className="text-gray-900 font-bold">196 km</span> from Dhaka
                          </div>

                      </div>
                      <a

                          href={office.website} className="mt-3 sm:mt-0 py-2 px-5 md:py-3 md:px-6 bg-gray-600 hover:bg-gray-500 font-bold text-white md:text-lg rounded-lg shadow-md">
                          Megnéz
                      </a>
                  </div>
                  <div className="mt-3 text-gray-600 text-sm md:text-sm">
                      *Places to visit: Mahasthangarh, Vasu Bihar & Momo Inn
                  </div>
              </div>
          </div>
      </div>


  );
};

export default Office;
