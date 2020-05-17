import React, {Component} from 'react'

import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomePage from './WelcomePage'
import Login from '../admin/Login'
import UpdateItem from '../inventory/UpdateItem'
import AddItem from '../inventory/AddItem'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import ShowInventory from '../inventory/ShowInventory'
import Logout from '../admin/Logout'
import Testcomponent from '../../Testcomponent'
import AddAdmin from '../admin/AddAdmin'
import Assets from '../inventory/Assets'
import AboutComponent from './AboutComponent'
import LandingPage from './LandingPage'
class RoutingComponent extends Component{
    render(){
        return(
            <div>
            <Router>
                <HeaderComponent />
                    <Switch>
                        <Route exact path="/"><WelcomePage/></Route> />
                        <Route path="/login" component={Login} />
                        <Route path="/logout" component={Logout}/>
                        <Route path="/landingPage" component={LandingPage} />
                        <Route path="/about" component={AboutComponent}/>
                        <Route path="/assets" component={Assets} />
                        <Route path="/about" component={AboutComponent}/>
                        <Route path="/addAdmin" component={AddAdmin} />
                        <Route path="/inventory" component={ShowInventory} />
                        <Route path="/AddItem" component={AddItem} />
                        <Route path="/UpdateItem/:id/:name/:location/:make/:model/:year/:msrp/:price" component={UpdateItem} />
                        <Route path ="/Test" component={Testcomponent}/>
                    </Switch>
                <FooterComponent /> 
            </ Router>
            </div>
        )
    }

}
export default RoutingComponent;