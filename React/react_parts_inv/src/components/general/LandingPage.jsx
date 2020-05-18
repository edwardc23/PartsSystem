import React from 'react'
import {Link} from 'react-router-dom'

function LandingPage(){

    return(
        <div>
            <button className='btn btn-link' style={{color: "black", textAlign: "right"}} type="button"><Link to="/login">Logout</Link></button>
            <h2> Landing Page</h2>
            <br></br>
            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/inventory">Go to inventory</Link></button>
            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/about">About Neal Rigga Services</Link></button>
            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/assets">See our assets</Link></button>
        </div>
    )
}

export default LandingPage