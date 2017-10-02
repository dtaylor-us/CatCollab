<%@ include file="includes/_header.jsp" %>

<body>
<%@ include file="includes/_nav.jsp" %>

<h2>Category Page</h2>

<script>
    $.getJSON("http://localhost:8080/api/category/", {
        ajax: 'true',
        dataType: 'jsonp'
    }, function (data) {
        console.log(data);
        $.each(data, function (index, single) {
            $('#categoryList').append(single.title + ': ' + single.description + '<br>')
        });
    })
</script>

<p id="categoryList"></p>
</body>
</html>
