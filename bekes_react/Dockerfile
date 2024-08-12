FROM node:22-alpine3.19

WORKDIR /app

COPY ./frontend/package.json .

RUN npm install

COPY ./frontend .

RUN npm run build

CMD [ "npm", "run", "preview" ]