(function () {
    var categoryID = '';
    var categoryName = '';
    var storedID = localStorage.getItem('categoryID');

    if (storedID) {
        categoryID = storedID;
        $('#selected-category').val(storedID);
        console.log('stored id has been saved in hidden input tag');
        localStorage.removeItem('categoryID');
        console.log('id has been removed from storage');
    } else {
        console.log('no id present on page');
    }
    console.log(categoryID);

    $.getJSON("/api/category/" + categoryID, {
        ajax: true,
        dataType: 'jsonp'
    }, function (data) {
        categoryName = data.title
        $('#parent-category-title').append(
            "<h4>" + categoryName + " : " + data.description + "</h4>"
        )
    });


    //make an ajax call for list of items by category id
    $.getJSON("/api/item/category/" + categoryID, {
        ajax: true,
        dataType: 'jsonp'
    }, function (data) {

        if (data.length === 0) {
            $('#category-item-messages').append(
                "<h4 class='text-warning'>No Items have been created for this category</h4>"
            )
        } else {
            $.each(data, function (index, model) {
                var itemID = model.id;
                var currentUser = document.getElementById('current-user').innerHTML;
                var editButton = "";
                var deleteButton = "";

                if (currentUser === model.author) {
                    editButton = "<button class='btn btn-warning' onclick='editItem(" + itemID + ")'>Edit</button>";
                    deleteButton = "<button class='btn btn-danger' id='deleteButton' onclick='deleteItem(" + itemID + ")'>Delete</button>";
                }

                $('#item-table').find('tbody').append(
                    "<tr class='pointer'>" +
                    "<td style='vertical-align: middle'>" + itemID + "</td>" +
                    "<td style='vertical-align: middle'>" + model.author + "</td>" +
                    "<td style='vertical-align: middle'>" + model.title + "</td>" +
                    "<td style='vertical-align: middle'>" + model.description + "</td>" +
                    "<td style='vertical-align: middle'>" + categoryName + "</td>" +
                    "<td style='vertical-align: middle'>" + editButton + "</td>" +
                    "<td style='vertical-align: middle'>" + deleteButton + "</td>" +
                    "</tr>"
                )
            })
        }
    });


})();

//If page is reloaded use same categoryID to populate list.
$(window).bind('beforeunload', function () {
    var id = $('#selected-category').val();
    if (id) {
        localStorage.setItem('categoryID', id);
    }
});