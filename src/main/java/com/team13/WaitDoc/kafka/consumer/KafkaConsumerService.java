package com.team13.WaitDoc.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.team13.WaitDoc.waiting.dto.WaitingInfo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "hospital_waiting", groupId = "myGroup")
	public void consumeWaitingInfo(String waitingInfoJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			WaitingInfo waitingInfo = objectMapper.readValue(waitingInfoJson, WaitingInfo.class);

			// 이제 waitingInfo 객체를 사용하여 원하는 작업을 수행할 수 있습니다.
			// 예를 들어, type이 "register"인 경우 대기자 수를 증가시키고,
			// "cancel"인 경우 대기자 수를 감소시키는 등의 로직을 구현할 수 있습니다.
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}