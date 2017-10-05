<%@ include file="includes/_header.jsp" %>
<body>

<%@ include file="includes/_nav.jsp" %>

<div class="wrapper spacer-25">


    <%--SIDEBAR--%>
    <%@ include file="includes/_item_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10 spacer-50">

        <div class="col-sm-12">
            <input type="hidden" id="selected-category">
            <div id="parent-category-title">

            </div>
            <table id="item-table" class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Author</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>
    </div>
    <div id="category-item-messages" class="text-center"></div>
</div>

<div id="itemModal" class="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Add New Item</h5>
            </div>
            <div class="modal-body">
                <form id="categoryForm" class="form-horizontal">
                    <input type="hidden" id="itemID"/>
                    <input type="hidden" id="itemVersion"/>
                    <input type="hidden" id="inputAuthor" value="${userName}"/>

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
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveItem()">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/view/category-items.js"></script>
</body>
</html>
