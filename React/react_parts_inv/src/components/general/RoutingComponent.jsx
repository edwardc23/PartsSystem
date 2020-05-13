import React, {Component} from 'react'

import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomePage from './WelcomePage'
import Login from '../admin/Login'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
class RoutingComponent extends Component{
    render(){
        return(
            <div>
            <Router>
                <HeaderComponent />
                    <Switch>
                        <Route exact path="/"><WelcomePage/></Route> />
                        <Route path="/login" component={Login} />
                    </Switch>
                <FooterComponent /> 
            </ Router>
            </div>
        )
    }

}
export default RoutingComponent;