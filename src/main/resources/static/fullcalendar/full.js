let startDate;
let endDate;
var calendar;
var globalrespanse;


function removeAbsence() {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/remove/absance");

    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(globalrespanse.uid);

    location.reload();
}

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
        },
        eventClick : function (info){
            let xhr = new XMLHttpRequest();
            xhr.open("POST", "/get/absance");

            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onload = function (){
                var emploeeInput = document.getElementById("inputEmployee");
                var absanceTypeInput = document.getElementById("absancetype");
                var descreptionInput = document.getElementById("Descreption");
                var absanceIdInput = document.getElementById("UID");
                globalrespanse = JSON.parse(this.response);
                emploeeInput.value = globalrespanse.emploeeID;
                absanceTypeInput.value = globalrespanse.absanceID;
                descreptionInput.value = globalrespanse.discreption;
                absanceIdInput.value = globalrespanse.uid;

            }
            xhr.send(info.event.id);
        }
    });
    calendar.render();

    document.getElementById("addAbsent").addEventListener("click", addAbsence);
    document.getElementById("removeAbsance").addEventListener("click", removeAbsence);
});

function addAbsence() {
    if (startDate == null && endDate == null) {
        alert("you forget to pick a date from callende")
        return;
    }
    var emploeeInput = document.getElementById("inputEmployee");
    var absanceTypeInput = document.getElementById("absancetype");
    var descreptionInput = document.getElementById("Descreption");
    var absanceIdInput = document.getElementById("UID");
    console.log(absanceIdInput.value);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/add/absance");

    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = () => console.log(xhr.responseText);


    let data = '{"uid" : "'+absanceIdInput.value +'" , "emploeeID" : "' + emploeeInput.value +'" , "absanceID" :"' + absanceTypeInput.value +'" ,"discreption" :"'+ descreptionInput.value+ '", "start" : "'+ startDate.startStr + '","end" : "' + startDate.endStr + '"}';

    xhr.send(data);
    location.reload();
}