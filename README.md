
# Spring Boot ToDo Application

Welcome to Spring Boot ToDo Application, an innovative Spring project designed to elevate your Todo application experience through a robust RESTful web service. This dynamic platform empowers users with essential functionalities, seamlessly integrating with your Todo application for enhanced task management.

This project boasts a comprehensive set of features, ensuring a seamless interaction with your Todo app. Users can effortlessly add new records, retrieve all existing records, delete specific records by ID, and locate particular entries based on their unique identifiers. This level of versatility provides a user-friendly and efficient way to manage your to-do lists.

Taking it a step further, we've introduced a specialized endpoint that allows users to retrieve the latest entries in the Todo application. This feature enables users to stay up-to-date with their tasks and ensures a real-time overview of the most recent additions to their to-do lists.

With a focus on simplicity, performance, and functionality, it stands as the ideal solution for integrating a powerful RESTful web service into your Todo application. Experience the ease of task management like never before, courtesy of our cutting-edge Spring project.
## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![Java](https://img.shields.io/badge/Java-21-red.svg)](https://choosealicense.com/licenses/mit/)

[![Spring Boot](https://img.shields.io/badge/spring-3.2.0-green.svg)](http://www.gnu.org/licenses/agpl-3.0)


## API Reference

#### Get all Records

```http
  GET /getAll
```

#### Get Record by Id

```http
  GET /getRecordById/{id}
```

| Path Variable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of item to fetch |


#### Add a Record

```http
  POST /add
```

| Body      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Object`      | `integer` | **Required**. JSON Object in body |


#### Delete a Record

```http
  PUT /delete/{id}
```

| Path Variable      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of item to delete |


#### Get most Recent Entries

```http
  PUT /getMostRecentEntries/
```

| Request Param      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `limit`      | `integer` | **Required**. give the max limit of entries to fetch |

## Documentation

You can get the postman collection [here](https://github.com/shubyaa/Spring_REST/blob/master/Spring%20-%20Rest.postman_collection.json).



## 🚀 About Me
### I'm a freelancer and also a developer who can develop :
- Mobile Applications
- React Applications
- Android Applications
- iOS Applications
- Flutter Applications
- Backend Tech
- Django Framework
- Flask API
- Express APIs

### Design Databases like
- MySQL
- MongoDB
- Sqlite3
- PostgreSQL
- Firebase
- DynamoDB


## Support

For any help, email shubhped0712@gmail.com or message me on [linkedin](https://www.linkedin.com/in/shubham-pednekar-573369213).

