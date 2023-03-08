package reivosar.domain.model.message;

import reivosar.common.domain.model.event.EventTemplate;
import reivosar.common.domain.model.event.EventTopic;

abstract class MessageEventTemplate extends EventTemplate
{
	public MessageEventTemplate() {
		super(new EventTopic("MessageEventTopic"));
	}
}
