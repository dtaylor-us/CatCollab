//INIT
var app = angular.module('contactModule', [])
    .service('contactService', contactService)
    .controller('contactController', contactController);

//SERVICE

function contactService($http) {

    var url = "http://localhost:8090/api/messages/";

    this.getAll = function() {
        return $http.get(url)
            .then(function (response) {
                return response.data;
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
}