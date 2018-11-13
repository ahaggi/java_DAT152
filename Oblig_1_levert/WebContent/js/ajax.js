"use strict";

class Ajax {

    constructor(rootPath) {
        this.rootPath = rootPath;
    }

    request(method, url, data = null) {
        return new Promise((resolve, reject) => {
            let httpRequest = new XMLHttpRequest();
            if (!httpRequest) {
                reject(new Error("Unable to create XMLHttpRequest instance."));
            }
            
            httpRequest.open(method, url);
            
            httpRequest.onreadystatechange = () => {
                if (httpRequest.readyState === XMLHttpRequest.DONE) {
                    if (httpRequest.status === 200) {
                        resolve(httpRequest.responseText);
                    } else {
                        reject(new Error('There was a problem with the request.'));
                    }
                }
            };
            
            httpRequest.onerror = (error) => {
            	reject(new Error('An error occured'));
            };

            if (data === null) {
                httpRequest.send();
            } else {
                httpRequest.setRequestHeader("Content-Type", "application/json; charset=utf-8");
                httpRequest.send(JSON.stringify(data));
            }
        });
    }

    getUpdates(logId = -1) {
        return this.request('GET', this.rootPath + '/updates/' + logId);
    }

    addMember(member) {
        return this.request('POST', this.rootPath + '/member/', member);
    }

    updateMember(id, member) {
        return this.request('PUT', this.rootPath + '/member/' + id, member);
    }

    deleteMember(id) {
        return this.request('DELETE', this.rootPath + '/member/' + id);
    }
}

