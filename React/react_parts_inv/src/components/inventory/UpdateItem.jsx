<<<<<<< HEAD
import React, {Componenet} from 'react'
import {Formik, Form, Field} from 'formik'
import ControllerDataService from 'C:\Users\sterl\Documents\GitRepos\PartsSystem\React\react_parts_inv\src\services-HTTP\ControllerDataServices.js'

class Inventory extends Componenet {
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
            price: '',
        }
        this.onSubmit = this.onSubmit.bind(this)
    }

    onSubmit(vals){
        let Inventory = {
            
        }
    }
}
=======
import React, {Componenet} from 'react'
import {Formik, Form, Field} from 'formik'
import ControllerDataService from 'C:\Users\sterl\Documents\GitRepos\PartsSystem\React\react_parts_inv\src\services-HTTP\ControllerDataServices.js'
import ControllerDataServices from '../../services-HTTP/ControllerDataServices'

class Inventory extends Componenet {
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
        let Inventory = {
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
    }
    render(){
        return(
            <div>

            </div>
        )
    }

}
>>>>>>> Srat
export default Inventory