$(document).ready(function () {
    getCompany();
});

function getCompany(){
    // TODO url : "/company/?page=0&size=3&sort=code,ASC"
    $("#companyList").empty();
    $.ajax({
        url: "/company/?page=0&size=30&sort=name,ASC",
        type: "GET",
        dataType: "json",
        success: function (data) {
        }
    }).done(function (result) {
        let companies;
        result.forEach((company) =>
            companies += `<tr class='company-row' onclick='detailPage("${company.code}")'>
                            <td>${company.code}</td>
                            <td>${company.market}</td>
                            <td>${company.name}</td>
                            <td>${company.sectorCode}</td>
                            <td>${company.sectorName}</td>
                         </tr>`
        );
        $("#companyList").html(companies);
    });
}

function detailPage(companyCode){
    window.location.href=`/company/detail/${companyCode}`;
}

