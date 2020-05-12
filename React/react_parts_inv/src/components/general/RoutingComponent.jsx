<<<<<<< Updated upstream
import React, {Component} from 'react'

import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomePage from './WelcomePage'
import { Router, Switch, Route } from 'react-router-dom'
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
=======
import React, {Component} from 'react'

import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomePage from './WelcomePage'
import { Router, Switch, Route } from 'react-router-dom'
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
>>>>>>> Stashed changes
export default RoutingComponent;