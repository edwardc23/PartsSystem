import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import ControllerDataServices from '../../services-HTTP/ControllerDataServices';

class Assets extends Component{
    constructor(props){
        super(props)
        this.state={
            assets: []
        }
        this.displayAssets = this.displayAssets.bind(this)
    }

    componentDidMount(){
        this.displayAssets()
    }//end component mount

    displayAssets(){
        console.log('Displaying assets')
        ControllerDataServices.grabAssets()
        .then(
            response => {
                this.setState({assets: response.data})
                console.log({assets:response.data})
            }
        )
        //this.props.history.push(`/inventory}`)
    } //end Assets()

    render(){
        return(
            <div>
                <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/inventory">Inventory</Link></button>
                <button className='btn btn-link' style={{color: "black", textAlign: "right"}} type="button"><Link to="/landingPage">Home</Link></button>
                <button className='btn btn-link' style={{color: "black", textAlign: "right"}} type="button"><Link to="/login">Logout</Link></button>
                <div className= "container">
                    <h1 style={{textAlign:"center"}}>Assets</h1>
                    <div className="jumbotron jumbo">
                        <div className="table table" >
                            <thead>
                                <tr style={{textAlign: "center"}}>
                                    <th>Name</th>
                                    <th>Amount </th>
                                    <th>Cost</th>
                                    <th>MSRP</th>
                                    <th>Total MSRP</th>
                                    <th>Total Cost</th>
                                    <th>Profit</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.assets.map(
                                        assets =>
                                        <tr style={{textAlign: "center"}} key={assets.id}>
                                            <td>{assets.part}</td>
                                            <td>{assets.amountOf}</td>
                                            <td>{assets.cost}</td>
                                            <td>{assets.msrp}</td>
                                            <td>{assets.totalMSRP}</td>
                                            <td>{assets.totalCost}</td>
                                            <td>{assets.profit}</td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}
export default Assets