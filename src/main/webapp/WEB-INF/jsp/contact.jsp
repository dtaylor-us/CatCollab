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
                    <input type="hidden" id="messageID"/>
                    <input type="hidden" id="messageVersion"/>
                    <input type="hidden" id="inputAuthor" value="${userName}"/>

                    <div class="form-group">
                        <label id="cat-title-label" for="inputTitle" class="col-lg-2 control-label">Title</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputTitle" placeholder="Title" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label id="cat-desc-label" for="inputDescription" class="col-lg-2 control-label">Description</label>
                        <div class="col-lg-10">
                            <textarea class="form-control" rows="3" id="inputDescription"></textarea>
                        </div>
                    </div>
                </form>

                <div id="message-messages"><p class='text-warning'></p></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveMessage()">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/message.js"></script>


</body>
</html>
