ws = new WebSocket("ws://localhost:8080/studentsConnection");

ws.onopen = function (ev){}

ws.onmessage = function (ev){
    let jsonArray = JSON.parse(ev.data);
    console.log(jsonArray);
    try{
        if(jsonArray[0].hasOwnProperty('fio')){
            displayStudents(jsonArray);
        }
        if(jsonArray[0].hasOwnProperty('discipline')){
            displayEnrollments(jsonArray);
        }
    }
    catch{
        displayError(jsonArray);
    }

}

ws.onerror = function (ev){}
ws.onclose = function (ev){}

function displayError(message){
    $('#studentTableInfo').hide();
    let $studentInfo = $('#studentInfo');
    $studentInfo.empty();
    $studentInfo.append(`<h3>` + message.message + `</h3>`);
}

function displayStudents(message){
    let $output = $('#students');
    message.forEach(student => {
        $output.append('<tr><td>' + student.id + '</td><td>' + student.fio + '</td><td>'
            + student.course + '</td></tr>');
    });
}

function displayEnrollments(jsonArray){
    $('#studentTableInfo').show();
    let $studentInfo = $('#studentInfo');
    let $disciplines = $('#disciplines');
    let $disciplineHead = $('#disciplinesHead');

    let studentObj = jsonArray[0].student;

    $disciplineHead.empty();
    $studentInfo.empty();
    $disciplines.empty();

    $studentInfo.append(`<h3>` + studentObj.fio + ', ' + studentObj.course + `</h3>`);
    $disciplineHead.append(`<th>DISCIPLINE</th><th>CREDITS</th><th>GRADE</th>`);
    jsonArray.forEach(en => {
        $disciplines.append('<tr><td>'
            + en.discipline.dname + '</td><td>' + en.discipline.credits + '</td>' +
            '<td>' + en.grade + '</td></tr>')
    });
}

function getInfo(){
    let message = document.getElementById('message').value;
    if(Number.isInteger(parseInt(message))){
        let studentId = Math.abs(parseInt(message));
        console.log(studentId);
        ws.send(studentId);
    }
    else {
        $('#studentTableInfo').hide();
        let $studentInfo = $('#studentInfo');
        $studentInfo.empty();
        $studentInfo.append(`<h3>Input should be integer!</h3>`);
    }
}