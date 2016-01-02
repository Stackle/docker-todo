PWD=$(shell pwd)
GRADLE_VERSION=2.9
GRADLE_DOCKER_IMAGE=tanapolsh/gradle
DOCKER_BUILD_CTN_NAME=gradle_build
DOCKER_DATA_CTN_NAME=gradle_cache

.PHONY: all

all: build run

init:
	-docker create --name $(DOCKER_DATA_CTN_NAME) $(GRADLE_DOCKER_IMAGE):$(GRADLE_VERSION)
	-docker stop $(DOCKER_BUILD_CTN_NAME)
	-docker rm $(DOCKER_BUILD_CTN_NAME)
	docker run -d -t --name $(DOCKER_BUILD_CTN_NAME) --volumes-from=$(DOCKER_DATA_CTN_NAME) -v $(PWD)/app:/app $(GRADLE_DOCKER_IMAGE):$(GRADLE_VERSION) --foreground

build:
	docker exec -it $(DOCKER_BUILD_CTN_NAME) gradle build --daemon

rebuild:
	docker run --rm -t --volumes-from=$(DOCKER_DATA_CTN_NAME) -v $(PWD)/app:/app $(GRADLE_DOCKER_IMAGE):$(GRADLE_VERSION) build

run:
	docker-compose build && docker-compose up -d

gradle_bash:
	docker exec -it $(DOCKER_BUILD_CTN_NAME) bash

logs:
	docker-compose logs