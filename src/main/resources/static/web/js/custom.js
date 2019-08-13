$(function () {
    $("form[name='citizen-form']").validate({
        rules: {
            socialSecurityNumber: {
                required: true,
                minlength: 11,
                maxlength: 11
            },
            firstName: "required",
            lastName: "required"
        },
        messages: {
            socialSecurityNumber: {
                required: "Please provide a social security number",
                minlength: "Social security must 11 characters long",
                maxlength : "Social security must 11 characters long"
            },
            firstName: "Please enter first name",
            lastName: "Please enter last name"
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});

