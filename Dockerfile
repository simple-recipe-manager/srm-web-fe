FROM kyma/docker-nginx
RUN apt-get update
RUN apt-get install -y git
RUN git clone https://github.com/simple-recipe-manager/srm-web-fe.git
ADD srm-web-fe/src /var/www
CMD 'nginx'
