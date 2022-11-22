$(document).ready(function(){
    getBalanceSheet();
});

//TODO 고민? detail창에서 company 정보를 가져오고 싶다. model에 넣을지 ajax로 받을지 고민.

function getBalanceSheet() {
    $("#detailTableBody").empty();
    let companyCode = document.getElementById("companyCode").value;
    let kindOfReport = document.getElementById("kindOfReport").value;
    $.ajax({
        url: `/company/balanceSheet/${companyCode}/${kindOfReport}`,
        type: "GET",
        dataType: "json",
        success: function (data) {
        }
    }).done(function (result) {
        let details;
        result.forEach((balanceSheet) =>
            details += `<tr>
                            <td>${balanceSheet.subjectName}</td>
                            <td>${balanceSheet.current}</td>
                            <td>${balanceSheet.currentPeriod}</td>
                            <td>${balanceSheet.priorPeriod}</td>
                            <td>${balanceSheet.stdYmd}</td>
                            <td>${balanceSheet.stdMm}</td>
                         </tr>`
        );
        $("#detailTableBody").html(details);
    });
}
