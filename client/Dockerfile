### STAGE 1: Build ###

FROM node:8.11.1-alpine as builder

# Preparing working environment.
RUN mkdir -p /usr/src/client
WORKDIR /usr/src/client

# Installing dependencies.
COPY package*.json /usr/src/client/
RUN npm install

# Copy openhome-panel source into image.
COPY . /usr/src/client

# Building app.
RUN npm run-script build

### STAGE 2: Setup ###

FROM nginx:1.13.12-alpine

# Removing nginx default page.
RUN rm -rf /usr/share/nginx/html/*

# Copying nginx configuration.
COPY /nginx/nginx.conf /etc/nginx/conf.d/default.conf

# Copying openhome-panel source into web server root.
COPY --from=builder /usr/src/client/public /usr/share/nginx/html

# Exposing ports.
EXPOSE 8081

# Starting server.
CMD ["nginx", "-g", "daemon off;"]