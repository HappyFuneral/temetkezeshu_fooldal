import {HeroOffer} from "../components/Hero.jsx";
import CheckoutForm from "./Checkout.jsx";



const Offer = () => {
    // get products from product context
    // get only men's and women's clothing category
    return (
        <div>
            <HeroOffer/>
            <section className="py-20">
                <div className="grid justify-items-center">
                    <CheckoutForm/>
                </div>
            </section>
        </div>
    );
}
export default Offer;