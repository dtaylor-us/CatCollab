<%@ include file="includes/_header.jsp" %>
<body>

<style>
    .thumb {
        height: 75px;
        border: 1px solid #000;
        margin: 10px 5px 0 0;
    }
</style>

<%@ include file="includes/_nav.jsp" %>

<div class="wrapper spacer-25">

    <%--SIDEBAR--%>
    <%@ include file="includes/_img_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10 spacer-50">
        <div class="col-sm-12">

            <%--LIST OF EXISTING ELEMENTS--%>
            <table id="image-table" class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Pic</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>
    </div>

</div>

<div id="imageModal" class="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Upload Image</h5>
            </div>
            <div class="modal-body">
                <input type="hidden" id="imageID"/>
                <input type="hidden" id="imageVersion"/>
                <input type="file" id="files" name="files[]" />
                <output id="list"></output>

                <div id="image-messages"><p class='text-warning'></p></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveImage()">Save Image</button>
            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/init.js"></script>
<script src="../../resources/js/image.js"></script>
<%--<script src="../../resources/js/image-list.js"></script>--%>

<script>

    function handleFileSelect(evt) {
        var files = evt.target.files; // FileList object

        // Loop through the FileList and render image files as thumbnails.
        for (var i = 0, f; f = files[i]; i++) {

            // Only process image files.
            if (!f.type.match('image.*')) {
                continue;
            }

            var reader = new FileReader();

            // Closure to capture the file information.
            reader.onload = (function(theFile) {
                return function(e) {
                    // Render thumbnail.
                    var span = document.createElement('span');
                    span.innerHTML = ['<img class="thumb" src="', e.target.result,
                        '" title="', escape(theFile.name), '"/>'].join('');
                    document.getElementById('list').insertBefore(span, null);
                };
            })(f);

            // Read in the image file as a data URL.
            reader.readAsDataURL(f);
        }
    }

    document.getElementById('files').addEventListener('change', handleFileSelect, false);
</script>

</body>
</html>
