<<<<<<< HEAD
import axios from 'axios'

class ControllerDataServices {
    //UPDATE requests
    updateItem(){
        return axios.put(`http://localhost:8080/update`);
    }
    //________________________________________________________________________
    
    //GET requests
    listInventory(){
        return axios.get(`http://localhost:8080/grabInventory`);
    }
    getItem(){
        return axios.get(`http://localhost:8080/retrieveItem/${itemID}`);
    }
    //__________________________________________________________________________

    //POST requests
    addItem(){
        return axios.post(`http://localhost:8080/addItem`);
    }

    addAdmin(){
        return axios.post(`http://localhost:8080/addAdmin`);
    }

    check(){
        return axios.post(`http://localhost:8080/checkAdmin`)
    }
    //_____________________________________________________________________________

    //DELETE requests
    wipeInventory(){
        return axios.delete(`http://localhost:8080/deleteStockList`);
    }

    deleteItem(){
        return axios.delete(`http://localhost:8080/delete/${itemID}`)
    }
}
=======
import axios from 'axios'

class ControllerDataServices {
    //UPDATE requests
    updateItem(){
        return axios.put(`http://localhost:8080/update`);
    }
    //________________________________________________________________________
    
    //GET requests
    listInventory(){
        return axios.get(`http://localhost:8080/grabInventory`);
    }
    getItem(){
        return axios.get(`http://localhost:8080/retrieveItem/${itemID}`);
    }
    //__________________________________________________________________________

    //POST requests
    addItem(){
        return axios.post(`http://localhost:8080/addItem`);
    }

    addAdmin(){ //for admin component**
        return axios.post(`http://localhost:8080/addAdmin`);
    }

    check(){ //for admin component**
        return axios.post(`http://localhost:8080/checkAdmin`)
    }
    //_____________________________________________________________________________

    //DELETE requests
    wipeInventory(){
        return axios.delete(`http://localhost:8080/deleteStockList`);
    }

    deleteItem(){
        return axios.delete(`http://localhost:8080/delete/${itemID}`)
    }
}
>>>>>>> Srat
export default new ControllerDataServices()