(function () {
    $.getJSON("/api/category/", {
        ajax: 'true',
        dataType: 'jsonp'
    }, function (data) {
        $.each(data, function (index, model) {
            var currentUser = document.getElementById('current-user').innerHTML;
            var editButton = "";
            var deleteButton = "";

            if (currentUser === model.author) {
                editButton = "<button class='btn btn-warning flt-rt' onclick='editCategory(" + model.id + ")'>Edit</button>";
                deleteButton = "<button class='btn btn-danger flt-rt' id='deleteButton' onclick='deleteCategory(" + model.id + ")'>Delete</button>";

            }

            $('#category-table').find('tbody')
                .append(
                    "<tr>" +
                    "<td style='vertical-align: middle'>" + model.id + "</td>" +
                    "<td style='vertical-align: middle'>" + model.author + "</td>" +
                    "<td style='vertical-align: middle'>" + model.title + "</td>" +
                    "<td style='vertical-align: middle'>" + model.description + "</td>" +
                    "<td style='vertical-align: middle'>" + editButton + "</td>" +
                    "<td style='vertical-align: middle'>" + deleteButton + "</td>" +
                    "</tr>"
                )
        });
    });
})();

function saveCategory() {
    var title = $('#inputTitle').val();
    var description = $('#inputDescription').val();
    var author = $('#inputAuthor').val();
    var category = {
        id: $('#categoryID').val(),
        version: $('#categoryVersion').val(),
        title: title,
        author: author,
        description: description
    };

    console.log(category);

    $.ajax({
        type: "post",
        data: category,
        url: "/api/category/",
        async: true,
        dataType: "json",
        success: function () {
            window.location.reload();
        }
    });
}

function editCategory(id) {
    $.getJSON('/api/category/' + id, {
        ajax: 'true'
    }, function (category) {
        console.log(category);
        $('#categoryID').val(category.id);
        $('#inputAuthor').val(category.author);
        $('#categoryVersion').val(category.version);
        $('#inputTitle').val(category.title);
        $('#inputDescription').val(category.description);
    });
    $("#categoryModal").modal('show');
}

function openCategoryModal() {
    document.getElementById("categoryForm").reset();
    $('#categoryModal').modal('show')
}

function deleteCategory(id) {

    $.ajax({
        type: 'delete',
        url: '/api/category/' + id,
        async: true,
        dataType: "json",
        success: function () {
            window.location.reload();
        },
        error: function () {
            alert("Delete was unsuccessful");
        }
    });

}