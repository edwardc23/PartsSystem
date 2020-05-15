import React, {Component} from 'react'

import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomePage from './WelcomePage'
import Login from '../admin/Login'
import UpdateItem from '../inventory/UpdateItem'
import AddItem from '../inventory/AddItem'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import ShowInventory from '../inventory/ShowInventory'

import Testcomponent from '../../Testcomponent'
import AddAdmin from '../admin/AddAdmin'
class RoutingComponent extends Component{
    render(){
        return(
            <div>
            <Router>
                <HeaderComponent />
                    <Switch>
                        <Route exact path="/"><WelcomePage/></Route> />
                        <Route path="/login" component={Login} />
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