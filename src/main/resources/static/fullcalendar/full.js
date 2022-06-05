let startDate;
let endDate;
var calendar;
document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar');
    calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        selectable: true,
        select: function (start, end, jsEvent, view) {
            startDate = start;
            endDate = end;
            console.log(start);
        },
        events: {
            url: '/get/absance',
        }
    });
    calendar.render();

    document.getElementById("addAbsent").addEventListener("click", addAbsence);
});

function addAbsence() {
    if (startDate == null && endDate == null) {
        alert("you forget to pick a date from callende")
        return;
    }
    var emploeeInput = document.getElementById("inputEmployee")
    var absanceTypeInput = document.getElementById("absancetype")
    var descreptionInput = document.getElementById("Descreption")

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/add/absance");

    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = () => console.log(xhr.responseText);


    let data = '{"emploeeID" : "' + emploeeInput.value +'" , "absanceID" :"' + absanceTypeInput.value +'" ,"discreption" :"'+ descreptionInput.value+ '", "start" : "'+ startDate.startStr + '","end" : "' + startDate.endStr + '"}';

    xhr.send(data);
    location.reload();
}