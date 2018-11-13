"use strict";

/**
 * <p>Class construct for handling the modal box when adding or updating data for a person.</p>
 * <p>The modale box is handled, but not created. See the document "memberlist.html" for the HTML of the modal box.</p>
 * 
 * @author Bjarte Kileng
 */

class MemberBox {
    
    /**
     * @param {String} boxelement - The HTML class attribute of the HTML DIV element of the modale box.
     * 
     */
    constructor(boxelement) {
        
        /** @private {String} */ this.box = boxelement
        /** @private {Array} */ this.onsubmitCallbacks = new Array()
        const closeelm = this.box.getElementsByClassName("close")[0]
        closeelm.addEventListener("click",() => {this.box.style.display = "none"},false)
        this.box.getElementsByTagName("button")[0].addEventListener("click",this.doSubmit.bind(this),false)
    }

    /**
     * Opens the modal box to add or edit the data of a person.
     * 
     * If the method is called with a parameter, the parameter is assumed to be data for a person
     * to be edited.
     * 
     * If no argument, the method assumes that a new person should be added.
     * 
     * @public
     * @param {Object} [member] - The person that should be updated
     */
    show (member) {
        const inputs = [...this.box.getElementsByTagName("input")]
        inputs.forEach((input) => {input.value=""})
        if (member instanceof Object) {
            this.box.getElementsByTagName("button")[0].textContent = "Update member"
            let i=0
            for (let p in member) {
               inputs[i++].value = member[p]
            }
        } else {
        	this.box.getElementsByTagName("button")[0].textContent = "Add member"
        }
        this.box.style.display = "block"
        const table = this.box.getElementsByTagName("table")[0]
        const cssTableEffective = document.defaultView.getComputedStyle(table,null)
        const modalewidth = parseInt(document.defaultView.getComputedStyle(table,null).getPropertyValue('width'))
        const closeelm = this.box.getElementsByClassName("close")[0]
        const closeelmwidth = parseInt(document.defaultView.getComputedStyle(closeelm,null).getPropertyValue('width'))
        this.box.getElementsByClassName("modal-content")[0].style.width = `${modalewidth+closeelmwidth+5}px`
    }

    /**
     * Setter that adds a method to run when the button of the modal box is clicked
     * @public
     * @param {Function} method - The method to register
     */
    set onsubmit(method) {
        this.onsubmitCallbacks.push(method)
    }

    /**
     * Getter to retrieve the current person data from the input elements in the modal box
     * @public
     * @return {Object}
     */
    get member() {
      let member = {}
      if (this.box.style.display == "block") {
        const inputs = this.box.getElementsByTagName("input")
        member.id = inputs[0].value
        member.firstname = inputs[1].value
        member.lastname = inputs[2].value
        member.address = inputs[3].value
        member.phone = inputs[4].value
      }
      return member
    }

    /**
     * Closes the modal box
     * @public
     */
    close() {
        this.box.style.display = "none"
    }

    /**
     * Event handler that is run when the button of the modal box is clicked
     * @private
     */
    doSubmit() {
      const member = this.member
      this.onsubmitCallbacks.forEach(method => method(member))
    }
}