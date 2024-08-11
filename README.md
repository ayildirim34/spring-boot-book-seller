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