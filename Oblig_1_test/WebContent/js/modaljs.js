"use strict";

class Modal {
	constructor() {
		let modal = document.getElementById('myModal');
		let span = document.getElementsByClassName("close")[0];
		
		window.addEventListener("click", function(e) {
			if (e.target == modal) {
				modal.style.display = "none";
			}
		}, true)
		
		span.addEventListener("click", function(e) {
			modal.style.display = "none";
		}, true)
	}

	//set callback for update button
	set onsubmit(callback) {
		let updateButton = document.getElementById("updateMember");
		updateButton.addEventListener("click", () => callback(this.member), true);
	}

	//set callback for add button
	set onsubmitAdd(callback) {
		let addButton = document.getElementById("addMemberModal");
		addButton.addEventListener("click", () => callback(this.member), true);
	}

	//get member from the modal
	get member() {
		let id = document.getElementById("modalId");
		let fname = document.getElementById("modalFName");
		let lname = document.getElementById("modalLName");
		let address = document.getElementById("modalAddress");
		let phone = document.getElementById("modalPhone");
		return {
			"id" : id.value,
			"firstname" : fname.value,
			"lastname" : lname.value,
			"address" : address.value,
			"phone" : phone.value
		}
	}

	//Insert member into the modal(edit member)
	show(member) {
		let id = document.getElementById("modalId");
		id.value = member.id;
		let fname = document.getElementById("modalFName");
		fname.value = member.firstname;
		let lname = document.getElementById("modalLName");
		lname.value = member.lastname;
		let address = document.getElementById("modalAddress");
		address.value = member.address;
		let phone = document.getElementById("modalPhone");
		phone.value = member.phone;
		
		let modal = document.getElementById('myModal');
		modal.style.display = "block";

		let addButton = document.getElementById("addMemberModal");
		let updateButton = document.getElementById("updateMember");
		let modalH2 = document.getElementById("modalH2");

		addButton.style.display = "none";
		updateButton.style.display = "block";
		modalH2.textContent = "Edit Member";
	}

	//Clean the modal(add member)
	showNew() {
		let id = document.getElementById("modalId");
		id.value = "";
		let fname = document.getElementById("modalFName");
		fname.value = "";
		let lname = document.getElementById("modalLName");
		lname.value = "";
		let address = document.getElementById("modalAddress");
		address.value = "";
		let phone = document.getElementById("modalPhone");
		phone.value = "";
			
		let modal = document.getElementById('myModal');
		modal.style.display = "block";

		let addButton = document.getElementById("addMemberModal");
		let updateButton = document.getElementById("updateMember");
		let modalH2 = document.getElementById("modalH2");

		addButton.style.display = "block";
		updateButton.style.display = "none";
		modalH2.textContent = "Add member";
	}
	
	//Hide the modal
	hideModal() {
		let modal = document.getElementById('myModal');
		modal.style.display = "none";
	}
}