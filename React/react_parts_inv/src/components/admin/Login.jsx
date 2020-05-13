import React from 'react'
import { Component } from "react"
import ControllerDataServices from '../../services-HTTP/ControllerDataServices'
class Login extends Component{
    constructor(props){
        super(props)
        this.state = {
            Username: '',
            Password: ''
            
        }
        this.onSubmit = this.onSubmit.bind(this)

        //handles go here
    }
    onSubmit(vals){
        let user = {
            Username: vals.Username,
            Password: vals.Password
            
        }
        ControllerDataServices.check(user)
    }
    render(){
        return(
            <form>
                <p>Username:</p>
                <input type="text"/>
                <p>Password:</p>
                <input type="text"/>
                <br></br>
                <button type="submit" form="form" value="Submit" onClick="ControllerDataServices.check(user)">Submit</button>
            </form>
            
        );
    }
    
}
export default Login 