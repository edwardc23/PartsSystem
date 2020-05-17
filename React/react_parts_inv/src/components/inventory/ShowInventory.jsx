import React from 'react'
import { Component } from 'react';
import ControllerDataServices from '../../services-HTTP/ControllerDataServices';
import {Link} from 'react-router-dom'
class ShowInventory extends Component {
    constructor(props){
        super(props)
        this.state = {
            //id: this.props.match.params.id,
            inventory: [],
            msg: null
            //msg: console.log(null)
        }
        this.displayInventory = this.displayInventory.bind(this)
        this.deleteItem = this.deleteItem.bind(this)
        this.updateItemSwitch = this.updateItemSwitch.bind(this)
        this.clearInventory = this.clearInventory.bind(this)
        this.addItemSwitch = this.addItemSwitch.bind(this)
        this.add = this.add.bind(this)
    }

    componentDidMount(){
        this.displayInventory();
    } //end componentDidMount

    add(){
        
            this.props.history.push("/AddItem")
        
    }
    deleteItem(id){
        console.log('Delete item')
        ControllerDataServices.deleteItem(id)
        .then(
            response => {
                this.displayInventory();
            }
        )
    } //end deleteItem()

    clearInventory(){
        console.log('Wipe inventory')
        ControllerDataServices.wipeInventory()
        .then(
            response =>{
                this.displayInventory();
                //this.props.history.push(`/inventory}`)
            }
        )

    } //end clearInventory()

    addItemSwitch(){
        console.log('Add item button clicked')
        this.props.history.push(`/AddItem`)
       }//end addItemSwitch()

    updateItemSwitch(id, name, location, make, model, year, msrp, price){
        console.log('Update button clicked')
        this.props.history.push(`/UpdateItem/${id}/${name}/${location}/${make}/${model}/${year}/${msrp}/${price}`)
     
    } //end updateItemSwitch()

    displayInventory(){
        console.log('Displaying inventory')
        ControllerDataServices.listInventory()
        .then(
            response => {
                this.setState({inventory: response.data})
                console.log({inventory:response.data})
            }
        )
        //this.props.history.push(`/inventory}`)
    } //end displayInventory()

    render(){
        return(
            <div className="container">
               <h1 style={{textAlign:"center"}}>Inventory</h1><br></br><br></br>
               <div className="jumbotron jumbo" >
                        <div className="table-bordered table" >
                            <thead>
                                <tr style={{textAlign: "center"}}>
                                    
                                    <th>Name</th>
                                    <th>Location</th>
                                    <th>Make</th>
                                    <th>Model</th>
                                    <th>Model Year</th>
                                    <th>MSRP</th>
                                    <th>Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.inventory.map(
                                        inventory =>
                                        <tr style={{textAlign: "center"}} key={inventory.id}>
                                            <td>{inventory.partName}</td>
                                            <td>{inventory.location}</td>
                                            <td>{inventory.make}</td>
                                            <td>{inventory.model}</td>
                                            <td>{inventory.year}</td>
                                            <td>{inventory.msrp}</td>
                                            <td>{inventory.price}</td>
                                            <br></br>
                                            <br></br>
                                            <br></br>
                                            <td><button className="btn btn-link text-input" style={{color:"black"}} onClick={()=> this.deleteItem(inventory.id)}>Delete item</button></td>
                                            <td>
                                                <button 
                                                    className="btn btn-link text-input" style={{color:"black"}}
                                                    onClick={()=> this.updateItemSwitch(inventory.id, inventory.partName, inventory.location, inventory.make, inventory.model, inventory.year, inventory.msrp, inventory.price)}>
                                                    Update existing item
                                                </button>
                                            </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </div>
                        <br></br>
                        <button className="btn btn-link text-input" style={{color:"black"}} onClick={()=> this.clearInventory()}>Wipe Inventory</button>
                        <br></br>
                        <br></br>
                        <button className="btn btn-link text-input" style={{color:"black"}} onClick={()=> this.addItemSwitch()}>Add new item</button>
                </div>
            </div>
        )
    }
}
export default ShowInventory