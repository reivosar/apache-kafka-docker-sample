package reivosar.domain.model.message;

public interface MessageReposiory
{
	MessageId generateId();

	void save(final Message message);
}
