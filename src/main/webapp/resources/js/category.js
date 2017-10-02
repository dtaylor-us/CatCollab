
(function () {
    $.getJSON("http://localhost:8080/api/category/", {
        ajax: 'true',
        dataType: 'jsonp'
    }, function (data) {
        console.log(data);
        $.each(data, function (index, single) {
            console.log('#category-table');
            $('#category-table').find('tbody')
                .append("<tr>" +
                    "<td style='vertical-align: middle'>" + single.id + "</td>" +
                    "<td style='vertical-align: middle'>" + single.title + "</td>" +
                    "<td style='vertical-align: middle'>" + single.description + "</td>" +
                    "<td style='vertical-align: middle'>" + "<button class='btn btn-warning' onclick='editCategory(" + single.id + ")'>Edit</button>" + "</td>" +
                    "<td style='vertical-align: middle'>" + "<button class='btn btn-danger' onclick='deleteCategory(" + single.id + ")'>Delete</button>" + "</td>" +
                    "</tr>"
                )
        });
    });
})();

function saveCategory() {
    
}