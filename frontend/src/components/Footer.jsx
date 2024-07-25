
const Footer = () => {
  return (
      <footer
          className="flex flex-col items-center bg-black text-center text-white">
          <div className="container px-6 pt-6">
           

              <div>
                      <div
                          className="gird-cols-1 grid items-center justify-center gap-2 md:grid-cols-2">

                          <div className="relative md:mb-6" data-twe-input-wrapper-init>
                              <a href="mailto:info@temetkezes.hu">
                                  <p className="text-white">
                                      info@temetkezes.hu
                                  </p>
                              </a>

                          </div>

                          <div className="mb-6">
                              <a href="tel:00000000">
                                  <p className="text-white">
                                      0000-000-000
                                  </p>
                              </a>


                          </div>
                      </div>
              </div>




          </div>

          <div className="w-full bg-black/5 p-4 text-center">
              © 2024 Copyright:
              <a className="font-semibold" href=""
              > Temetkezes</a
              >
          </div>
      </footer>
  );
};

export default Footer;
