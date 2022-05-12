# ACCOUNTS

### Description
Simple REST service storing bank users and their accounts.

### API
Endpoint:

`GET /v1/accounts?customerId=1` returns list of accounts of customer by customerId

Response example: 

```json
[
{
"id": 1,
"nrb": "72249000059957936727967706",
"currency": "PLN",
"availableFunds": 1000.00
},
{
"id": 2,
"nrb": "66666000059957936727967706",
"currency": "EUR",
"availableFunds": 666.00
}
]
```

### Database
Local MySql database with 2 tables: 

* customer
* account

Relation one-to-many.

#### CUSTOMER

| Field       | Type   | Null | Key | Default | Extra          |
|:---:|:---:|:---:|:---:|:---:|:---:|
| id          | bigint | NO   | PRI | NULL    | auto_increment |
| customer_id | bigint | YES  |     | NULL    |                |

#### ACCOUNT

| Field           | Type          | Null | Key | Default | Extra          |
|:---:|:---:|:---:|:---:|:---:|:---:|
| id              | bigint        | NO   | PRI | NULL    | auto_increment |
| available_funds | decimal(19,2) | YES  |     | NULL    |                |
| currency        | varchar(255)  | YES  |     | NULL    |                |
| customer_id     | bigint        | YES  |     | NULL    | FK             |
| nrb             | varchar(255)  | YES  |     | NULL    |                |




