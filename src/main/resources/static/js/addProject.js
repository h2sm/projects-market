$(function () {
    $("#sendProject").click(function () {
        var projectName = $("#projectName").val();
        var projectDescription = $("#projectDescription").val();
        $.ajax({
            type: "POST",
            url: "/projects/project",
            body: {projectName: projectName, projectDescription: projectDescription},
            success: function (response) {
                alert("Sent !!")
            },
            error: function (d) {
                console.log(d);
                alert("FUCK")
            }
        });
    });
});