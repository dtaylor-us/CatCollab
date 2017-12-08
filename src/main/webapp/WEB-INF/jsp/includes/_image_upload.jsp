<input id="fileupload" type="file" name="files[]" data-url="http://localhost:8090/api/image/" multiple>
<script src="../resources/js/jquery.ui.widget.js"></script>
<script src="../resources/js/jquery.iframe-transport.js"></script>
<script src="../resources/js/jquery.fileupload.js"></script>
<script>
    $(function () {
        $('#fileupload').fileupload({
            dataType: 'json',
            done: function (e, data) {
                $.each(data.result.files, function (index, file) {
                    $('<p/>').text(file.name).appendTo(document.body);
                });
            }
        });
    });
</script>