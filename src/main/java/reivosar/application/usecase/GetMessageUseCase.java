package reivosar.application.usecase;

import org.springframework.stereotype.Service;

@Service
public class GetMessageUseCase
{
	public Response execute (final Request request) {
		return new Response();
	}

	public static class Request {
	}

	public static class Response {
	}
}
