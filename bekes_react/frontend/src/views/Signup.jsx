import {Link} from "react-router-dom";
import {createRef, useState} from "react";
import axiosClient from "../axios-client.js";
import {useStateContext} from "../contexts/ContextProvider.jsx";

export default function Signup(){
    const nameRef = createRef();
    const emailRef = createRef();
    const passwordRef = createRef();
    const passwordConfirmRef = createRef();
    const phoneRef = createRef();

    const {setUser,setToken} = useStateContext();
    const [errors, setErrors] = useState(null);

    const onSubmit = (ev) => {
        ev.preventDefault();
        const payload = {
            name: nameRef.current.value,
            email: emailRef.current.value,
            password: passwordRef.current.value,
            password_confirmation: passwordConfirmRef.current.value,
            phone: phoneRef.current.value
        }
        axiosClient.post('/signup',payload)
            .then(({data})=> {
                setUser(data.user)
                setToken(data.token)
            }).catch(err => {
                console.log(err);
                const response = err.response;
                if(response && response.status === 422){
                    setErrors(response.data.errors);
                }
            
            })

        console.log(payload);
    }
    return (
        <div className="login-signup-form animated fadeInDown">
            <div className="form">
                <form onSubmit={onSubmit}>
                    <h1 className="title">
                    Signup for free
                    </h1>
                    {errors &&
                        <div className="alert">
                        {Object.keys(errors).map(key => (
                            <p key={key}>{errors[key][0]}</p>
                        ))}
                        </div>
                    }
                    <input ref={nameRef} type="text" placeholder="Name"/>
                    <input ref={emailRef} type="email" placeholder="Email"/>
                    <input ref={phoneRef} type="text" placeholder="Phone"/>
                    <input ref={passwordRef} type="password" placeholder="Password"/>
                    <input ref={passwordConfirmRef} type="password" placeholder="Password Confirm"/>
                    <button className="btn btn-block" type="submit">Sign in</button>
                    <p className="message">
                        Already Registered? <Link to="/login">Sign in</Link>
                    </p>
                </form>
            </div>
        </div>
    );
}