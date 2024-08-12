#Spring Boot Book Seller

### Endpoints

#### Sign-Up

.....
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cookie: JSESSIONID=C06DF7AD349DC183D7BF079950AA8C4A

{
"name" : "user",
"username" : "user",
"password" : "user"
}
.....

#### Sign-In

.....
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cookie: JSESSIONID=30BA9ECAF4955761B6F5FE149B0BB45B

{
"username" : "user",
"password" : "user"
}
.....

#### Make-admin

......
PUT /api/internal/make-admin/admin1 HTTP/1.1
Host: localhost:8080
Authorization: ••••••
Cookie: JSESSIONID=5AE3622776BA18CC2B0FA189FFE15CCC
......

#### Save Book

......
POST /api/book HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: ••••••
Cookie: JSESSIONID=FFF5BB33244599C399365C6D6E1609EB

{
"title" : "book1",
"author" : "book1",
"description" : "book1",
"price" : 100
}
......

#### Delete Book

......
DELETE /api/book/2 HTTP/1.1
Host: localhost:8080
Authorization: ••••••
Cookie: JSESSIONID=FFF5BB33244599C399365C6D6E1609EB
......

#### Get All Books

......
GET /api/book HTTP/1.1
Host: localhost:8080
Cookie: JSESSIONID=FFF5BB33244599C399365C6D6E1609EB
......

#### Save Purchase

......
POST /api/purchase-history HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: ••••••
Cookie: JSESSIONID=FFF5BB33244599C399365C6D6E1609EB
{
"userId" : "3",
"bookId" : "2",
"price" : 20
}
......

#### Get User Purchases

......
GET /api/purchase-history HTTP/1.1
Host: localhost:8080
Authorization: ••••••
Cookie: JSESSIONID=FFF5BB33244599C399365C6D6E1609EB
......