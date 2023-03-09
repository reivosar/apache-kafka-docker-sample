package reivosar.domain.model.message;

import reivosar.common.domain.model.Identity;

public class MessageId extends Identity<MessageId> {
    final String value;
    
    public MessageId() {
        this(generateNativeIdByUUID());
    }
    
    public MessageId(final String value) {
        this.value = value;
    }
}
