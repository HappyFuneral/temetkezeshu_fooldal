
import MapG from '../components/Map.jsx';
import bg from '../img/bg.jpg';

const Landing = () => {
  // get products from product context



  // get only men's and women's clothing category
    return (
        <div className="text-white">
            <section className="grid w-full min-h-screen items-center justify-items-center"
                     >
                <div className="w-full min-h-screen" style={{
                    backgroundImage: `url(${bg})`,
                    backgroundRepeat: "no-repeat",
                    backgroundSize: "cover",
                    filter: "blur(8px)",
                    zIndex: "-1",
                    position: "absolute",
                    top: "0px",
                    height: "100%"

                }}></div>
              <div className="w-full" style={{

              }}>
                  <MapG className=""/>
              </div>

            </section>
      </div>
    );
}
export default Landing;