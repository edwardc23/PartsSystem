import React from 'react'
import {Component} from 'react'
import ControllerDataServices from '../../services-HTTP/ControllerDataServices'

class Item extends Component {
    constructor(props){
        super(props)
        this.state = {
            id: this.props.match.params.id,
            name: '',
            location: '',
            make: '',
            model: '',
            modelYear:'',
            MSRP:'',
            price: ''
        }
        //handles go here
    }

    addItem(){
        let item = {
            id: this.state.id,
            name: this.name.name,
            location: this.state.location,
            make: this.state.make,
            model: this.state.model,
            modelYear: this.state.modelYear,
            MSRP: this.state.MSRP,
            price: this.state.price
        }
        ControllerDataServices.addItem(item)
    }

    render(){
        return(
            <div>

            </div>
        )
    }
}
