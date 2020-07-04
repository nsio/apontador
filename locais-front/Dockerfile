# Create image based on the official Node 6 image from dockerhub
FROM node:12

# Create a directory where our app will be placed
RUN mkdir -p /home/nsio/projeto/apontador/local-front

# Change directory so that our commands run inside this new directory
WORKDIR /home/nsio/projeto/apontador/local-front

# Copy dependency definitions
COPY package.json /home/nsio/projeto/apontador/local-front

# Install dependecies
RUN npm install

# Get all the code needed to run the app
COPY . /home/nsio/projeto/apontador/local-front

# Expose the port the app runs in
EXPOSE 4000

# Serve the app
CMD ["npm", "start"]