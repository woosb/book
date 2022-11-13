$(document).ready(function () {
    // TODO url : "/company/?page=0&size=3&sort=code,ASC"
    $.ajax({
        url: "/company/?page=0&size=30&sort=name,ASC",
        type: "GET",
        dataType: "json",
        success: function (data) {
        }
    }).done(function (result) {
        let companies;
        result.forEach(function (company) {
            // companies += "<tr class='company-row' onClick='getBalanceSheet(" + company.id + ")'>";
            companies += "<tr class='company-row' onclick='detailPage("+company.id+")' >";
            companies += "<td>" + company.code + "</td>"
            companies += "<td>" + company.market + "</td>"
            companies += "<td>" + company.name + "</td>"
            companies += "<td>" + company.sectorCode + "</td>"
            companies += "<td>" + company.sectorName + "</td>"
            companies += "</tr>";
        });
        $("#companyList").html(companies);
    });
});

function detailPage(companyId){
    window.location.href='/company/detail/'+companyId;
}

