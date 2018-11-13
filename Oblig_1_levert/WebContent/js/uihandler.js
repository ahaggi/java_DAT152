"use strict";

class UIHandler {
	constructor() {
		let table = document.createElement("table");
		table.id = "memberTable";
		let tbody = document.createElement("tbody");
		tbody.id = "memberTableBody";
		let row = document.createElement("tr");
		let th1 = document.createElement("th");
		let th2 = document.createElement("th");
		let th3 = document.createElement("th");
		let th4 = document.createElement("th");
		let text1 = document.createTextNode("Firstname");
		let text2 = document.createTextNode("Lastname");
		let text3 = document.createTextNode("Address");
		let text4 = document.createTextNode("Phone");

		th1.appendChild(text1);
		th2.appendChild(text2);
		th3.appendChild(text3);
		th4.appendChild(text4);

		row.appendChild(th1);
		row.appendChild(th2);
		row.appendChild(th3);
		row.appendChild(th4);

		table.appendChild(row);
		table.appendChild(tbody);

		this.getTable = () => {
			return table;
		}

	}

	get memberlist() {
		return this.getTable();
	}

	//Add member to the HTML table
	addMember(member) {
		let table = document.getElementById("memberTable");
		let tbody = document.getElementById("memberTableBody");
		let row = document.createElement("tr");
		row.id = member.memberId;
		let td1 = document.createElement("td");
		let td2 = document.createElement("td");
		let td3 = document.createElement("td");
		let td4 = document.createElement("td");
		let td5 = document.createElement("td");
		let td6 = document.createElement("td");
		let text1 = document.createTextNode(member.firstname);
		let text2 = document.createTextNode(member.lastname);
		let text3 = document.createTextNode(member.address);
		let text4 = document.createTextNode(member.phone);
		let button1 = document.createElement("button");
		let button2 = document.createElement("button");

		button1.type = "button";
		button2.type = "button";

		button1.textContent = "Delete";
		button2.textContent = "Edit";

		td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		td4.appendChild(text4);
		td5.appendChild(button1);
		td6.appendChild(button2);

		row.appendChild(td1);
		row.appendChild(td2);
		row.appendChild(td3);
		row.appendChild(td4);
		row.appendChild(td5);
		row.appendChild(td6);

		tbody.appendChild(row);
	}

	//get number of member in HTML table
	get length() {
		return document.getElementsByTagName("tr").length - 1;
	}

	//get member by id
	getMember(id) {
		let row = document.getElementById(id);
		return {
			"id" : id,
			"firstname" : row.cells[0].textContent,
			"lastname" : row.cells[1].textContent,
			"address" : row.cells[2].textContent,
			"phone" : row.cells[3].textContent
		}
	}

	//delete member by id
	deleteMember(id) {
		let table = document.getElementById("memberTable");
		let tBody = table.tBodies[0];
		let row = document.getElementById(id);
		tBody.removeChild(row);
	}

	//set callback for delete buttons
	set deleteMemberCallback(method) {
		for (var i = 1; i < document.getElementsByTagName("tr").length; ++i) {
			let row = document.getElementsByTagName("tr")[i];
			let deletebutton = row.getElementsByTagName("button")[0];
			if (deletebutton.id == "") {
				deletebutton.id = "delete" + row.id;
				deletebutton.addEventListener("click", () => method(row.id), true);
			}
		}
	}

	//edit member
	editMember(member) {
		let row = document.getElementById(member.memberId);
		row.cells[0].textContent = member.firstname;
		row.cells[1].textContent = member.lastname;
		row.cells[2].textContent = member.address;
		row.cells[3].textContent = member.phone;
	}

	//set callback for edit buttons
	set editMemberCallback(method) {
		for (var i = 1; i < document.getElementsByTagName("tr").length; ++i) {
			let row = document.getElementsByTagName("tr")[i];
			let editbutton = row.getElementsByTagName("button")[1];
			if (editbutton.id == "") {
				editbutton.id = "edit" + row.id;
				editbutton.addEventListener("click", () => method(row.id), true);
			}
		}
	}

	//set callback for add member button
	set addMemberCallback(method) {
		let button = document.getElementById("addMember");
		button.addEventListener("click", method, true);
	}

}