package reivosar.infrastructure.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reivosar.common.domain.model.event.DomainEventPublisher;
import reivosar.common.util.io.json.JsonUtil;
import reivosar.common.util.promise.Promise;
import reivosar.domain.model.message.Message;
import reivosar.domain.model.message.MessageId;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
public class KafkaDomainEventPublisher implements DomainEventPublisher<MessageId, Message> {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    public KafkaDomainEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    @Override
    public void asyncPublish(final Message entity) {
        entity.allEvents().forEach(e -> this.kafkaTemplate.send(e.getEventTopic(), JsonUtil.serialize(e)));
    }
    
    @Override
    public Promise<Object> awaitPublish(final Message entity) {
        return Promise.all(entity.allEvents().stream().map(
                        e -> (Supplier<Object>) () -> kafkaTemplate.send(e.getEventTopic(), JsonUtil.serialize(e)))
                .collect(Collectors.toList()));
    }
}
