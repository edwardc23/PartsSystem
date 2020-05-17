import React, {Component} from 'react'
import {Formik, Form, Field} from 'formik'
//import ControllerDataService from 'C:\Users\sterl\Documents\GitRepos\PartsSystem\React\react_parts_inv\src\services-HTTP\ControllerDataServices.js'
import ControllerDataServices from '../../services-HTTP/ControllerDataServices'

class Inventory extends Component {
    constructor(props){
        super(props)
        this.state = {
            id: this.props.match.params.id,
            partName: this.props.match.params.name,
            location: this.props.match.params.location,
            make: this.props.match.params.make,
            model: this.props.match.params.model,
            year: this.props.match.params.year,
            msrp: this.props.match.params.msrp,
            price: this.props.match.params.price
        }
        this.onSubmit = this.onSubmit.bind(this)
    }

    onSubmit(vals){
        let item = {
            id: this.state.id,
            partName: vals.partName,
            location: vals.location,
            make: vals.make,
            model: vals.model,
            year: vals.year,
            msrp: vals.msrp,
            price: vals.price
        }
        ControllerDataServices.updateItem(item)
        .then(() => this.props.history.push(`/inventory`))
    }
    render(){
        let{id, partName, location, make, model, year, msrp, price} = this.state
        return(
            <div  className='jumbotron table'>
                <h2>Update Part</h2> <br></br> <br></br>
                <Formik
                        initialValues={{id, partName, location, make, model, year, msrp, price}}
                        onSubmit={this.onSubmit}
                        enableReinitialize={true} //wtf?
                    >
                        {
                            (props) => (
                                <Form>
                                    <fieldset className="form-group">
                                        <label>ID</label>
                                        <Field className="form-control text-input" type="text" name="id" disabled />
                                    </fieldset>
                                    <fieldset>
                                        <label>Name</label>
                                        <Field className="form-control text-input" type="text" name="partName" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Location</label>
                                        <Field className="form-control text-input" type="text" name="location" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Make</label>
                                        <Field className="form-control text-input" type="text" name="make" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Model</label>
                                        <Field className="form-control text-input" type="text" name="model" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Model Year</label>
                                        <Field className="form-control text-input" type="text" name="year" />
                                    </fieldset>
                                    <fieldset>
                                        <label>MSRP</label>
                                        <Field className="form-control text-input" type="text" name="msrp" />
                                    </fieldset>
                                    <fieldset>
                                        <label>Price</label>
                                        <Field className="form-control text-input" type="text" name="price" />
                                    </fieldset>
                                    <br></br>
                                    <br></br>
                                    <button className="btn btn-link text-input" style={{color:"black"}} type="submit">Save</button>
                                </Form>
                            )
                        } 
                    </Formik>
            </div>
        )
    }
}
export default Inventory