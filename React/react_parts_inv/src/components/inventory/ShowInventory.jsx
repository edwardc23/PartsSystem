import React from 'react'
import { Component } from 'react';
import ControllerDataServices from '../../services-HTTP/ControllerDataServices';

class ShowInventory extends Component {
    constructor(props){
        super(props)
        this.state = {
            inventory: [],
            msg: null
            //msg: console.log(null)
        }
        this.displayInventory = this.displayInventory.bind(this)
        this.deleteItem = this.deleteItem.bind(this)
        this.clearInventory = this.clearInventory.bind(this)
    }

    componentDidMount(){
        this.displayInventory();
    } //end componentDidMount

    deleteItem(){
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
            }
        )

    } //end clearInventory()

    displayInventory(){
        console.log('Displaying inventory')
        ControllerDataServices.listInventory()
        .then(
            response => {
                this.setState({inventory: response.data})
            }
        )
    } //end displayInventory()

    render(){
        return(
            <div>

            </div>
        )
    }
}
export default ShowInventory