# Étape 1: Build de l'application React
FROM node:18-alpine AS build
WORKDIR /app
COPY ./frontend/package.json .
RUN npm install
COPY ./frontend  .  
RUN npm run build

# Étape 2: Serveur Nginx pour servir l'application
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html
COPY ./frontend/env.sh /docker-entrypoint.d/env.sh
RUN chmod +x /docker-entrypoint.d/env.sh
EXPOSE 80
CMD ["/docker-entrypoint.d/env.sh","nginx", "-g", "daemon off;"]