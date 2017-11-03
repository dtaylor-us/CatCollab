<%@ include file="includes/_header.jsp" %>
<%@ include file="includes/_nav.jsp" %>

<body>

<div class="container spacer-100">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body spacer-10">
                    <form authority="form" action="<c:url value='/login.do'/>" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Enter User Name..." name="username" type="text"
                                       autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password"
                                       value="">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <div>
                                <input type="submit" value="login" name="submit"
                                       class="btn btn-primary btn-full center">
                            </div>
                        </fieldset>
                    </form>

                    <div>
                        <a href="#" class="btn btn-info center">Register</a>
                    </div>

                    <!-- VALIDATION -->
                    <c:if test="${not empty param.err}">
                        <div class="msg-container error">
                            <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                        </div>
                    </c:if>

                    <c:if test="${not empty param.out}">
                        <div class="msg-container logout">
                            You have logged out SUCCESSFULLY
                        </div>
                    </c:if>

                    <c:if test="${not empty param.time}">
                        <div class="msg-container time">
                            You've been logged out due to inactivity.
                        </div>
                    </c:if>

                </div>
            </div>
        </div>
    </div>
</div>

<div id="userModal" class="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Register a new User!</h5>
            </div>
            <div class="modal-body">
                <form id="userForm" class="form-horizontal">

                    <input ng-model="ctrl.user.id" type="hidden" id="userID"/>
                    <input ng-model="ctrl.user.version" type="hidden" id="userVersion"/>

                    <div class="form-group">
                        <label for="inputSubject" class="col-lg-2 control-label">Subject</label>
                        <div class="col-lg-10">
                            <input ng-model="ctrl.user.subject" class="form-control" id="inputSubject"
                                   placeholder="Subject" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputBody" class="col-lg-2 control-label">Body</label>
                        <div class="col-lg-10">
                            <textarea ng-model="ctrl.user.body" class="form-control" rows="3" id="inputBody"></textarea>
                        </div>
                    </div>
                </form>

                <div id="user-users"><p class='text-warning'></p></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" ng-click="ctrl.save(ctrl.user)">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
