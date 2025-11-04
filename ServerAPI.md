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