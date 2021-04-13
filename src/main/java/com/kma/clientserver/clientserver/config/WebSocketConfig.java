package com.kma.clientserver.clientserver.config;

import com.kma.clientserver.clientserver.model.Enrollment;
import com.kma.clientserver.clientserver.model.Student;
import com.kma.clientserver.clientserver.service.EnrollmentService;
import com.kma.clientserver.clientserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
	private StudentService studentService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new StudentHandler(),"/studentsConnection");
    }


    class StudentHandler extends TextWebSocketHandler {

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception{
            List<Student> studentList = studentService.get();
            StringBuilder answer = new StringBuilder();
            answer.append("[");
            for(Student s: studentList){
                answer.append(s.toString());
                answer.append(",");
            }
            answer.deleteCharAt((answer.length()-1));
            answer.append("]");
            session.sendMessage(new TextMessage(answer.toString()));
        }

        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
            int studentId = Integer.parseInt(message.getPayload());
            List<Enrollment> enrollments = enrollmentService.getForStudent(studentId);
            StringBuilder answer = new StringBuilder();
            answer.append("[");
            for(Enrollment e: enrollments){
                answer.append(e.toString());
                answer.append(",");
            }
            answer.deleteCharAt((answer.length()-1));
            answer.append("]");
            session.sendMessage(new TextMessage(answer));
        }
    }
}