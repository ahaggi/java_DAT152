"use strict";

/**
 * <p>Class construct for handling periodic Ajax requests. After a successful request, the request will
 * be repeated with a delay given in seconds by the member sleep.</p>
 * 
 * <p>If member getPathArray is a method, it will be run on each response. The return value must be a string
 * that will be appended to the Ajax URL.</p>
 * 
 * <p>If member getData is a method, it will be run on each response. The return value must be an Object
 * that will be sent with the Ajax request.</p>
 *
 * <p>If member dataReceived is a method, it will be run at each successful server response
 * with the received data as input.</p>
 * 
 * @author Bjarte Kileng
 */

class AjaxPeriodic {

    /**
     * @param {String} url - The URL of the Ajax connection.
     */
    constructor(url) {
        /**
         * Method to run at each request to extend the Ajax URL
         * @function
         */
        this.getPathArray = null

        /**
         * Delay between Ajax requests
         * @member {Number}
         * @default
         */
        this.sleep = 4000

        /**
         * Method to run at each request to produce data that is sent with the request
         * @function
         */
        this.getData = null

        /**
         * Method to run at server response
         * @function
         */
        this.dataReceived = null

        /** @private {Function} */ this.ajax = new AjaxConnection(url)
        /** @private */ this.timer = null

        this.ajax.onsuccess = this.dataFromServer.bind(this)
    }

    /**
     * Starts the periodic Ajax requests to server
     * @public
     */
    start() {
        if (this.timer != null) {
            console.log("Timer is already started. Ignoring")
            return
        }
        console.info('[AjaxPeriodic' + new Date() + '] Starting periodic fetching of data')
        this.doRequest()
    }
    
    /**
     * Stops the periodic Ajax requests to server
     * @public
     */
    stop() {
        if (this.timer == null) {
            console.log("Timer is not started. Ignoring")
            return
        }
        console.info('[AjaxPeriodic' + new Date() + '] Cancelling periodic fetching of data')
        window.clearTimeout(this.timer)
        this.timer = null
    }

    /**
     * Sending request to server
     * @privat
     */
    doRequest() {
        let data = null
        let pathArray = null
        if (typeof this.getData == "function") {
            data = this.getData()
        }
        if (typeof this.getPathArray == "function") {
            pathArray = this.getPathArray()
        }
        console.info('[AjaxPeriodic' + new Date() + '] Sending data')
        this.ajax.get(pathArray,data)
    }

    /**
     * Event handler that is run at server response.
     * @private
     * @param {String} response  - The response data from server
     */
    dataFromServer(response) {
        if (! this.dataReceived) return
        if (! this.dataReceived(response)) return
        this.timer = window.setTimeout(this.doRequest.bind(this),this.sleep)
    }
}
