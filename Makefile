PWD=$(shell pwd)
GRADLE_VERSION=2.10

.PHONY: all

all: build run

init:
	docker create --name gradle_cache gradle:$(GRADLE_VERSION)

build:
	docker run --rm -t --volumes-from=gradle_cache -v $(PWD)/app:/app gradle:$(GRADLE_VERSION) build

daemon:
	-docker rm -f gradle_build
	docker run -d --name gradle_build -t --volumes-from=gradle_cache -v $(PWD)/app:/app gradle:$(GRADLE_VERSION) --daemon --foreground

fastbuild:
	docker exec -it gradle_build gradle build

run:
	docker-compose build && docker-compose up -d

fup: fastbuild run logs

logs:
	docker-compose logs