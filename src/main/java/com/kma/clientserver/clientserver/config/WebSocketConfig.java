//package com.kma.clientserver.clientserver.config;
//
//import com.kma.clientserver.clientserver.model.Student;
//import com.kma.clientserver.clientserver.service.StudentService;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//	@Autowired
//	private StudentService studentService;
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(new StudentsHandler(),"/api/students");
//    }
//
//    class StudentsHandler extends TextWebSocketHandler {
//		private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
//		@Override
//		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//			sessions.add(session);
//		}
//		@Override
//		public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//			var id = message.getPayload();
//			Student studentObj = studentService.get(Integer.parseInt(id));
//			String res = studentObj.toString();
//			for(WebSocketSession s : sessions) {
//				s.sendMessage(new TextMessage(res));
//			}
//		}
//	}
//}
