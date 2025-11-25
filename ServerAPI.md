# API调用
所有调用应该采取`application/json`的Content-Type，并且请求体应该是一个JSON对象。
为保证中文支持，建议使用UTF-8编码。

所有返回具有以下格式(参见ApiResponse定义):

| success           | message     | data                    |
|-------------------|-------------|-------------------------|
| true/false，是否请求成功 | string，返回消息 | object，一般为JSON格式，返回数据详情 |

**注意**: 所有时间字段均采用ISO 8601格式的字符串表示，例如："2024-01-01T12:00:00Z"。

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
    "gender": "boolean",
    "studentNo": "int",
    "department": "int",
    "createdTime": "time",
    "role" : "学生/管理员"
  }
```
#### 注册
- **URL**: `/api/auth/register`
- **方法**: `POST`
- **请求体**
```json
{
    "loginName": "string",
    "password": "string",
    "email": "string",
    "phone": "string",
    "realName": "string",
    "gender": "男/女",
    "studentNo": "int",
    "department": "int",
    "createdTime": "time",
    "role" : "学生/管理员"
}
```
- **响应**:

| code,message        | 情况      |
|---------------------|---------|
| 200,REGISTER_SUCCESS | 注册成功    |
| 400,REGISTER_FAILED  | 注册失败    |
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
    "createdTime": "time",
    "role" : "学生/管理员"
  }
```
#### 获取全部用户信息
- **URL**: `/api/users/getAll`
- **方法**: `GET`
- **响应**:

| code,message              | 情况      |
|---------------------------|---------|
| 200,GET_ALL_USERS_SUCCESS | 请求成功    |
- **数据**:
```json
[
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
        "createdTime": "time",
        "role" : "学生/管理员"
    }
]
```

#### 更新用户信息
- **URL**: `/api/users/update/{userId}`
- **方法**: `PUT`
- **请求体**
```json
{
    "loginName": "string",
    "password": "string",
    "email": "string",
    "phone": "string",
    "realName": "string",
    "gender": "男/女",
    "studentNo": "int",
    "department": "int",
    "createdTime": "time",
    "role" : "学生/管理员"
}
```
- **响应**:

| code,message                 | 情况      |
|------------------------------|---------|
| 200,USER_UPDATE_SUCCESSFULLY | 更新成功    |
| 400,USERNAME_EXISTS          | 用户名已存在  |
| 400,EMAIL_EXISTS             | 邮箱已存在   |
| 400,PHONE_EXISTS             | 电话号码已存在  |
| 400，STUDENT_NO_EXISTS        | 学号已存在   |
| 400,USER_UPDATE_FAILED       | 更新失败    |

#### 删除用户
- **URL**: `/api/auth/delete/{userId}`
- **方法**: `DELETE`
- **响应**:

| code,message                 | 情况      |
|------------------------------|---------|
| 200,USER_DELETE_SUCCESSFULLY | 删除成功    |

#### 修改用户密码
- **URL**: `/api/auth/modifyPwd`
- **方法**: `POST`
- **请求体**
```json
{
    "loginName": "string",
    "email": "int",
    "newPwd": "string"
}
```
- **响应**:

| code,message           | 情况    |
|------------------------|-------|
| 200,PWD_MODIFY_SUCCESS | 修改成功  |
| 400,USER_NOT_EXIST     | 用户不存在 |
| 400,EMAIL_INCORRECT    | 邮箱不正确 |


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

#### 查看指定ID座位的详细信息
- **URL**: `/api/seats/{seatId}`
- **方法**:`GET`
- **响应**

| code,message       | 情况      |
|--------------------|---------|
| 200,GET_SEAT_SUCCESS  | 请求成功    |
| 404,SEAT_NOT_FOUND | 不存在指定座位 |
- **数据**:

```json
{
  "seatId": "int",
  "seatNo" : "string",
  "floor": "string",
  "func": "自习区/讨论区/电源区",
  "capacity": "int",
  "status": "可用/维护/被占用"
}
```

#### 获取全部预约
- **URL**: `/api/seats/reservations/getAll`
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

- **URL**: `/api/seats/reservations/{reservationId}`
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
- **URL**: `/api/seats/reservations/user/{userId}`
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
#### 添加预约记录
- **URL**: `/api/seats/reservations/createReservation`
- **方法**: `POST`
- **请求体**:
```json
{
  "userId": "int",
  "seatId": "int",
  "startTime": "time",
  "endTime": "time"
}
```
- **响应**:

| code,message                        | 情况      |
|-------------------------------------|---------|
| 200,CREATE_SEAT_RESERVATION_SUCCESS | 预约成功    |
| 400,CREATE_SEAT_RESERVATION_FAILED  | 预约失败    |

#### 签到
- **URL**: `/api/seats/reservations/checkin/{reservationId}`
- **方法**: `PUT`
- **响应**:

| code,message                         | 情况      |
|--------------------------------------|---------|
| 200,CHECKIN_SEAT_RESERVATION_SUCCESS | 签到成功    |
| 400,CHECKIN_SEAT_RESERVATION_FAILED  | 签到失败    |

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
- **URL**: `/api/books/searchTitle/{title}`
- **方法**: `GET`
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
- **URL**: `/api/books/delete/{id}`
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
#### 新增图书副本
- **URL**: `/api/book-locations/createBookLocation`
- **方法**: `POST`
- **请求体**:
```json
{
    "barcode": "string",
    "bookId": "int",
    "branch": "string",
    "floor": "string",
    "shelfNo": "string",
    "cellNo": "string",
    "status": "在馆/借出/丢失",
    "price": "BigDecimal",
    "damageNote": "string"
}
```
- **响应**:

| code,message              | 情况                |
|---------------------------|-------------------|
| 200,BOOK_LOCATION_CREATED | 创建成功     |

#### 更新图书副本信息
- **URL**: `/api/book-locations/update/{barcode}`
- **方法**: `PUT`
- **请求体**:
```json
{
    "branch": "string",
    "floor": "string",
    "shelfNo": "string",
    "cellNo": "string",
    "status": "在馆/借出/丢失",
    "price": "BigDecimal",
    "damageNote": "string"
}
```
- **响应**:

| code,message              | 情况                |
|---------------------------|-------------------|
| 200,BOOK_LOCATION_UPDATED | 更新成功     |
| 404,BOOK_LOCATION_NOT_FOUND | 未找到指定图书副本 |

#### 删除图书副本
- **URL**: `/api/book-locations/delete/{barcode}`
- **方法**: `DELETE`
- **响应**:

| code,message              | 情况                |
|---------------------------|-------------------|
| 200,BOOK_LOCATION_DELETED | 删除成功     |

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
    "status" : "借出中/已归还/逾期中/挂失中/异常",
    "renewCount": "int",
    "lastRenewTime": "time"
  }
]
```
#### 获取指定用户全部借阅记录
- **URL**: `/api/borrows/user/{userId}`
- **方法**: `GET`
- **响应**:

| code,message      | 情况                |
|-------------------|-------------------|
| 200,FETCH_SUCCESS | 请求成功     |
|400,BORROW_NOT_FOUND| 未找到借阅记录 |
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
    "status" : "借出中/已归还/逾期中/挂失中/异常",
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

#### 变更借阅状态
- **URL**: `/api/borrows/setStatus`
- **方法**: `POST`
- **请求体**:
```json
{
  "borrowId": "int",
  "status": "借出中/已归还/逾期中/挂失中/异常"
}
```
- **响应**:

| code,message            | 情况                |
|-------------------------|-------------------|
| 200,STATUS_UPDATE_SUCCESS | 变更成功     |
| 400,STATUS_UPDATE_FAILED  | 变更失败     |

#### 续借
- **URL**: `/api/borrows/renew`
- **方法**: `POST`
- **请求体**:
```json
{
  "borrowId": "int",
  "days": "int"
}
```
- **响应**:

| code,message            | 情况                |
|-------------------------|-------------------|
| 200,RENEW_SUCCESS | 续借成功     |
| 400,RENEW_FAILED  | 续借失败     |

## 图书评价管理

分类:`/api/book-reviews`

#### 获取全部评价
- **URL**: `/api/book-reviews/allComments`
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
#### 获取指定用户的评价
- **URL**: `/api/book-reviews/user/{userId}`
- **方法**:`GET`
- **响应**
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
      "updatedAt": "time"
    }
]
```

#### 创建评价
- **URL**: `/api/book-reviews/comment`
- **方法**:`POST`
- **请求体**:
```json
{
  "userId": "int",
  "bookId": "int",
  "title": "string",
  "rating":"1~5",
  "status" : "Public/Hidden/Blocked",
  "comment":"string"
}
```
- **响应**

| code,message            | 情况      |
|-------------------------|---------|
| 201,BOOK_REVIEW_CREATED | 创建成功    |
- **数据**:

```json
{
  "reviewId": "int",
  "userId": "int",
  "bookId": "int",
  "rating": "int",
  "reviewTitle": "string",
  "reviewContent": "string",
  "imageAttachments": "json",
  "status" : "Public/Hidden/Blocked",
  "createdAt": "time",
  "updatedAt": "time"
}
```
#### 更新评价状态
- **URL**: `/api/book-reviews/update/{reviewId}`
- **方法**:`PUT`
- **请求体**:
```json
{
  "userId": "int",
  "bookId": "int",
  "title": "string",
  "rating":"1~5",
  "status" : "Public/Hidden/Blocked",
  "comment":"string"
}
```
- **响应**

| code,message       | 情况      |
|--------------------|---------|
| 200,BOOK_REVIEW_UPDATED  | 更新成功    |
| 404,BOOK_REVIEW_NOT_FOUND | 未找到指定评价 |

#### 删除评价
- **URL**: `/api/book-reviews/delete/{reviewId}`
- **方法**:`DELETE`
- **响应**

| code,message       | 情况      |
|--------------------|---------|
| 200,BOOK_REVIEW_DELETED  | 删除成功    |
| 404,BOOK_REVIEW_NOT_FOUND | 未找到指定评价 |