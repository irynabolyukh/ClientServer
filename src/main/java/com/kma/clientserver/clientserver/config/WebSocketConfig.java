package com.kma.clientserver.clientserver.config;

import com.kma.clientserver.clientserver.model.Student;
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

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new StudentHandler(),"/studentsConnection");
    }


    class StudentHandler extends TextWebSocketHandler {

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception{
            List<Student> studentList = studentService.get();
            StringBuilder answer = new StringBuilder();
            for(Student s: studentList){
                answer.append(s.toString());
            }
            session.sendMessage(new TextMessage(answer.toString()));
        }

        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
            var studentId = message.getPayload();
            Student student = studentService.get(Integer.parseInt(studentId));
            session.sendMessage(new TextMessage(student.toString()));
        }
    }
}