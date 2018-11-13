"use strict";

/**
 * <p>Class construct for creating an Ajax connection.
 * Supports HTTP GET, POST, PUT and DELETE.</p>
 * 
 * <p>Methods can be given a Array instance as the first argument. The array elements will be added to the URL.
 * Assume the following code:</p>
 * <pre>
 *   const ajax = new AjaxConnection("http://eple.hib.no/myappclication")
 *   ajax.del(['a','b','c'})
 * </pre>
 * <p>The above code will use the following URL for the HTTP delete method:</p>
 * <ul>
 * <li> http://eple.hib.no/myappclication/a/b/c/
 * </ul>
 * 
 * <p>The methods get, post and put take a second argument, an instance of Object that will be sent as
 * data to the server with the request.</p>
 * 
 * @author Bjarte Kileng
 */
class AjaxConnection {

    /**
     * @param {String} url - The URL of the Ajax connection.
     */
    constructor(url){
        /** @private {String} */ this.url = url || null
        
        /**
         * Method to run at successful server response
         * @function
         * @default
         */
        this.onsuccess = () => {console.log("Success")}
        
        /**
         * Method to run if request fails
         * @function
         * @default
         */
        this.onerror = (e) => {console.log(e)}
    }

    /**
     * Sends a HTTP get request to the server
     * @public
     * @param {Array} pathArray - Array elements that will augment the URL
     * @param {Object} data     - Data that will be sent with the request to the server
     */
    get(pathArray,data) {
        let xmlhttprequest = new XMLHttpRequest()

        // If given, add path to the URL.
        let url = this.url + this.convertToPath(pathArray)

        // If given, add GET parameters.
        if (data) url += "?" + this.formatData(data)

        xmlhttprequest.open('GET', url, true)
        xmlhttprequest.addEventListener("loadend",this.dataReceived.bind(this),true)
        if (this.onerror) xmlhttprequest.addEventListener("error",this.onerror.bind(this),true)

        // Sending request
        xmlhttprequest.send(null);
    }

    /**
     * Sends a HTTP delete request to the server
     * @public
     * @param {Array} pathArray - Array elements that will augment the URL
     */

    del(pathArray) {
        let xmlhttprequest = new XMLHttpRequest()

        // If given, add path to the URL.
        let url = this.url + this.convertToPath(pathArray)

        xmlhttprequest.open('DELETE', url, true)

        xmlhttprequest.addEventListener("loadend",this.dataReceived.bind(this),true)
        if (this.onerror) xmlhttprequest.addEventListener("error",this.onerror.bind(this),true)

        // Sending request
        xmlhttprequest.send(null)
    }

    /**
     * Sends a HTTP put request to the server
     * @public
     * @param {Array} pathArray - Array elements that will augment the URL
     * @param {Object} data     - Data that will be sent with the request to the server
     */
    put(pathArray,data) {
        let xmlhttprequest = new XMLHttpRequest()

        // If given, add path to the URL.
        let url = this.url + this.convertToPath(pathArray)

        xmlhttprequest.open('PUT', url, true);

        xmlhttprequest.addEventListener("loadend",this.dataReceived.bind(this),true)
        if (this.onerror) xmlhttprequest.addEventListener("error",this.onerror.bind(this),true)

        // Must specify document type with PUT data
        xmlhttprequest.setRequestHeader("Content-Type","application/json; charset=utf-8")

        // Sending request
        xmlhttprequest.send(JSON.stringify(data))
    }

    /**
     * Sends a HTTP post request to the server
     * @public
     * @param {Array} pathArray - Array elements that will augment the URL
     * @param {Object} data     - Data that will be sent with the request to the server
     */
    post(pathArray,data) {
        let xmlhttprequest = new XMLHttpRequest()

        // If given, add path to the URL.
        let url = this.url + this.convertToPath(pathArray)

        xmlhttprequest.open('POST', url, true);

        xmlhttprequest.addEventListener("loadend",this.dataReceived.bind(this),true)
        if (this.onerror) xmlhttprequest.addEventListener("error",this.onerror.bind(this),true)

        // Must specify document type with POST data
        xmlhttprequest.setRequestHeader("Content-Type","application/json; charset=utf-8")

        // Sending request
        xmlhttprequest.send(JSON.stringify(data));
    }

    /**
     * Event handler that is run at the server response
     * @private
     * @param {Event} e - The event object that is generated at server response
     */
    dataReceived(e) {
        try {
            let xmlhttprequest = e.target // The XMLHttpRequest instance

            if (xmlhttprequest.status == 200) { // Got data
                if (this.onsuccess) this.onsuccess(xmlhttprequest.responseText)
            } else {
                if (this.onerror) this.onerror(e)
            }
        } catch(e) {
            this.onerror(e)
        }
    }

    /**
     * Method that serializes an Object into the URI component format that is used with GET data.
     * @private
     * @param {Object} data - The Object that should be serialized
     * @return {String}     - The URI component serialized representation of the input Object
     */
    formatData(data) {
        let dataString="";
        for (var key in data) {
            dataString += encodeURIComponent(key) + "=" + encodeURIComponent(data[key]) + "&"
        }
        dataString = dataString.substring(0,dataString.length-1)
        return dataString
    }

    /**
     * Method that serializes an Array into an URL path component.
     * @private
     * @param {Array} pathArray - The Array that should be serialized
     * @return {String}         - The URL path component representation of the input Array
     */
    convertToPath(pathArray) {
        let path = ""
        if (pathArray instanceof Array) {
            pathArray.forEach((part) => {path += "/" + part})
        }
        return path;
    }
}