<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>--%>
<%--    <title>Client Server</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>--%>
<%--<div>--%>
<%--    <h4>Students</h4>--%>
<%--    <table>--%>
<%--        <thead>--%>
<%--        <th>ID</th>--%>
<%--        <th>FIO</th>--%>
<%--        <th>Course</th>--%>
<%--        </thead>--%>
<%--        <!--        <tbody id="studentsList">-->--%>
<%--        <!--        </tbody>-->--%>
<%--    </table>--%>
<%--    <div id="studentsList">--%>

<%--    </div>--%>
<%--</div>--%>
<%--<div>--%>
<%--    <h4>More info about student</h4>--%>
<%--    <form id="getStudentForm" method="post" action="/api/students/">--%>
<%--        <label for="id">Student ID:</label>--%>
<%--        <input type="text" name="id" id="id">--%>
<%--        <button id="getInfoButton" type="submit">Get info</button>--%>
<%--    </form>--%>
<%--</div>--%>
<%--<div id="student">--%>
<%--    <div id="studentInfo">--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <h4>Disciplines</h4>--%>
<%--        <table>--%>
<%--            <thead>--%>
<%--            <th>ID</th>--%>
<%--            <th>Discipline</th>--%>
<%--            <th>Credits</th>--%>
<%--            <th>Grade</th>--%>
<%--            </thead>--%>
<%--            <tbody id="disciplinesList">--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script>--%>
<%--    let ws;--%>
<%--    $(document).ready(function (){--%>
<%--        $('#getInfoButton').click(function (){--%>
<%--            sendForm();--%>
<%--            $('#id').val('');--%>
<%--        });--%>

<%--        ws = new WebSocket('ws://localhost:8080/api/students');--%>

<%--        ws.onmessage = function(data) {--%>
<%--            let $students = $('#studentsList');--%>

<%--            $students.empty();--%>

<%--            // data.forEach(student => {--%>
<%--            //     $students.append('<tr><td>' + student.id + '</td><td>' + student.fio + '</td><td>'--%>
<%--            //         + student.course + '</td></tr>')--%>
<%--            // })--%>
<%--            $('#studentsList').prepend('<div class="row"><div class="col s12"><div class="card grey-text"><div class="card-content center>"<p>' + data.data + '</p></div></div></div></div>');--%>

<%--        };--%>
<%--    });--%>

<%--    function sendForm(){--%>
<%--        ws.send($('#id').val());--%>
<%--    }--%>
<%--    // $(document).ready(--%>
<%--    //     () => {--%>
<%--    //         loadStudents();--%>
<%--    //         $('#getStudent').submit(function (e) {--%>
<%--    //             e.preventDefault();--%>
<%--    //             $.ajax({--%>
<%--    //                 type: 'GET',--%>
<%--    //                 url: '/students/' + $(this).find('[name=studentId]').val(),--%>
<%--    //                 dataType: 'json',--%>
<%--    //                 beforeSend: function (xhr) {--%>
<%--    //                     xhr.setRequestHeader('Content-Type', 'application/json');--%>
<%--    //                 },--%>
<%--    //                 success: function (response) {--%>
<%--    //                     studentInfo(response);--%>
<%--    //                 }--%>
<%--    //             })--%>
<%--    //         });--%>
<%--    //--%>
<%--    //     }--%>
<%--    // );--%>

<%--    // function studentInfo(data) {--%>
<%--    //     let $studentInfo = $('#studentInfo');--%>
<%--    //     let $disciplinesList = $('#disciplinesList');--%>
<%--    //--%>
<%--    //     $('#student').show();--%>
<%--    //     $studentInfo.empty();--%>
<%--    //     $disciplinesList.empty();--%>
<%--    //--%>
<%--    //     $studentInfo.append(`<h4>ПІБ: ` + data.fio + `</h4>`);--%>
<%--    //     $studentInfo.append(`<h4>Курс студента: ` + data.course + `</h4>`);--%>
<%--    //--%>
<%--    //     data.enrollments.forEach(enr => {--%>
<%--    //         $disciplinesList.append('<tr><td>' + enr.discipline.id + '</td><td>' + enr.grade + '</td><td>'--%>
<%--    //             + enr.discipline.name + '</td><td>' + enr.discipline.credits + '</td></tr>')--%>
<%--    //     })--%>
<%--    // }--%>

<%--    // function loadStudents() {--%>
<%--    //     $.ajax({--%>
<%--    //         url: '/students',--%>
<%--    //         success: (response) => (setStudentList(response))--%>
<%--    //     })--%>
<%--    // }--%>


<%--    // function setStudentList(data) {--%>
<%--    //--%>
<%--    //     let $students = $('#studentsList');--%>
<%--    //--%>
<%--    //     $students.empty();--%>
<%--    //--%>
<%--    //     data.forEach(student => {--%>
<%--    //         $students.append('<tr><td>' + student.id + '</td><td>' + student.fio + '</td><td>'--%>
<%--    //             + student.course + '</td></tr>')--%>
<%--    //     })--%>
<%--    //--%>
<%--    // }--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>