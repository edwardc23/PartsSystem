import React from 'react'
import {Link} from 'react-router-dom'


function Logout() {
    return(
        <div className="logout">
            <button className='btn btn-link' style={{color: "black", textAlign: "right"}} type="button"><Link to="/login">Logout</Link></button>
        </div>
    )
}
export default Logout