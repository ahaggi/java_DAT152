"use strict";

/**
 * <p>This is the application controller, and method "run" is the main method of the application.</p>
 * 
 * <p>The global object should not be cluttered with functions and variables of the application.</p>
 * <ul>
 * <li>One common approach is to namespace the application code in an object.</li>
 * <li>With JS6, code can be removed from the global scope by encapsulating the code in a "{}" construct.</li>
 * <li>Also the new class construct construct can be used to encapsulate code and remove it from the global scope.</li>
 * </ul>
 * 
 * <p>In this application, I encapsulate the application code by creating an AppController class. This will give two global
 * structures, the class itself, and the instance of AppController that is used to run the code.</p>
 * 
 * <p>If the code had been encapsulated in a global object, only one global variable is needed. I prefer the class construct
 * though. It does introduce some overhead compared to the other approaches, but the approach is more modern and more readable.</p> 
 * 
 * @author Bjarte Kileng
 */
class AppController {
    
    /**
     * @param {String} container - The HTML id attribute of the HTML element with the UI that should be handled by AppController.
     */
    constructor(container) {
        /** @private {String} */ this.container = container

        /** @private {AjaxPeriodic} */ this.ajaxperiodic = new AjaxPeriodic("../Mservices/data" + "/updates")
        this.ajaxperiodic.getPathArray = this.getLogId.bind(this)
        this.ajaxperiodic.dataReceived = this.updatesReceived.bind(this)

        /** @private {AjaxConnection} */ this.ajaxDeleteMember = new AjaxConnection("../Mservices/data"  + "/member")
        this.ajaxDeleteMember.onsuccess = this.memberDeleted.bind(this)
        
        /** @private {Number} */ this.logId = -1
    }

    /**
     * <p>The main method of the application. It must be run after the HTML pages has finished loading, and is the only
     * method to run when starting the application.</p>
     * 
     * <p>The method assumes that HTML elements exists inside the container with the following class attributes:</p>
     * <ul>
     * <dt>memberlist<dt><dd>The HTML element where the list of people should be displayed.</dd>
     * <dt>memberadd</dt><dd>The button that is used when adding a person to the member list</dd>
     * <dt>memberbox</dt><dd>The modal box for adding or updating data for a person. </dd>
     * </dl>
     * <p>HTML elements with the following class attributes are optional:
     * <dl>
     * <dt>stop</dt><dd>A button that can be used for stopping the periodic fetching of data</dd>
     * <dt>start</dt><dd>If stopped, this button will restart the periodic fetching of data</dd>
     * </dl>
     * 
     * @public
     * @param {String} container - The HTML id attribute of the HTML element with the UI that should be handled by AppController.
     */
    run() {
        const container = document.getElementById(this.container)
        const memberlistdiv = container.getElementsByClassName("memberlist")[0]        
        const membermodaleboxdiv = container.getElementsByClassName("memberbox")[0]
        /* The buttons */
        const memberaddbutton = container.getElementsByClassName("memberadd")[0]
        memberaddbutton.addEventListener("click",this.addMember.bind(this),true)
        
        /** @private {UIHandler} */ this.ui = new UIHandler()
        this.ui.deleteMemberCallback = this.deleteMember.bind(this)
        this.ui.editMemberCallback = this.editMember.bind(this)
        memberlistdiv.appendChild(this.ui.memberlist)
        
        /** @private {MemberBox} */ this.memberbox = new MemberBox(membermodaleboxdiv)
        this.memberbox.onsubmit = this.sendData.bind(this)

        this.ajaxperiodic.start()
    }

    /**
     * Callback to UIHandler when a Delete button is clicked
     * @private
     * @param {Number} id - The id attribute of the person
     */
    deleteMember(id) {
        this.ajaxperiodic.stop()
        this.ajaxDeleteMember.del([id])
    }

    /**
     * Callback to AjaxConnection that should be run at server response on request to remove a member from the server database. 
     * @private
     * @param {String} jsontext - The JSON response string from the server
     * @return {Boolean}        - True if response was OK
     */
    memberDeleted(jsontext) {
        const res = JSON.parse(jsontext)
        if (! res.status) {
            console.log("Server problem")
            return false
        }
        this.ajaxperiodic.start()
        return true
    }

    /**
     * Event handler to run when the "Add member" buttons is clicked
     * @private
     */
    addMember() {
        this.memberbox.show()
    }
   
    /**
     * Callback to UIHandler when an Edit button is clicked
     * @private
     * @param {Number} id - The id attribute of the person
     */
    editMember(id) {
    	// Method to run when a Edit button is clicked
    	const member = this.ui.getMember(id)
        this.memberbox.show(member)
    }
    
    /**
     * Callback to AjaxConnection that should be run at server response on request to update a member in the server database.
     * @private
     * @param {String} jsontext - The JSON response string from the server
     * @return {Boolean}        - True if response was OK
     */
    memberUpdated(jsontext) {
        const res = JSON.parse(jsontext)
        if (! res.status) {
            console.log("Server problem")
            return false
        }
        this.ajaxperiodic.start()
        this.memberbox.close()
        return true
    }

    /**
     * Callback to MemberBox when the "Add member" button is clicked. Will send an Ajax request till the server with data of a person.
     * On invalid person data, the request is aborted.
     * @private
     * @param {Object} member - Object with person data that should be sent to the server
     * @return {Boolean}      - True if request was sent
     */
    sendData(member) {
        const firstnamevalidator = new Validator(member.firstname,/^[A-ZÆØÅ][a-zæøå]+(?:\s+[A-ZÆØÅ][a-zæøå]+)*$/)
        if (! firstnamevalidator.isValid) {
            window.alert("Wrong format of first name")
            return false
        }
        
        const lastnamevalidator = new Validator(member.lastname,/^[A-ZÆØÅ][a-zæøå]+$/)
        if (! lastnamevalidator.isValid) {
            window.alert("Wrong format of last name")
            return false
        }

        const addressvalidator = new Validator(member.address,/^[A-ZÆØÅ]/)
        if (! addressvalidator.isValid) {
            window.alert("Wrong format of address")
            return false
        }

        const phonevalidator = new Validator(member.phone,/^(?:[0-9]\s*){7,}[0-9]$/i)
        if (! phonevalidator.isValid) {
            window.alert("Wrong format of phone number")
            return false
        }
 
        const ajax = new AjaxConnection("../Mservices/data" + "/member")
        ajax.onsuccess = this.memberUpdated.bind(this)
        
        this.ajaxperiodic.stop()
        if (member.id == 0) {
        	/* New member */
            ajax.post(null,member)          
        } else {
        	/* Updated member */
            ajax.put([member.id],member)
        }
        return true
    }
    
    /**
     * Callback to AjaxPeriodic that should be run at server response on request for changes in the member database.
     * @private
     * @param {String} jsontext - The JSON response string from the server
     * @return {Boolean}        - True if response was OK
     */
    updatesReceived(jsontext) {
    	// Method to run at Ajax respons when requesting updates from the server
        const updates = JSON.parse(jsontext)
        if (! updates.status) return false

        this.logId = updates.logId

        if (typeof updates.deletedMembers  != "undefined") {
            let deletedMembers = updates.deletedMembers
            if (! (deletedMembers instanceof Array)) {
                deletedMembers = [deletedMembers]
            }
            deletedMembers.forEach((id) => {this.ui.deleteMember(id)})
        }

        if (typeof updates.updatedMembers  != "undefined") {
            let updatedMembers = updates.updatedMembers
            if (! (updates.updatedMembers instanceof Array)) {
                updatedMembers = [updatedMembers]
            }
            updatedMembers.forEach((member) => {this.ui.editMember(member)})
        }

        if (typeof updates.newMembers != "undefined") {
            let newMembers = updates.newMembers
            if (! (updates.newMembers instanceof Array)) {
                newMembers = [newMembers]
            }
            newMembers.forEach((member) => {this.ui.addMember(member)})
        }
        return true
    }
    
    /**
     * Callback to AjaxPeriodic for fetching the path array to use with the Ajax request for changes in the server database
     * @private
     * @return {Array} - The path Array that should be used to extend the Ajax request URL
     */
    getLogId() {
    	// Method that AjaxPeriodic must use when fetching the path array to use with the Ajax request for updates
        return [this.logId]
    }    
}
