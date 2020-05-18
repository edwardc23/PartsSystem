import React from 'react'
import {Link} from 'react-router-dom'

function AboutComponent(){
    return(
        <div>
            <button className='btn btn-link' style={{color: "black", textAlign: "right"}} type="button"><Link to="/landingPage">Home</Link></button>
            <button className='btn btn-link' style={{color: "black", textAlign: "right"}} type="button"><Link to="/login">Logout</Link></button>
            <div>
            <h2>About</h2>
            <p1>Blah blah blah.. </p1>
            </div>
        </div>
    )
}
export default AboutComponent