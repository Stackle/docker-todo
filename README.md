# TODO API build with Docker + Spring Boot

## Get started

- install docker + docker-compose + make command on your machine
- open terminal + cd into this directory
- run `make init` then `make all`
- open web browser and browse with url of your docker-machine on port 80

## List of APIs

to make it easy to test all API is a HTTP GET

- `/tasks/` - list all tasks
- `/tasks/add/things to do` - add new task with `things to do`
- `/tasks/done/{id}` - set a specific task id to be done
- `/tasks/undone/{id}` - set a specific task id to be undone
- `/tasks/delete/{id}` - remove a specific task id
