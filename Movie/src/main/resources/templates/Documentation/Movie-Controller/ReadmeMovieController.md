## Movie-enrroll

[http://localhost:8080/movie/enrrollMovToChar](http://localhost:8080/movie/enrrollMovToChar)

- This connect the movie id with character id for join.

<div align="center">
<img src="https://i.imgur.com/IxX28Jr.png" width="80%" height="80%"/>
</div>

## Movie-edit

[http://localhost:8080/movie/editMovie](http://localhost:8080/movie/editMovie)

#### Schema

- Clear all the parameters of the schema and leave alone the than to you use to edit.

```javascript
{
  "imagen": "string",
  "title": "string",
  "dateCreation": "2021-10-12",
  "qualification": 0 Example-> this is Float 1.2 or 2.3 never 1,2 or 2,3
}
```

<div align="center">
<img src="https://i.imgur.com/rIe7o8K.png" width="80%" height="80%"/>
</div>


## Create-mov-and-gender

[http://localhost:8080/movie/create_mov_gender](http://localhost:8080/movie/create_mov_gender)

- This create a movie with gender in BD.

#### Schema

```javascript
{
  "imagen": "string",
  "title": "string",
  "dateCreation": "2021-10-12",
  "qualification": 0 Example-> this is Float 1.2 or 2.3 never 1,2 or 2,3
}
```

<div align="center">
<img src="https://i.imgur.com/9Lefst5.png" width="80%" height="80%"/>
</div>

## Movie-movies

[http://localhost:8080/movie/movies](http://localhost:8080/movie/movies)

- This obtain a list reduct movie of BD.

#### Schema

   ```javascript
  {
    "imagen": "Strign",
    "title": "String",
    "dateCreation": "2021-10-12"->Date
  },
```
<div align="center">
<img src="https://i.imgur.com/YAQL8wu.png" width="80%" height="80%"/>
</div>

## Movie-movieAll

[http://localhost:8080/movie/moviesAll](http://localhost:8080/movie/moviesAll)

- This obtain a list of movie but this list is with all data.

#### Schema

- Returns a list in this schema format.

```javascript
{
  "idMov": 0,
  "imagen": "string",
  "title": "string",
  "dateCreation": "2021-10-13",
  "qualification": 0,
  "deleted": true,
  "gender": [
    {
      "id_gender": 0,
      "name": "string",
      "imagen": "string",
      "deleted": true,
      "movie": [
        "string"
      ]
    }
  ],
  "character": [
    {
      "idChar": 0,
      "imagen": "string",
      "name": "string",
      "age": 0,
      "weight": 0,
      "history": "string",
      "deleted": true,
      "movie": [
        "string"
      ]
    }
  ]
}
```

<div align="center">
<img src="https://i.imgur.com/LnUtYJV.png" width="80%" height="80%"/>

## Movie-movieFilter

[http://localhost:8080/movie/movieFilter?name=po&idGender=4&order=DESC](http://localhost:8080/movie/movieFilter?name=po&idGender=4&order=DESC)

- Returns a list filtered for, Name of movie, ID of gender and ASC or DESC.

<div align="center">
<img src="https://i.imgur.com/sCQyI7L.png" width="80%" height="80%"/>

## Movie-deletedMovie

[http://localhost:8080/movie/deleteMovie/2](http://localhost:8080/movie/deleteMovie/2)

- This delete a movie for the ID, the delete is a soft delete.


<div align="center">
<img src="https://i.imgur.com/N5rzweF.png" width="80%" height="80%"/>
