package reivosar.infrastructure.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reivosar.common.domain.model.event.DomainEventPublisher;
import reivosar.common.util.log.Loggers;
import reivosar.domain.model.message.Message;
import reivosar.domain.model.message.MessageId;
import reivosar.domain.model.message.MessageReposiory;

@Component
public class KafkaMessageRepository implements MessageReposiory {

	private static final Loggers loggers = Loggers.getLoggers(KafkaMessageRepository.class);

    private final DomainEventPublisher domainEventPublisher;
    
    @Autowired
	public KafkaMessageRepository(DomainEventPublisher domainEventPublisher) {
		this.domainEventPublisher = domainEventPublisher;
	}

	@Override
	public MessageId generateId() {
		return new MessageId();
	}

	@Override
	public void save(Message message) {
		loggers.info("Event publishing start: publicId:" + message.identity());
		domainEventPublisher
			.awaitPublish(message)
			.onSuccess(
                    result -> loggers.debug("Event publishing success. "
                            + "event:" + message + " ,result:" + result)
			)
			.onFailure(
                    t -> loggers.error("Event publishing error.", t)
			);
		loggers.info("Event publishing end: publicId:" + message.identity());
	}
}
