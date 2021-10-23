# Play with docker
https://labs.play-with-docker.com
copy: user firefox
paste: shift + fn + e

image: designtime <==> container: runtime



# Get code
git clone https://github.com/nigelpoulton/gsd 

# Build docker image locally
cd C:\miel\docker\gsd\first-container
docker image build -t miel1980/gsd:first-ctr .
docker image ls

# Host on a Registry
docker image push miel1980/gsd:first-ctr

# Running a containerized app
docker image rm miel1980/gsd:first-ctr  # Delete local image
docker image ls
docker container run -d --name web -p 8000:8080 miel1980/gsd:first-ctr  # Get it from dockerHub
http://localhost:8000
docker container ls

# Managing a containerized app
docker container stop web
docker container ls -a
docker container start web

docker container stop web
docker container rm web
docker container ls -a

docker container run -i -t --name test alpine sh  # Run a container in interactive mode
ctrl+p+q  # Graceful exit


App
OS (kernel) ==> container model
Hardware    ==> VM model


# Microservices and the real world
Multi-container Apps with Docker Compose


cd C:\miel\docker\gsd\multi-container
docker-compose up -d
docker image ls
docker container ls
http://localhost:5000
docker-compose down

Docker swarm  <==> Kubernetes
Manager node
Worker node
Docker Service

# Chapter 5
# Taking Things to the Next Level with Docker Swarm
# Create an uneven number of manager nodes in a cluster to prevent split brain situation
# Go to https://labs.play-with-docker.com

docker swarm init --advertise-addr=192.168.0.13  # Create the first manager node in the cluster, this node is used for cluster communication (Leader node)
docker swarm join-token manager
docker swarm join-token worker
docker node ls
docker swarm leave --force  # Remove a node from the swarm cluster

# Microservices and Docker Services (imparative way)
git clone https://github.com/nigelpoulton/gsd 
cd /root/gsd/multi-container
docker service create --name web -p 8080:8080 --replicas 3 miel1980/gsd:first-ctr
docker service ls
docker service ps web
docker container ls  # Shows only the containers on the host not on the cluster (Nigel Poulton is using a single node cluster)
docker service scale web=10
docker container rm 5115f07358cc bbc08709ac67 --force  # Delete 2 containers. 2 new containers will be started automatically, since replicas is 3.
docker service ps -f desired-state=running web


# Multi-container Apps with Docker Stacks (declrative)
# Stacks on a swarm don't support on the fly image building. Images should be build upfront.
docker service rm web  # Clean from previous
docker service ls
docker container ls
cd /root/gsd/swarm-stack
docker image build -t miel1980/gsd:swarm-stack .
docker image ls
docker stack deploy -c docker-compose.yml counter
docker stack ls
docker stack services counter  # Display more details of a stack
docker stack ps counter  # List containers

vim docker-compose.yml
Set replicas to 5
docker stack deploy -c docker-compose.yml counter  # Re-run the stack deploy command. It gets updated on the fly!!!
docker stack ps counter
docker stack rm counter  # Tear it down


# What Next...


