//INIT
var app = angular.module('contactModule', [])
    .service('contactService', contactService)
    .controller('contactController', contactController);

//SERVICE
function contactService($http) {

    var url = "http://localhost:8090/api/messages/";

    this.getAll = function () {
        return $http.get(url)
            .then(function (response) {
                return response.data;
            });
    };

    this.getByID = function (id) {
        return $http.get(url + id)
            .then(function (response) {
                return response.data;
            })
    };

    this.save = function (data) {
        console.log(data);
        return $http.post(url, data);
    };

    this.delete = function (id) {
        console.log(id);
        return $http.delete(url + id).then(function (response) {
            return response.data
        });
    };

}

//CONTROLLER
function contactController(contactService) {
    var self = this;

    contactService.getAll()
        .then(function (messageList) {
            self.messageList = messageList;
        });

    self.edit = function (id) {
        console.log(id);
        contactService.getByID(id)
            .then(function (message) {
                console.log(message.body);
                self.message = message;

                $('#messageModal').modal('show');
            });
    };

    self.save = function (message) {
        console.log(message);
        contactService.save(message)
            .success(function (body) {
                window.location.reload();
                console.log(body);
            });
    };

    self.delete = function (id) {
        var answer = confirm("Are you sure you want to delete this category?");

        if (answer) {
            contactService.delete(id)
                .then(function (response) {
                    console.log(response);
                    window.location.reload();
                })
        }
    }

}

function openMessageModal() {
    document.getElementById("messageForm").reset();
    $('#messageModal').modal('show')
}