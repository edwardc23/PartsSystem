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
        let Inventory = {
            Username: vals.Username,
            Password: vals.Password
            
        }
        ControllerDataServices.check(this)
    }
    render(){
        return(
            <form>
                <p>Username:</p>
                <input type="text"/>
                <p>Password:</p>
                <input type="text"/>
            </form>
        );
    }
    
}
export default Login 