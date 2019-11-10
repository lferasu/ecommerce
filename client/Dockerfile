FROM node:12.2.0
#FROM node:10.8.0 as build-stage

#EXPOSE 8081
# set working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /app/package.json
RUN npm install
#RUN npm install -g @angular/cli@7.3.9

# add app
COPY . /app

# start app
#CMD ng serve

RUN npm run build -- --output-path=./dist/out --configuration $configuration

# Stage 1, based on Nginx, to have only the compiled app, ready for production with Nginx
FROM nginx:1.15
#Copy ci-dashboard-dist
COPY /app/dist/out/ /usr/share/nginx/html
#Copy default nginx configuration
COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf
