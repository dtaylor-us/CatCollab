function Image(model) {
    this.title = model.title;
    this.author = model.author;
    this.description = model.description;
}

function saveImage() {

    //save image as object


    var files = document.getElementById('files').files;
    var img = files.item(0);

    if (img) {
        postFile(img);

    } else {
        console.log('error')
    }
}

function postFile(file) {
    var name;
    var type;
    var pic;
    var imgModel = {};
    var reader = new FileReader();

    reader.readAsDataURL(file);
    name = file.name;
    type = file.type;

    reader.onload = function () {
        pic = reader.result;
        pic = window.btoa(pic);
        // pic = pic.replace(/^.+,/,'');
        // pic = pic.replace(/^data:image\/[a-z]+;base64,/, "");
        imgModel = {
            id: $('#imageID').val(),
            version: $('#imageVersion').val(),
            name: name,
            type: type,
            pic: pic
        };

        $.ajax({
            url: "/api/image/",
            type: "post",
            data: JSON.stringify(imgModel),
            async: true,
            success: function () {
                window.location.reload();
            },
            error: alert("shit")
        });

    };
    reader.onerror = function (error) {
        console.log('Error: ', error);
    };

}

function editImage(id) {
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

function openImageModal() {
    $('#imageModal').modal('show')
}