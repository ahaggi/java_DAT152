"use strict";

/**
 * <p>Class construct for validating user input.</p>
 * 
 * @author Bjarte Kileng
 */
class Validator {
    
    /**
     * @param {String} data - Data to validate
     * @param {RegExp} reg  - Regular expression used to validate data
     */
    constructor(data,reg) {
        /** @private {String} */ this.data=null
        /** @private {Boolean} */ this.valid = false
        
        if (data.length == 0) {
            return
        }
        
        if (! reg.test(data)) {
            return
        }
        
        this.data = data
        this.valid = true
    }
    
    /**
     * Getter that tells if data is valid
     * @public
     * @return {Boolean}
     */
    get isValid() {return this.valid}
    
    /**
     * Getter that returns valid data
     * @public
     * @return {String}
     */
    get validdata() {return this.data}
}
