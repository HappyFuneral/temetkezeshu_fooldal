// eslint-disable-next-line no-unused-vars
import { Link } from "react-router-dom";
import officeImage from "../img/office.jpg";
import {Button, Typography} from "@material-tailwind/react";
import React from "react";

// eslint-disable-next-line react/prop-types
const Office = ({ office }) => {

  // destructure product
  // eslint-disable-next-line react/prop-types
  const { id, location, name } = office;
  return (
      <div className="relative h-full w-full">
          <img
              src={officeImage}
              alt="image 1"
              className="h-full w-full object-cover"
          />
          <div className="absolute inset-0 grid h-full w-full place-items-center bg-black/75">
              <div className="w-3/4 text-center md:w-2/4">
                  <Typography
                      variant="h1"
                      color="white"
                      className="mb-4 text-3xl md:text-4xl lg:text-5xl"
                  >
                      {name}
                  </Typography>
                  <Typography
                      variant="lead"
                      color="white"
                      className="mb-12 opacity-80"
                  >
                      {location}
                  </Typography>
                  <div className="flex justify-center">
                      <Button className=" p-3" size="lg" color="white">
                          Fedezze fel irodánk!
                      </Button>

                  </div>
              </div>
          </div>
      </div>

  );
};

export default Office;
