
import MapG from '../components/Map.jsx';
import bg from '../img/bg.jpg';

const Landing = () => {
  // get products from product context



  // get only men's and women's clothing category
    return (
        <div className="text-white">
            <section className="grid mx-auto w-auto min-h-screen items-center justify-items-center"
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
              <div className="w-full lg:w-3/12" style={{
              }}>
                  <MapG className=""/>
              </div>
                <div>
                    
                </div>
            </section>
      </div>
    );
}
export default Landing;