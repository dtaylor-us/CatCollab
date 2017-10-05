cat.v.category_list = {
    loadUI: function () {

        localStorage.removeItem('categoryID');

        this.loadCategoryTable();

    },
    loadCategoryTable: function () {

        $.getJSON("/api/category/", {
            ajax: 'true',
            dataType: 'jsonp'

        }, function (data) {

            //init index for category list
            var rowIndex = 0;

            // iterate over results
            $.each(data, function (index, model) {
                var categoryID = model.id;
                var currentUser = document.getElementById('current-user').innerHTML;
                var editButton = "";
                var deleteButton = "";

                //create unique id for each category item button
                var indexButtonID = 'category-item-button' + rowIndex;
                var viewItemButton = "<button id='" + indexButtonID + "' class='btn btn-info'>View Items</button>";


                //conditionally display buttons to edit records based on current user
                if (currentUser === model.author) {
                    editButton = "<button class='btn btn-warning' onclick='editCategory(" + categoryID + ")'>Edit</button>";
                    deleteButton = "<button class='btn btn-danger' id='deleteButton' onclick='deleteCategory(" + categoryID + ")'>Delete</button>";
                }

                //construct category list table from indexed category in list
                $('#category-table').find('tbody')
                    .append(
                        "<tr>" +
                        "<td style='vertical-align: middle'>" + categoryID + "</td>" +
                        "<td style='vertical-align: middle'>" + model.author + "</td>" +
                        "<td style='vertical-align: middle'>" + model.title + "</td>" +
                        "<td style='vertical-align: middle'>" + model.description + "</td>" +
                        "<td style='vertical-align: middle'>" + viewItemButton + "</td>" +
                        "<td style='vertical-align: middle'>" + editButton + "</td>" +
                        "<td style='vertical-align: middle'>" + deleteButton + "</td>" +
                        "</tr>"
                    );

                //store categoryID in local storage and navigate to category-item page
                $('#category-item-button' + rowIndex).click(function () {
                    localStorage.setItem("categoryID", categoryID);
                    window.location.href = '/category-item';
                });

                rowIndex++;

            });
        });
    }
};