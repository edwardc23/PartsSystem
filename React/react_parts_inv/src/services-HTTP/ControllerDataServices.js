import axios from 'axios'

class ControllerDataServices {
    //UPDATE requests
    updateItem(item){
        return axios.put(`http://localhost:8080/update`,item);
    }
    //________________________________________________________________________
    
    //GET requests
    listInventory(){
        return axios.get(`http://localhost:8080/grabInventory`);
    }
    getItem(itemID){
        return axios.get(`http://localhost:8080/retrieveItem/${itemID}`);
    }
    //__________________________________________________________________________

    //POST requests
    addItem(item){
        return axios.post(`http://localhost:8080/addItem`,item);
    }

    addAdmin(admin){ //for admin component**
        return axios.post(`http://localhost:8080/addAdmin`,admin);
    }

    check(admin){ //for admin component**
        return axios.post(`http://localhost:8080/checkAdmin`,admin)
    }
    //_____________________________________________________________________________

    //DELETE requests
    wipeInventory(){
        return axios.delete(`http://localhost:8080/deleteStockList`);
    }

    deleteItem(itemID){
        return axios.delete(`http://localhost:8080/delete/${itemID}`)
    }
}
export default new ControllerDataServices()