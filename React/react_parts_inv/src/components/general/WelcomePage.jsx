import React from 'react'
import {Link} from 'react-router-dom'

function WelcomePage(){
    return(
        <div className="">
            <div>
            <h1>Welcome to the Inventory Tracker</h1>
            <br></br>
            <h2>This is an adjustment</h2>
            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/login">Login</Link></button> 
            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/addAdmin">Register</Link></button>
            </div>

        </div>
    )

}
export default WelcomePage