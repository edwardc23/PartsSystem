import React, {Component} from 'react'

import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomePage from './WelcomePage'
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