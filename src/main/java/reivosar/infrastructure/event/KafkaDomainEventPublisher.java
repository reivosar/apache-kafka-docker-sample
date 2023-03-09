package reivosar.infrastructure.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reivosar.common.domain.model.event.DomainEventPublisher;
import reivosar.common.domain.model.event.Event;
import reivosar.common.util.io.json.JsonUtil;
import reivosar.common.util.promise.Promise;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
public class KafkaDomainEventPublisher implements DomainEventPublisher {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    public KafkaDomainEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public Promise<?> publish(final Event event) {
        return Promise.resolve(() -> this.kafkaTemplate.send(event.getEventTopic(), JsonUtil.serialize(event)));
    }
    
    @Override
    public Promise<?> publishAll(final Collection<Event> events) {
        return Promise.all(events.stream().map(
                        e -> (Supplier<Object>) () -> kafkaTemplate.send(e.getEventTopic(), JsonUtil.serialize(e)))
                .collect(Collectors.toList()));
    }
}
