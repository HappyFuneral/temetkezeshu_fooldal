import React, { useContext, useEffect, useState } from "react";
import { SidebarContext } from "../contexts/SidebarContext";
import { CartContext } from "../contexts/CartContext";
import { Link } from "react-router-dom";
import Logo from "../img/logo.svg";
import { BsBag } from "react-icons/bs";
import {StickyNavbar} from "./Nav.jsx";
import {Typography} from "@material-tailwind/react";
import head from "../assets/head.png";
import {MegaMenuDefault} from "./MegaMenu.jsx";
import {DefaultAccordion} from "./Accordion.jsx";

const Header = () => {
  // header state
  const [isActive, setIsActive] = useState(false);
  const { isOpen, setIsOpen } = useContext(SidebarContext);
  const { itemAmount } = useContext(CartContext);

  // event listener
  useEffect(() => {
    window.addEventListener("scroll", () => {
      window.scrollY > 60 ? setIsActive(true) : setIsActive(false);
    });
  });

  return (
    <header
      className={`${
        isActive ? "" : "bg-none lg:py-6"
      } fixed z-10 lg:px-8 transition-all w-full`}
    >
      <StickyNavbar/>

    </header>
);
};

export default Header;
