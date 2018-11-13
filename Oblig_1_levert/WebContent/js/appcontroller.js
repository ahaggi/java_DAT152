"use strict";

class AppController {
	constructor(memberlist) {
		this._memberlistElement = document.getElementById(memberlist);
		
		this._ui = new UIHandler();
		this._memberlistElement.appendChild(this._ui.memberlist);
		
		this._logId = -1;
		this._ajax = new Ajax('../Mservices/data');
		
		this._modal = new Modal();
		
		//When the Add member button is pushed
		this._ui.addMemberCallback = () => {
			this._modal.showNew();
		};

		//When the Add member button in the modal is pushed
		this._modal.onsubmitAdd = (member) => {
			this._ajax.addMember(member).then(this.update.bind(this)).catch((error) => {
				console.log("Error deleting member: ", error);
			});
			this._modal.hideModal();
		};

		//When the Update member button in the modal is pushed
		this._modal.onsubmit = (member) => {
			this._ajax.updateMember(member.id, member).then(this.update.bind(this)).catch((error) => {
				console.log("Error deleting member: ", error);
			});
			this._modal.hideModal();
		};
		
		this._deleteMemberCallbackFunction = (id) => {
			const doDelete = window.confirm(`Do you really want to delete member with id ${id}?`);
			if (doDelete) {
				this._ajax.deleteMember(parseInt(id)).then(this.update.bind(this)).catch((error) => {
					window.alert(`Error deleting member with id: ${id}.`);
				});
			} else {
			}
		};
		
		this._editMemberCallbackFunction = (id) => {
			this._modal.show(this._ui.getMember(id));
		};
		
		
		// start looking for updates.
		this.lookForUpdates.call(this);
	}

	//Look for updates on the server every 3 seconds
	lookForUpdates() {
		this.update();
		setTimeout(this.lookForUpdates.bind(this), 3000);
	}
	
	//get updates and update the HTML table.
	update() {
		this._ajax.getUpdates(this._logId).then((json) => {
			const object = JSON.parse(json);

			for (let i in object.newMembers) {
				this._ui.addMember(object.newMembers[i]);
			}

			for (let i in object.updatedMembers) {
				this._ui.editMember(object.updatedMembers[i]);
			}

			for (let i in object.deletedMembers) {
				this._ui.deleteMember(object.deletedMembers[i]);
			}

			// update logId.
			this._logId = object.logId;

			// update callback functions.
			this._ui.deleteMemberCallback = this._deleteMemberCallbackFunction.bind(this);
			this._ui.editMemberCallback = this._editMemberCallbackFunction.bind(this);
			
		}).catch((error) => {
			console.log(error);
		});
	}
}

document.addEventListener('DOMContentLoaded', () => {
	const app = new AppController("memberlist");
}, true);