"use strict";

/**
 * <p>Class construct for handling the visual appearance of a list of members (persons) of an organization.</p>
 * 
 * @author Bjarte Kileng
 */
class UIHandler {	
    constructor() {
        /** @private {Array} */ this.deleteCallbacks = new Array()
        /** @private {Array} */ this.editCallbacks = new Array()

        /**
         * The HTML element that displays the list of persons
         * @readonly
         * @member {HTMLElement}
         */
        this.memberlist = document.createElement("table")

        const rowElement = this.memberlist.createTHead().insertRow(-1)
        rowElement.appendChild(document.createElement("th")).textContent = "Firstname"
        rowElement.appendChild(document.createElement("th")).textContent = "Lastname"
        rowElement.appendChild(document.createElement("th")).textContent = "Address"
        rowElement.appendChild(document.createElement("th")).textContent = "Phone"
        for (let i=0; i<2; ++i) {
            rowElement.appendChild(document.createElement("th"))
        }
        const tbodyElement = document.createElement("tbody")        
        this.memberlist.appendChild(tbodyElement)
    }

    /**
     * Method that adds a person to the UI. A person with the id must not already exist.
     * @public
     * @param {Object} member - The new person that should be displayed on the web page
     */
    addMember(member) {
        if (document.getElementById(member.memberId)) {
            console.log(`Member with id ${member.memberId} already exists in the UI.`)
        } else {
            const rowElement = this.memberlist.getElementsByTagName("tbody")[0].insertRow(-1)
            rowElement.insertCell(-1).textContent = member.firstname
            rowElement.insertCell(-1).textContent = member.lastname
            rowElement.insertCell(-1).textContent = member.address
            rowElement.insertCell(-1).textContent = member.phone
            const btDelete = rowElement.insertCell(-1).appendChild(document.createElement("button"))
            const btUpdate = rowElement.insertCell(-1).appendChild(document.createElement("button"))
            rowElement.id = member.memberId

            btDelete.type = "button"
            btDelete.textContent = "Delete"
                btDelete.addEventListener("click",()=>{this.deleteHandler(rowElement.id)},false)
            btUpdate.type = "button"
            btUpdate.textContent = "Edit"
            btUpdate.addEventListener("click",this.editHandler.bind(this),false)
        }
    }

    /**
     * Method that updates data for a person in the UI
     * @public
     * @param {Object} member - Data of the person that should be updated. The id of the person must already exist in the UI.
     */
    editMember(member) {
        const TR = document.getElementById(member.memberId)
        if (TR) {
            const cells = TR.getElementsByTagName("td")
            cells[0].textContent = member.firstname
            cells[1].textContent = member.lastname
            cells[2].textContent = member.address
            cells[3].textContent = member.phone        	
        } else {
            console.log(`Member with id ${member.memberId} does not exist in the UI.`)
        }
    }

    /**
     * Method to remove a person from the UI.
     * @public
     * @param {Number} id - The id attribute of the person
     */
    deleteMember(id) {
        const TR = document.getElementById(id)
        TR.parentNode.removeChild(TR)
    }

    /**
     * Method to get the data for a person from the UI.
     * @public
     * @param {Number} id - The id attribute of the person
     * @return {Object}
     */
    getMember(id) {
        const TR = document.getElementById(id)
        const cells = TR.getElementsByTagName("td")
        return {"id":id,"firstname":cells[0].textContent,"lastname":cells[1].textContent,"address":cells[2].textContent,"phone":cells[3].textContent}
    }

    /**
     * Getter to retrieve the number of persons on display in the UI
     * @public
     * @return {Number}
     */
    get length() {
        return this.memberlist.tBodies[0].rows.length
    }

    /**
     * Setter that adds a method to run when a Delete button is clicked
     * @public
     * @param {Function} method - The method to register
     * 
     * method
     * deleteMember(id) {
        this.ajaxperiodic.stop()
        this.ajaxDeleteMember.del([id])
    	}
     */
    set deleteMemberCallback(method) {
        this.deleteCallbacks.push(method)
        console.log('set deleteMemberCallback'+ this.deleteCallbacks.length)
        console.log( method)
    }

    /**
     * Setter that adds a method to run when an Edit button is clicked
     * @public
     * @param {Function} method - The method to register
     * editMember(id) {
    	// Method to run when a Edit button is clicked
    	const member = this.ui.getMember(id)
        this.memberbox.show(member)
    }
     */
    set editMemberCallback(method) {
        this.editCallbacks.push(method)
    }

    /**
     * Event handler that is run at when a Delete button is clicked
     * @private
     * @param {Event} event - The event object that is generated by the click
     * 
     */
    deleteHandler(id) {
        this.deleteCallbacks.forEach(method => {method(id);})
    }

    /**
     * Event handler to run when an Edit button is clicked
     * @private
     * @param {Event} event - The event object that is generated by the click
     */
    editHandler(event) {
        const TR = event.target.parentNode.parentNode
        const data = TR.id
        this.editCallbacks.forEach(method => {method(data); console.log(data)})
        console.log( 'editHandler' + this.editCallbacks.length)

    }
}
