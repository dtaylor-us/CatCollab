(function () {
    localStorage.removeItem('categoryID');

    $.getJSON("/api/category/", {
        ajax: 'true',
        dataType: 'jsonp'
    }, function (data) {

        var rowIndex = 0;

        $.each(data, function (index, model) {
            var categoryID = model.id;
            var currentUser = document.getElementById('current-user').innerHTML;
            var editButton = "";
            var deleteButton = "";

            var indexedRowID = 'category-row' + rowIndex;

            if (currentUser === model.author) {
                editButton = "<button class='btn btn-warning' onclick='editCategory(" + categoryID + ")'>Edit</button>";
                deleteButton = "<button class='btn btn-danger' id='deleteButton' onclick='deleteCategory(" + categoryID + ")'>Delete</button>";
            }

            $('#category-table').find('tbody')
                .append(
                    "<tr class='pointer' id=" + indexedRowID + ">" +
                    "<td style='vertical-align: middle'>" + categoryID + "</td>" +
                    "<td style='vertical-align: middle'>" + model.author + "</td>" +
                    "<td style='vertical-align: middle'>" + model.title + "</td>" +
                    "<td style='vertical-align: middle'>" + model.description + "</td>" +
                    "<td style='vertical-align: middle'>" + editButton + "</td>" +
                    "<td style='vertical-align: middle'>" + deleteButton + "</td>" +
                    "</tr>"
                );

            $('#category-row' + rowIndex).click(function () {
                localStorage.setItem("categoryID", categoryID);
                window.location.href = '/category-item';
            });

            rowIndex++;
        });
    });
})();

function saveCategory() {
    $('#category-messages').empty(); //clear messages from modal

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

    if ((title === null || title === '')) {
        $('#cat-title-label').addClass('text-warning').append(" *");
        $('#category-messages').append("<p class='text-warning'>Title is required</p>");
    }

    if ((description === null || description === '')) {
        $('#cat-desc-label').addClass("text-warning").append(" *");
        $('#category-messages').append("<p class='text-warning'>Description is required</p>")
    }

    if (title && description) {
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
    var answer = confirm("Are you sure you want to delete this category?");

    if (answer) {
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
}