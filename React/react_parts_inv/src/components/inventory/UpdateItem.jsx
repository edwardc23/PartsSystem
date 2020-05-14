import React, {Component} from 'react'
import {Formik, Form, Field} from 'formik'
//import ControllerDataService from 'C:\Users\sterl\Documents\GitRepos\PartsSystem\React\react_parts_inv\src\services-HTTP\ControllerDataServices.js'
import ControllerDataServices from '../../services-HTTP/ControllerDataServices'

class Inventory extends Component {
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
        this.onSubmit = this.onSubmit.bind(this)
    }

    onSubmit(vals){
        let item = {
            id: this.state.id,
            name: vals.name,
            location: vals.location,
            make: vals.make,
            model: vals.model,
            modelYear: vals.modelYear,
            MSRP: vals.MSRP,
            price: vals.price
        }
        ControllerDataServices.updateItem(item)
        .then(() => this.props.history.push(`/inventory`))
    }
    render(){
        let{id, name, location, make, model, modelYear, MSRP, price} = this.state
        return(
            <div>
                <h2>Update Employee</h2>
                <Formik
                        initVals={{id, name, location, make, model, modelYear, MSRP, price}}
                        onSubmit={this.onSubmit}
                        enableReinitialize={true} //wtf?
                    >
                        {
                            (props) => (
                                <Form>
                                    <fieldset className="form-group">
                                        <label>ID</label>
                                        <Field className="form-control" type="text" name="id" disabled />
                                    </fieldset>
                                    <fieldset>
                                        <label>Name</label>
                                        <Field className="form-control" type="text" name="name" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Location</label>
                                        <Field className="form-control" type="text" name="location" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Make</label>
                                        <Field className="form-control" type="text" name="make" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Model</label>
                                        <Field className="form-control" type="text" name="model" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Model Year</label>
                                        <Field className="form-control" type="text" name="modelYear" />
                                    </fieldset>
                                    <fieldset>
                                        <label>MSRP</label>
                                        <Field className="form-control" type="text" name="MSRP" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Price</label>
                                        <Field className="form-control" type="text" name="price" />
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        } 
                    </Formik>
            </div>
        )
    }
}
export default Inventory