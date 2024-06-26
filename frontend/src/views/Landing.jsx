
import MapG from '../components/Map.jsx';
import bg from '../img/bg.jpg';

const Landing = () => {
  // get products from product context



  // get only men's and women's clothing category
    return (
        <div className="text-white">
            <section className="grid mx-auto w-auto min-h-screen items-center justify-items-center"
            style={{
                    backgroundImage: `url(${bg})`,
                    backgroundRepeat: "no-repeat",
                    backgroundSize: "cover",
                    backgroundPosition: "center center",
                    zIndex: "-1",
                    height: "100%"

                }}
                     >
                <div className="w-full h-full" ></div>
              <div className="w-full lg:w-5/12 md:w-3/5" style={{
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