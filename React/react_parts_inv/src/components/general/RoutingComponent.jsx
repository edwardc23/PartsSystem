import React, {Component} from 'react'
import HeaderComponent from './HeaderComponent'
class RoutingComponent extends Component{
    render(){
        return(
            <div>
                <Router>
                    <HeaderComponent/>
                    <Switch>
                        <Route exact path="/"> <WelcomePage name = ""/> </Route> />
                    </Switch>
                </Router>

            </div>

        )
    }

}
export default RoutingComponent;