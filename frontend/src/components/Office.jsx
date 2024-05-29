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
                          <div className="flex items-center">
                              <div className="flex">
                                  <svg className="w-4 h-4 mx-px fill-current text-green-600"
                                       xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14">
                                      <path
                                          d="M6.43 12l-2.36 1.64a1 1 0 0 1-1.53-1.11l.83-2.75a1 1 0 0 0-.35-1.09L.73 6.96a1 1 0 0 1 .59-1.8l2.87-.06a1 1 0 0 0 .92-.67l.95-2.71a1 1 0 0 1 1.88 0l.95 2.71c.13.4.5.66.92.67l2.87.06a1 1 0 0 1 .59 1.8l-2.3 1.73a1 1 0 0 0-.34 1.09l.83 2.75a1 1 0 0 1-1.53 1.1L7.57 12a1 1 0 0 0-1.14 0z"/>
                                  </svg>
                                  <svg className="w-4 h-4 mx-px fill-current text-green-600"
                                       xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14">
                                      <path
                                          d="M6.43 12l-2.36 1.64a1 1 0 0 1-1.53-1.11l.83-2.75a1 1 0 0 0-.35-1.09L.73 6.96a1 1 0 0 1 .59-1.8l2.87-.06a1 1 0 0 0 .92-.67l.95-2.71a1 1 0 0 1 1.88 0l.95 2.71c.13.4.5.66.92.67l2.87.06a1 1 0 0 1 .59 1.8l-2.3 1.73a1 1 0 0 0-.34 1.09l.83 2.75a1 1 0 0 1-1.53 1.1L7.57 12a1 1 0 0 0-1.14 0z"/>
                                  </svg>
                                  <svg className="w-4 h-4 mx-px fill-current text-green-600"
                                       xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14">
                                      <path
                                          d="M6.43 12l-2.36 1.64a1 1 0 0 1-1.53-1.11l.83-2.75a1 1 0 0 0-.35-1.09L.73 6.96a1 1 0 0 1 .59-1.8l2.87-.06a1 1 0 0 0 .92-.67l.95-2.71a1 1 0 0 1 1.88 0l.95 2.71c.13.4.5.66.92.67l2.87.06a1 1 0 0 1 .59 1.8l-2.3 1.73a1 1 0 0 0-.34 1.09l.83 2.75a1 1 0 0 1-1.53 1.1L7.57 12a1 1 0 0 0-1.14 0z"/>
                                  </svg>
                                  <svg className="w-4 h-4 mx-px fill-current text-green-600"
                                       xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14">
                                      <path
                                          d="M6.43 12l-2.36 1.64a1 1 0 0 1-1.53-1.11l.83-2.75a1 1 0 0 0-.35-1.09L.73 6.96a1 1 0 0 1 .59-1.8l2.87-.06a1 1 0 0 0 .92-.67l.95-2.71a1 1 0 0 1 1.88 0l.95 2.71c.13.4.5.66.92.67l2.87.06a1 1 0 0 1 .59 1.8l-2.3 1.73a1 1 0 0 0-.34 1.09l.83 2.75a1 1 0 0 1-1.53 1.1L7.57 12a1 1 0 0 0-1.14 0z"/>
                                  </svg>
                                  <svg className="w-4 h-4 mx-px fill-current text-green-600"
                                       xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14">
                                      <path
                                          d="M6.43 12l-2.36 1.64a1 1 0 0 1-1.53-1.11l.83-2.75a1 1 0 0 0-.35-1.09L.73 6.96a1 1 0 0 1 .59-1.8l2.87-.06a1 1 0 0 0 .92-.67l.95-2.71a1 1 0 0 1 1.88 0l.95 2.71c.13.4.5.66.92.67l2.87.06a1 1 0 0 1 .59 1.8l-2.3 1.73a1 1 0 0 0-.34 1.09l.83 2.75a1 1 0 0 1-1.53 1.1L7.57 12a1 1 0 0 0-1.14 0z"/>
                                  </svg>
                              </div>
                              <div className="text-gray-600 ml-2 text-sm md:text-base mt-1">
                                  16 reviews
                              </div>
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
