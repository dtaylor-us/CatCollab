<%@ include file="includes/_header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<body ng-app="contactModule" ng-controller="contactController as ctrl">


<%@ include file="includes/_nav.jsp" %>

<div class="wrapper spacer-25">

    <%--SIDEBAR--%>
    <%@ include file="includes/_msg_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10 spacer-50">
        <div class="col-sm-12">
            <h4>Messages</h4>
            <%--LIST OF EXISTING ELEMENTS--%>

            <table id="message-table" class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Author</th>
                    <th>Subject</th>
                    <th>Body</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="message in ctrl.messageList">
                    <td>{{ message.id }}</td>
                    <td>{{ message.username }}</td>
                    <td>{{ message.subject }}</td>
                    <td>{{ message.body }}</td>
                    <td>
                        <button class="btn btn-warning" ng-click='ctrl.edit(message.id)'>Edit</button>
                    </td>
                    <td>
                        <button class="btn btn-danger" ng-click='ctrl.delete(message.id)'>Delete</button>
                    </td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>

</div>

<div id="messageModal" class="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Add New Message</h5>
            </div>
            <div class="modal-body">
                <form id="messageForm" class="form-horizontal">

                    <input ng-model="ctrl.message.id" type="hidden" id="messageID"/>
                    <input ng-model="ctrl.message.version" type="hidden" id="messageVersion"/>
                    <input ng-model="ctrl.message.username" type="hidden" id="inputUsername" value="{{userName}}"/>

                    <div class="form-group">
                        <label for="inputSubject" class="col-lg-2 control-label">Subject</label>
                        <div class="col-lg-10">
                            <input ng-model="ctrl.message.subject" class="form-control" id="inputSubject"
                                   placeholder="Subject" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputBody" class="col-lg-2 control-label">Body</label>
                        <div class="col-lg-10">
                            <textarea ng-model="ctrl.message.body" class="form-control" rows="3" id="inputBody"></textarea>
                        </div>
                    </div>
                </form>

                <div id="message-messages"><p class='text-warning'></p></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" ng-click="ctrl.save(ctrl.message)">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/message.js"></script>


</body>
</html>
