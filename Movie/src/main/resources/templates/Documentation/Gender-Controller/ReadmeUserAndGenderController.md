## User-register

[http://localhost:8080/register](http://localhost:8080/register)

- This register a user in BD with password encode and send you a mail with the data of user and password.

#### Schema
```json
{
  "userEmail": "string",-> @valid Email
  "password": "string"-> @valid min 6 characters
}
```

<div align="center">
<img src="https://raw.githubusercontent.com/valenchu/Pre-aceleracion-Valentin-Cassino/main/Movie/src/main/resources/templates/Documentation/unknown_2021.10.13-10.31.gif" width="80%" height="80%"/>
</div>


## User-login
- This login, the user use userEmail and password for the login in the app and active for you one token for ten hours, in the .gif teach you how this happens.

#### Schema
```json
    {
      "user": "email@email.com", -> @Valid Email
      "password": "123456" -> @Valid min value 6
    }
```


<div align="center">
<img src="https://raw.githubusercontent.com/valenchu/Pre-aceleracion-Valentin-Cassino/main/Movie/src/main/resources/templates/Documentation/unknown_2021.10.13-11.47.gif" width="80%" height="80%"/>
</div>

## Gender-create

[http://localhost:8080/gender/create](http://localhost:8080/gender/create)

- This controller only make is create a gender no more.

#### Schema

```json
{
  "name": "string",
  "imagen": "string"
}
```


<div align="center">
<img src="https://i.imgur.com/UFem1jK.png" width="80%" height="80%"/>
</div>

