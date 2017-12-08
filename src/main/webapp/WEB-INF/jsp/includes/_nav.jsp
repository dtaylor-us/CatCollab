<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">THOUGHT<span class="text-primary">BOX</span></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--<li class="dropdown">--%>
                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown"--%>
                <%--title=""> <i--%>
                <%--class="fa fa-navitem fa-lg fa-comment"></i> What's New? <b class="caret"></b></a>--%>
                <%--</li>--%>
                <li>
                    <a href="/category" title=""><i
                            class="fa fa-navitem fa-lg fa-tag"></i> Categories </a>
                </li>
                <li>
                    <a href="/item" title=""><i
                            class="fa fa-navitem fa-lg fa-cube"></i> Items</a>
                </li>
                <li>
                    <a href="/contact" title=""><i
                            class="fa fa-navitem fa-lg fa-envelope"></i> Contact </a>
                </li>                <li>
                    <i class="fa fa-navitem fa-lg fa-envelope"></i> <%@ include file="./_image_upload.jsp" %>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" title=""><span id="current-user"
                                                                                              class="text-success">${userName}</span>
                        <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="/logout"> Log-Out</a>
                        </li>
                        <%--<li>--%>
                        <%--<a href="/customer"> User</a>--%>
                        <%--</li>--%>
                    </ul>
                </li>
                <li>
                    <a href="#" data-toggle="modal" data-target="#searchModal"><i class="fa fa-fw fa-search"></i>
                        <span class="hidden-lg hidden-md hidden-sm">Search</span></a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
