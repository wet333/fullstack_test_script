FROM node:18 as build
WORKDIR /app
COPY react-app/package*.json ./
RUN npm install
COPY react-app ./
RUN npm run build

# Development stage
FROM node:18 as development
WORKDIR /app
COPY --from=build /app ./
CMD ["npm", "start"]

# Production stage
FROM nginx:alpine as production
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
