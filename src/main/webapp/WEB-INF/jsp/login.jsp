
<%@ include file="includes/_header.jsp" %>

<body>
<h2><a href="/logout">Logout</a></h2>

<div class="container spacer-100">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="text-white panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body spacer-10">
                    <form role="form" action="<c:url value='/login.do'/>" method="post">
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
                            <input type="submit" value="login" name="submit" class="btn btn-primary btn-full center">
                        </fieldset>
                    </form>

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
</div
</body>
</html>
