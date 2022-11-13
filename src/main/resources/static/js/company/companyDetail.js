function getBalanceSheet(company_id) {
    console.log(company_id);
    $.ajax({
        url: "/company/balanceSheet/" + company_id,
        type: "GET",
        dataType: "json",
        success: function (data) {
        }
    }).done(function (result) {
        console.log(result);
    });
}