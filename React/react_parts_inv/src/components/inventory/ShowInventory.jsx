import React from 'react'
import { Component } from 'react';
import ControllerDataServices from '../../services-HTTP/ControllerDataServices';

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
        ControllerDataServices.wipeInventory
        .then(
            response =>{
                this.displayInventory();
                //this.props.history.push(`/inventory}`)
            }
        )

    } //end clearInventory()

    addItemSwitch(){
        console.log('Add item button clicked')
        this.add()
       }//end addItemSwitch()

    updateItemSwitch(){
        console.log('Update button clicked')
        .then(
            this.props.history.push(`/UpdateItem`)
        )
    } //end updateItemSwitch()

    displayInventory(){
        console.log('Displaying inventory')
        ControllerDataServices.listInventory()
        .then(
            response => {
                this.setState({inventory: response.data})
            }
        )
        //this.props.history.push(`/inventory}`)
    } //end displayInventory()

    render(){
        return(
            <div className="table-bordered">
                <thead>
                    <tr style={{textAlign: "center"}}>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Location</th>
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
                                <td>{inventory.id}</td>
                                <td>{inventory.name}</td>
                                <td>{inventory.location}</td>
                                <td>{inventory.model}</td>
                                <td>{inventory.modelYear}</td>
                                <td>{inventory.MSRP}</td>
                                <td>{inventory.price}</td>
                                <td><button className="btn btn-warning" onClick={()=> this.deleteItem(inventory.id)}>Delete item</button></td>
                                <td><button className="btn btn-success" onClick={()=> this.updateItemSwitch()}>Update existing item</button></td>
                                <td><button className="btn btn-warning" onClick={()=> this.wipeInventory()}>Cleaned Inventory</button></td>
                                <td><button className="btn btn-success" onClick={()=> this.addItemSwitch()}>Add new item</button></td>
                               
                            </tr>
                        )
                    }
                </tbody>
            </div>
        )
    }
}
export default ShowInventory