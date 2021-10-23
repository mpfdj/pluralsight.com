# Architecture and Theory

## Kernel Internals
- namespaces
- control groups

Docker engine
- REST API (daemon)

Docker engine:
- client
- API (daemon)
- containerd
- OCI 


# Working with Images
Image (build-time) <==> Container (run-time)

Image ==> Layers (manifest)
Registry

docker system info

docker image pull redis
docker history redis
docker image inspect redis

- get the image manifest (meta data)
- download the layers (data)
- base layer


# Registry
C:\ProgramData\docker\windowsfilter

registry/repo/image:(tag)
docker.io (default)/redis/latest (default)

docker image pull docker.io/redis:4.0.1

layers:
- content hash (uncompressed) / layer id
- distribution hash (compressed)
- random hash is used to store the layer on the file system

Repo:
- official
- unofficial


# Chapter 6 Containerizing an App
git clone https://github.com/nigelpoulton/psweb

Code > Dockerfile > Build > Image

docker image build -t psweb .  # Tag image as psweb
docker image ls
docker container run -d --name web1 -p 8080:8080 psweb  # Create a container

docker image build -t psweb https://github.com/nigelpoulton/psweb.git  # Do a Docker build from a repository
docker history psweb

# Multi-stage Builds
git clone https://github.com/nigelpoulton/atsea-sample-shop-app.git  (fork of https://github.com/dockersamples/atsea-sample-shop-app.git)
cd atsea-sample-shop-app/app  # Dockerfile is in the app folder
docker image build -t multistage .
docker image ls


# Chapter 7 Working with Containers
atomic unit:
- container (Docker)
- vm (VMware)
- pod (Kubernetes)

copy-on-write

micro-services

# Containers
docker container run -it alpine sh  # Run container with interactive terminal
Ctrl + p + q

docker container run -d alpine sleep 1d

docker container exec -it <ID> sh  # Start a shell in an existing container

docker container exec <ID> ls -l  # Run a single command

docker container rm $(docker container ls -aq) -f  # Remove all containers

docker container run -d alpine  # No command is specified, use default command instead
docker image inspect alpine  # Check for default command

docker container run -d --name web1 -p 80:80 microsoft/iis  # Bug in IIS can't use localhost use IP instead
docker port web1  # Get port mapping


# Logging
- daemon logs
Linux
- systemd
  journalctl -u docker.service
- non-systemd
  /var/log/messages

Windows
- C:\Users\to11rc\AppData\Local\Docker


- container / app logs
set default logging driver in daemon.json

override per container
--log-driver  --log-opts

docker logs <ID>


# Chapter 8 Building a Secure Swarm

Swarm
- secure cluster
- orchestrator

SwarmKit

Single-engine mode
Swarm mode

docker swarm init

Best practise: 3, 5 or 7 managers


docker system info
docker node ls

# Restarting managers (not workers)
docker swarm update --autolock=true
sudo service docker restart
docker node ls
docer swarm unlock



# Chapter 9 Conatiner Networking

bridge networking (docker0) => tied to a single host (aka NAT on Windows)
overlay networking => connects multiple hosts
macvlan (Windows)

docker network create -o encrypted

docker network ls
docker network inspect bridge
docker container run --rm -d --name web -p 8080: nginx
docker port web

# Brigded network
docker network create -d bridge golden-gate
docker network ls
docker container run --rm -d --network golden-gate alpine sleep 1d

# Overlay network you must have a swarm up and running
docker network create -d overlay overnet
docker network ls
docker service create -d --name pinger --replicas 2 --network overnet alpine sleep 1d
docker service ls
docker service ps pinger
docker network inspect overnet # Switch over to node 2 (Manager)

# Network services
docker service rm $(docker service ls -q)
docker service create -d --name ping --network overnet --replicas 3 alpine sleep 1d
docker service create -d --name pong --network overnet --replicas 3 alpine sleep 1d


# Chapter 10 Working with Volumes and Persistent Data

persistent data
non persistent data

# Managing volumes
docker volume
docker volume ls
docker volume create myvol
docker volume instpect myvol
docker volume create psvol
docker volume rm myvol psvol

# Attaching volumes to containers


docker container run -dit --name voltest --mount source=ubervol,target=/vol alpine  # Detached and interactive, automatically creates a volume when it doesn't exist (so beware of typo's)
docker volume ls
docker container exec -it voltest sh  # Create a shell session

ls -l /vol
echo "some data" > /vol/newfile
cat /vol/newfile
exit

docker container rm voltest -f
docker volume ls


# Chapter 11 Working with Secrets

# Docker Secrets is for Services in Swarm mode only
docker swarm init  # Create a single node swarm cluster

cd c:\temp
touch classified

docker secret create wp-sec-v1 ./classified  # Is placed in the Raft
docker secret ls
docker secret inspect wp-sec-v1

docker service create -d --name secret-service --secret wp-sec-v1 microsoft/powershell:windowsservercore PowerShell Start-Sleep -s 86400
docker service ls
docker service inspect secret-service
docker container ls
docker container exec -it <container id> PowerShell  # Create an interactive shell
ls c:\ProgramData\Docker\secrets
cat c:\ProgramData\Docker\secrets\wp-sec-v1  # Show secret

Web GUI: Universal Control Plane (Enterprise Edition)


# Chapter 12 Deploying in Production with Stacks and Services
When running Docker Engine in SWARM MODE, you can use docker stack deploy to deploy a complete application stack to the swarm.

Amazon webservices
Code > Containers > Services (Swarm mode) > Stack (compose file)

https://github.com/nigelpoulton/ps-voting-app
https://github.com/dockersamples/example-voting-app


git clone https://github.com/nigelpoulton/ps-voting-app.git
docker stack deploy -c docker-stack.yml voter
docker stack ls
docker stack ps voter
docker stack ps -f desired-state=running voter
docker stack services voter

# voter_vote
http://localhost:5000

# voter_result
http://localhost:5001

# voter_visualizer
http://localhost:8080


# Imperative
docker service scale voter_vote=20  # Scale up the voter service
docker stack services voter
docker service inspect voter_vote --pretty

# Declarative
vim docker-stack.yml  # Go to vote service and update number of replicas to 10
docker stack deploy -c docker-stack.yml voter  # Re-apply the stack file
docker stack services voter
docker service inspect voter_vote --pretty


# Chapter 13 Enterprise Tooling


# Chapter 14 What's next

Paths: Container Management using Docker

Meet-ups: https://events.docker.com/chapters





