#!/bin/bash

# Define your Docker Hub username and personal access token
DOCKER_USERNAME="user"
DOCKER_TOKEN="token"
REPO_NAME="testing-pyramid"

# Login to Docker Hub
echo "Logging in to Docker Hub..."
docker login -u $DOCKER_USERNAME -p $DOCKER_TOKEN

# Build the Docker image
echo "Building Docker image..."
docker build -t $DOCKER_USERNAME/$REPO_NAME:latest .

# Push the Docker image to Docker Hub
echo "Pushing Docker image..."
docker push $DOCKER_USERNAME/$REPO_NAME:latest

# Output completion message
echo "Docker image has been built and pushed successfully."
