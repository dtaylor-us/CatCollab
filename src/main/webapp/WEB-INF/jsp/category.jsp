<%@ include file="includes/_header.jsp" %>
<body>

<%@ include file="includes/_nav.jsp" %>

<div class="wrapper spacer-25">
    <div class="col-sm-12">
        <p class="page-header h4 text-center text-primary"> CATEGORIES</p>
    </div>

    <script src="../../resources/js/category.js"></script>

    <%--SIDEBAR--%>
    <%@ include file="includes/_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">

            <%--LIST OF EXISTING ELEMENTS--%>
            <table id="category-table" class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>
    </div>

</div>

<div id="categoryModal" class="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Add New Category</h5>

            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputTitle" class="col-lg-2 control-label">Title</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputTitle" placeholder="Title" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDescription" class="col-lg-2 control-label">Description</label>
                        <div class="col-lg-10">
                            <textarea class="form-control" rows="3" id="inputDescription"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="reset" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveEmployee()">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
