
 package kr.co.kim3.service;
 
 import net.nurigo.sdk.*;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

import org.springframework.beans.factory.annotation.Value; 
 import org.springframework.stereotype.Service;
 import kotlinx.serialization.json.JsonObject; 
 import java.util.HashMap;
 
 @Service 
 public class SmsService {
 
 @Value("${NCS3PDQNOLKX4BGR}") 
 private String apiKey;
 
 @Value("${TXUGGXPLBERKKKCGVA0T7HGXP7AZOLLO}") 
 private String apiSecret;
 
 public void sendVerificationCode(String phoneNumber, String verificationCode) throws NurigoEmptyResponseException, NurigoUnknownException{ 
	 	 
	 	// Message coolsms = new Message();
		// HashMap<String, String> params = new HashMap<>(); 
	 	 
		// params.put("to",phoneNumber); 
		// params.put("from", "010-8977-7160"); // 발신자 번호
		// params.put("type", "SMS"); 
		// params.put("text", "인증번호는  : " + verificationCode); 
		 
	 	// JsonObject result = coolsms.send(params);

 	//}
 
	 DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCS3PDQNOLKX4BGR", "TXUGGXPLBERKKKCGVA0T7HGXP7AZOLLO", "https://api.coolsms.co.kr");
	//Message 패키지가 중복될 경우 net.nurigo.sdk.message.model.Message로 치환하여 주세요
		Message message = new Message();
		message.setFrom("01089777160");
		message.setTo(phoneNumber);
		message.setText("인증번호는  : " + verificationCode);
	
	try {
	// send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
	messageService.send(message);
	} catch (NurigoMessageNotReceivedException exception) {
	// 발송에 실패한 메시지 목록을 확인할 수 있습니다!
	System.out.println(exception.getFailedMessageList());
	System.out.println(exception.getMessage());
	} 
 }
 }
