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
## 座位管理

分类：`/api/seats`

#### 查看全部座位状态
- **URL**: `/api/seats/getAll`
- **方法**: `GET`
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,GET_ALL_SEATS_SUCCESS  | 请求成功    |
- **数据**:

```json
[
  {
    "seatId": "int",
    "seatNo" : "string",
    "floor": "string",
    "func": "自习区/讨论区/电源区",
    "capacity": "int",
    "status": "可用/维护/被占用"
  }
]
```
#### 获取可用座位数
- **URL**: `/api/seats/availableCount`
- **方法**: `GET`
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,GET_AVAILABLE_SEAT_COUNT_SUCCESS  | 请求成功    |
- **数据**:

返回一个整数，表示当前可用座位数

#### 获取全部预约
- **URL**: `/api/seats/reservation/getAll`
- **方法**:`GET`
- **响应**

| code,message      | 情况      |
|-------------------|---------|
| 200,FETCH_SUCCESS | 请求成功    |

- **数据**:

```json
[
    {
      "reservationId": "int",
      "userId": "int",
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
]
```

#### 查看指定预约ID的状态

- **URL**: `/api/seats/reservation/{reservationId}`
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
  "userId": "int",
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
#### 查找指定ID用户的预约记录
- **URL**: `/api/seats/reservation/user/{userId}`
- **方法**:`GET`
- **响应**

| code,message                             | 情况      |
|------------------------------------------|---------|
| 200,GET_SEAT_RESERVATION_BY_USER_SUCCESS | 请求成功    |

- **数据**:

```json
[
    {
      "reservationId": "int",
      "userId": "int",
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
]
```

#### 切换预约状态
- **URL**: `/api/seats/updateStatus/{seatId}`
- **方法**: `PUT`
- **响应**:

| code,message       | 情况                  |
|--------------------|---------------------|
| 200,SEAT_STATUS_UPDATED  | 更新成功                |
| 404,SEAT_NOT_FOUND | 指定座位不存在或不处于可用/已占用状态 |
#### 切换维护状态

- **URL**: `/api/seats/toggleMaintain/{seatId}`
- **方法**: `PUT`
- **响应**:

| code,message       | 情况                 |
|--------------------|--------------------|
| 200,SEAT_STATUS_UPDATED  | 更新成功               |
| 404,SEAT_NOT_FOUND | 指定座位不存在或不处于维护/可用状态 |

## 座位预约管理
分类：`/api/seats/reservations`

#### 切换预约状态
- **URL**: `/api/seats/reservations/setStatus`
- **方法**: `POST`
- **请求体**:
```json
{
  "reservationId": "int",
  "status": "待签到/已签到/已取消/已完成/爽约"
}
```
- **响应**:

| code,message       | 情况      |
|--------------------|---------|
| 200,TOGGLE_SEAT_RESERVATION_STATUS_SUCCESS  | 请求成功   |
| 400,TOGGLE_FAILED  | 请求失败   |

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

## 借阅管理
分类：`/api/borrows`

#### 获取全部借阅
- **URL**: `/api/borrows/getAll`
- **方法**: `GET`
- **响应**:

| code,message      | 情况                |
|-------------------|-------------------|
| 200,FETCH_SUCCESS | 请求成功     |
- **数据**

```json
[
  {
    "borrowId": "int",
    "userId": "int",
    "title": "string",
    "barCode": "string",
    "borrowTime": "time",
    "dueTime": "time",
    "returnTime": "time",
    "renewCount": "int",
    "lastRenewTime": "time"
  }
]
```
#### 获取指定用户当前在借图书数
- **URL**: `/api/borrows/borrowed/{userId}`
- **方法**: `GET`
- **响应**:

| code,message            | 情况                |
|-------------------------|-------------------|
| 200,COUNT_FETCHED | 请求成功     |

#### 新增借阅
- **URL**: `/api/borrows/borrow`
- **方法**: `POST`
- **请求体**:
```json
{
    "userId": "int",
    "barCode": "string",
    "days": "int"
}
```
- **响应**:

| code,message            | 情况                |
|-------------------------|-------------------|
| 200,BORROW_SUCCESS | 借阅成功     |
| 400,BORROW_FAILED  | 借阅失败     |
## 图书评价管理

分类:`/api/book-reviews`

#### 获取全部评价
- **URL**: `/api/seat/book-reviews/allComments`
- **方法**:`GET`
- **响应**

| code,message       | 情况      |
|--------------------|---------|
| 200,ALL_BOOK_REVIEWS_FETCHED  | 请求成功    |

- **数据**:

```json
[
    {
      "reviewId": "int",
      "user": "int",
      "bookId": "int",
      "rating": "int",
      "reviewTitle": "string",
      "reviewContent": "string",
      "imageAttachments": "Public/Hidden/Blocked",
      "createdAt": "time",
      "updatedAt": "time",
      "isbn": "string",
      "username": "string"
    }
]
```