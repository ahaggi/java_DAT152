"use strict";

class AppController {
	constructor(memberlist) {
		this.memberlistElement = document.getElementById(memberlist);
		
		this.ui = new UIHandler();
		this.modal = new Modal();
		
		this.memberlistElement.appendChild(this.ui.memberlist);
		
		this.url = config.servicesPath + "/member";
		this.urlGet = config.servicesPath + "/updates";
		
		//When the Add member button is pushed
		this.ui.addMemberCallback = () => {
			this.modal.showNew();
		};

		//When the Add member button in the modal is pushed
		this.modal.onsubmitAdd = (member) => {
			const ajax = new Ajax(this.url);
			ajax.post(null, member);
			this.modal.hideModal();
		};

		//When the Update member button in the modal is pushed
		this.modal.onsubmit = (member) => {
			const ajax = new Ajax(this.url);
			ajax.put([ member.id ], member);
			this.modal.hideModal();
		};

		this.lookForUpdates.call(this);
	}

	//Look for updates on the server every 3 seconds
	lookForUpdates() {
		let ajax = new Ajax(this.urlGet);
		let logId = document.getElementById("logId").textContent;
		ajax.onsuccess = this.showUpdates.bind(this);
		ajax.get([ logId ]);
		console.log("Looking for updates");
		setTimeout(this.lookForUpdates.bind(this), 3000);
	}

	//Update the HTML table with the updates from the server
	showUpdates(JSONText) {
		const object = JSON.parse(JSONText);

		for (let i in object.newMembers) {
			this.ui.addMember(object.newMembers[i]);
		}

		for (let i in object.updatedMembers) {
			this.ui.editMember(object.updatedMembers[i]);
		}

		for (let i in object.deletedMembers) {
			this.ui.deleteMember(object.deletedMembers[i]);
		}

		document.getElementById("logId").textContent = object.logId;

		this.ui.deleteMemberCallback = (id) => {
			const doDelete = window.confirm(`Do you really want to delete member with id ${id}?`);
			if (doDelete) {
				window.alert(`Member ${id} should be deleted.`);
				const ajax = new Ajax(this.url);
				ajax.del([ id ]);
			} else {
				window.alert(`Member ${id} should not be deleted.`);
			}
		}

		this.ui.editMemberCallback = (id) => {
			this.modal.show(this.ui.getMember(id));
		}

	}
}

document.addEventListener('DOMContentLoaded', () => {
	const app = new AppController("memberlist");
}, true);