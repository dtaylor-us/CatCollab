<%@ include file="includes/_header.jsp" %>
<body>

<%@ include file="includes/_nav.jsp" %>

<div class="wrapper spacer-25">

    <%--SIDEBAR--%>
    <%@ include file="includes/_cat_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10 spacer-50">
        <div class="col-sm-12">

            <%--LIST OF EXISTING ELEMENTS--%>
            <table id="category-table" class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Author</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Category Items</th>
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
                <form id="categoryForm" class="form-horizontal">
                    <input type="hidden" id="categoryID"/>
                    <input type="hidden" id="categoryVersion"/>
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

                <div id="category-messages"><p class='text-warning'></p></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveCategory()">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/init.js"></script>
<script src="../../resources/js/category.js"></script>
<script src="../../resources/js/category-list.js"></script>
<script>
    $(document).ready(function () {
        cat.v.category_list.loadUI();
    });
</script>

</body>
</html>
