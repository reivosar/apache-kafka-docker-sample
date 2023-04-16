# Apache Kafka Docker Sample

This is a simple example of using Apache Kafka with Docker Compose. It sets up a Kafka broker and a producer and consumer application.

## Prerequisites

- Docker
- Docker Compose

## Running the sample

1. Clone the repository
2. Navigate to the root of the repository
3. Start the Kafka broker and producer/consumer apps with Docker Compose: `docker-compose up`
4. In a new terminal, run the producer app: `docker-compose run producer`
5. In another new terminal, run the consumer app: `docker-compose run consumer`

## Configuration

The `docker-compose.yml` file sets the configuration for the Kafka broker and the producer and consumer apps. It specifies the image version, ports, and environment variables.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
