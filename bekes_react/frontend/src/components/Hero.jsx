import React from "react";

import {Link, redirect} from "react-router-dom";
import {CarouselCustomNavigation} from "./Carousel.jsx";
import LinkGroup from "./LinkGroup.jsx";
import {Button} from "@material-tailwind/react";

const Hero = () => {

    const hamvak =
        [
            {
                title: "Hamvak hazavitele"
            },
            {
                title: "Hamvak elhelyezése Békéscsaba"
            },
            {
                title: "Hamvak elhelyezése Békés Vármegye"
            }
        ]
    const koporso = [
        {
            title: "Elhunyt szállítás"
        },
        {
            title: "Koporsós temetés Békéscsaba"
        },
        {
            title: "Koporsós temetés Békés Vármegye"
        }
    ]
  return (
      <section className="h-[800px] bg-hero bg-no-repeat bg-cover bg-center content-center grayscale">
          <div className="grid grid-cols-2  justify-items-center ">
              <LinkGroup items={hamvak}/>
              <LinkGroup items={koporso}/>
          </div>
          <div className="grid justify-items-center">
              <Link to="/offer"><Button >Ajánlatkérés</Button></Link>
          </div>

      </section>
  );
};

export function HeroOffer() {
    return (
        <section className="h-[400px] bg-offer bg-no-repeat bg-cover bg-center content-center grayscale">
            <div className="grid justify-items-center">
                <h1 className="text-4xl text-white font-semibold mb-10 text-center">Kérjen ajánlatot</h1>
            </div>

        </section>
    )

}

export default Hero;
