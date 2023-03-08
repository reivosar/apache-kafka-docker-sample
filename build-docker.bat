docker volume create --name=postgres_data
docker volume create --name=zookeeper_data
docker volume create --name=zookeeper_datalog
docker volume create --name=apache_kafka_data
docker-compose up --build