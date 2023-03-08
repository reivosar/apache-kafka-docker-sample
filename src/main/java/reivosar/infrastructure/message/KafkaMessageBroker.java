package reivosar.infrastructure.message;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

import reivosar.common.util.log.Loggers;

@Service
public class KafkaMessageBroker
{
	private static final Loggers loggers = Loggers.getLoggers(KafkaMessageBroker.class);

	@KafkaListener(topics = "MessageEventTopic", groupId = "group_id")
	public void demoBroker(ConsumerRecord<?, ?> cr) {
		loggers.info(cr.toString());
	}
}
