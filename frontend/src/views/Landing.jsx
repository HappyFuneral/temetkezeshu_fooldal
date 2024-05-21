
import MapG from '../components/Map.jsx';
import bg from '../img/bg.jpg';

const Landing = () => {
  // get products from product context



  // get only men's and women's clothing category
    return (
        <div className="flex text-white ">
            <section className="grid w-full min-h-screen items-center justify-items-center"
                     style={{
                         backgroundImage: `url(${bg})`,
                         backgroundRepeat: "no-repeat",
                         backgroundSize: "cover",

            }}>
              <div className="md:w-full sm:w-full lg:w-4/5 container lg:mx-auto md:mx-mx-2 sm:-mx-2 ">
                  <MapG className=""/>
              </div>

            </section>
      </div>
    );
}
export default Landing;