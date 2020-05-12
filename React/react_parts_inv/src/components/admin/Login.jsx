import React from 'react'
import { Component } from "react"

class Login extends Component{
    render(){
        return(
            <form>
                <p>Username:</p>
                <input
                type="text"
                />
                <p>Password:</p>
                <input
                type="text"
                />
            </form>
        );
    }
    
}
