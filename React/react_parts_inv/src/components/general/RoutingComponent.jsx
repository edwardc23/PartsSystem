import React, {Component} from 'react'

import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomePage from './WelcomePage'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
class RoutingComponent extends Component{
    render(){
        return(
            <div>
            <HeaderComponent/>
            <WelcomePage/>
            <FooterComponent/>
            </div>
        )
    }

}
export default RoutingComponent;