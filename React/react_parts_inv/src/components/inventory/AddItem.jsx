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

    handleChange(event){
        this.setState({
            [event.target.name]: event.target.value
        })
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
        .then(this.props.history.push(`/inventory`))
    }

    render(){
        return(
            <div>
                <h2>Add Item</h2>
                <div>
                    <form onSubmit={this.addItem}>
                            <div className="form-group">
                                <label>ID:</label>
                                <input className="form-control" type="text" value={this.state.id} disabled></input>
                            </div>
                            <div>
                                <label>Name:</label>
                                <input className="form-control" type="text" name="name" onChange={this.handleChange}></input>
                            </div>
                            <div>
                                <label>Location:</label>
                                <input className="form-control" type="text" name="location" onChange={this.handleChange}></input>
                            </div>       
                            <div>
                                <label>Make:</label>
                                <input className="form-control" type="text" name="make" onChange={this.handleChange}></input>
                            </div>      
                            <div>
                                <label>Model:</label>
                                <input className="form-control" type="text" name="model" onChange={this.handleChange}></input>
                            </div>
                            <div>
                                <label>Model Year:</label>
                                <input className="form-control" type="text" name="modelYear" onChange={this.handleChange}></input>
                            </div>
                            <div>
                                <label>MSRP:</label>
                                <input className="form-control" type="text" name="MSRP" onChange={this.handleChange}></input>
                            </div>
                            <div>
                                <label>Price:</label>
                                <input className="form-control" type="text" name="price" onChange={this.handleChange}></input>
                            </div>
                            <br/><br/>
                            <button className="btn btn-success" type="submit">Submit</button><br/><br/>
                        </form>
                </div>
            </div>
        )
    }
}
export default Item
