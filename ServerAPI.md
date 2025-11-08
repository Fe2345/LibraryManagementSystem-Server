# API调用
所有调用应该采取`application/json`的Content-Type，并且请求体应该是一个JSON对象。
为保证中文支持，建议使用UTF-8编码。

所有返回具有以下格式(参见ApiResponse定义):

| success           | message     | data                    |
|-------------------|-------------|-------------------------|
| true/false，是否请求成功 | string，返回消息 | object，一般为JSON格式，返回数据详情 |

## 用户认证
分类：`/api/auth`
#### 登录
- **URL**: `/api/auth/login`
- **方法**: `POST`
- **请求体**:
```json
    {
      "username": "string",
      "password": "string"
    }
```
- **响应**:

| code,message       | 情况            |
|--------------------|---------------|
| 200,LOGIN_SUCCESS  | 登录成功，同时返回用户信息 |
| 401,PWD_ERROR      | 密码错误          |
| 404,USER_NOT_EXIST | 用户不存在         |

- **数据**:

```json
{
    "userId": "int",
    "loginName": "string",
    "password": "string",
    "email": "string",
    "phone": "string",
    "realName": "string",
    "gender": "男/女",
    "studentNo": "int",
    "department": "int",
    "createdTime": "time"
  }
```

## 座位预约
分类：`/api/seat`

#### 查看座位预约状态

- **URL**: `/api/seat/reservation/{reservationId}`
- **方法**:`GET`
- **响应**

| code,message       | 情况      |
|--------------------|---------|
| 200,GET_SEAT_RESERVATION_SUCCESS  | 请求成功    |
| 404,SEAT_RESERVATION_NOT_FOUND | 不存在指定座位的预约 |

- **数据**:

```json
{
  "reservationId": "int",
  "user": {
    "userId": "int",
    "loginName": "string",
    "password": "string",
    "email": "string",
    "phone": "string",
    "realName": "string",
    "gender": "男/女",
    "studentNo": "int",
    "department": "int",
    "createdTime": "time"
  },
  "seat": {
    "seatId": "int",
    "floor": "string",
    "func": "自习区/讨论区/电源区",
    "capacity": "int",
    "status": "可用/维护/被占用"
  },
  "startTime": "time",
  "endTime": "time",
  "status": "待签到/已签到/已取消/已完成/爽约",
  "checkinTime": "time",
  "checkoutTime": "time"
}
```
#### 切换预约状态
- **URL**: `/api/seat/updateStatus/{seatId}`
- **方法**: `PUT`
- **响应**:

| code,message       | 情况                  |
|--------------------|---------------------|
| 200,SEAT_STATUS_UPDATED  | 更新成功                |
| 404,SEAT_NOT_FOUND | 指定座位不存在或不处于可用/已占用状态 |
#### 切换维护状态

- **URL**: `/api/seat/toggleMaintain/{seatId}`
- **方法**: `PUT`
- **响应**:

| code,message       | 情况                 |
|--------------------|--------------------|
| 200,SEAT_STATUS_UPDATED  | 更新成功               |
| 404,SEAT_NOT_FOUND | 指定座位不存在或不处于维护/可用状态 |

## 图书管理

分类：`/api/books`
#### 获取全部图书信息
- **URL**: `/api/books/getAll`
- **方法**: `GET`
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,GET_ALL_SUCCESS  | 请求成功    |
  
- **数据**:

```json
[
  {
    "bookId": "int",
    "title": "string",
    "authors": "string",
    "subtitle": "string",
    "isbn": "string",
    "publisher": "string",
    "pubYear": "int",
    "language": "string",
    "keywords": "string",
    "summary": "string",
    "pages": "int",
    "edition": "string",
    "totalCopies": "int",
    "availableCopies": "int",
    "status" : "上架/下架",
    "storageTime": "time",
    "updatedAt": "time"
  }
]
```
#### 按照书名搜索图书
- **URL**: `/api/books/searchByTitle/{title}`
- **方法**: `POST`
- **请求体**:
```json
{
  "title": "string"
}
```
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,SEARCH_SUCCESS  | 请求成功    |
- **数据**:

```json
  {
    "bookId": "int",
    "title": "string",
    "authors": "string",
    "subtitle": "string",
    "isbn": "string",
    "publisher": "string",
    "pubYear": "int",
    "language": "string",
    "keywords": "string",
    "summary": "string",
    "pages": "int",
    "edition": "string",
    "totalCopies": "int",
    "availableCopies": "int",
    "status" : "上架/下架",
    "storageTime": "time",
    "updatedAt": "time"
  }
```
#### 按照ID范围搜索图书
- **URL**: `/api/books/rangeSearch`
- **方法**: `POST`
- **请求体**:
```json
{
  "startId": "int",
  "endId": "int"
}
```
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,RANGE_SEARCH_SUCCESS  | 请求成功    |

#### 复杂检索
- **URL**: `/api/books/complexSearch`
- **方法**: `POST`
- **请求体**:
```json
{
  "title": "string",
  "author": "string",
  "isbn": "string",
  "publisher": "string",
  "yearFrom": "int",
  "yearTo": "int",
  "status": "在馆/借出/丢失"
}
```
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,COMPLEX_SEARCH_SUCCESS  | 请求成功    |
- **数据**:
```json
[
  {
    "bookId": "int",
    "title": "string",
    "authors": "string",
    "subtitle": "string",
    "isbn": "string",
    "publisher": "string",
    "pubYear": "int",
    "language": "string",
    "keywords": "string",
    "summary": "string",
    "pages": "int",
    "edition": "string",
    "totalCopies": "int",
    "availableCopies": "int",
    "status" : "上架/下架",
    "storageTime": "time",
    "updatedAt": "time"
  }
]
```
#### 添加图书信息

添加时，自动生成storageTime

- **URL**: `/api/books/addBook`
- **方法**: `POST`
- **请求体**:
```json
{
  "title": "string",
  "authors": "string",
  "subtitle": "string",
  "isbn": "string",
  "publisher": "string",
  "pubYear": "int",
  "language": "string",
  "keywords": "string",
  "summary": "string",
  "pages": "int",
  "edition": "string",
  "totalCopies": "int",
  "availableCopies": "int"
}
```
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,ADD_BOOK_SUCCESS  | 添加成功    |
| 200,ADD_BOOK_FAILED   | 添加失败    |

- **数据**

直接返回一个int数据，即数据库中书籍的ID

#### 更新图书信息

更新时会保留原始的storageTime，仅更新其他字段，updatedAt时间由后端自动生成。

- **URL**: `/api/books/updateBook/{id}`
- **方法**: `POST`
- **请求体**:
```json
{
  "title": "string",
  "authors": "string",
  "subtitle": "string",
  "isbn": "string",
  "publisher": "string",
  "pubYear": "int",
  "language": "string",
  "keywords": "string",
  "summary": "string",
  "pages": "int",
  "edition": "string",
  "totalCopies": "int",
  "availableCopies": "int"
}
```
- **响应**:

| code,message            | 情况   |
|-------------------------|------|
| 200,UPDATE_BOOK_SUCCESS | 更新成功 |
| 200,UPDATE_BOOK_FAILED  | 更新失败 |

#### 删除图书
- **URL**: `/api/books/deleteBook/{id}`
- **方法**: `DELETE`
- **响应**:

| code,message            | 情况   |
|-------------------------|------|
| 200,DELETE_BOOK_SUCCESS | 删除成功 |

#### 变更图书状态
- **URL**: `/api/books/updateStatus`
- **方法**: `POST`
- **请求体**:
```json
{
  "bookId": "int",
  "bookStatus": "上架/下架"
}
```
- **响应**:

| code,message            | 情况   |
|-------------------------|------|
| 200,UPDATE_STATUS_SUCCESS | 变更成功 |
| 404,UPDATE_STATUS_FAILED  | 变更失败 |

## 图书位置信息

#### 查询指定ID图书的全部副本
- **URL**: `/api/book-locations/book/{bookId}`
- **方法**: `GET`
- **响应**:

| code,message            | 情况                |
|-------------------------|-------------------|
| 200,FETCH_SUCCESS | 请求成功     |
- **数据**

```json
[
  {
    "barcode": "string",
    "bookId": "int",
    "branch": "string",
    "floor": "string",
    "shelfNo": "string",
    "cellNo": "string",
    "status": "在馆/借出/丢失",
    "price": "BigDecimal",
    "damageNote": "string",
    "createdAt": "time",
    "updatedAt": "time"
  }
]
```