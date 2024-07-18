FROM node:18-alpine

WORKDIR /app

COPY package.json .

RUN npm update

COPY . .

RUN npm run build

CMD [ "npm", "run", "preview" ]