## Movie-erroll

[http://localhost:8080/movie/enrrollMovToChar?idMov=1&idChar=2](http://localhost:8080/movie/enrrollMovToChar?idMov=1&idChar=2)

- This join data of table movie with table character in the DB.

<div align="center">
<img src="https://i.imgur.com/IxX28Jr.png" width="80%" height="80%"/>
</div>


## Movie-edit

[http://localhost:8080/movie/editMovie?idMovie=0](http://localhost:8080/movie/editMovie?idMovie=0)

-This edit the table in DB. Insert the fields only you want to edit.

#### Schema

```json
{
  "imagen": "string",
  "title": "string",
  "dateCreation": "2021-10-13",-> date
  "qualification": 5-> max 5 min 0
}
```


<div align="center">
<img src="https://i.imgur.com/rIe7o8K.png" width="80%" height="80%"/>
</div>

## Movie-create

[http://localhost:8080/movie/create_mov_gender?id_gender=0](http://localhost:8080/movie/create_mov_gender?id_gender=0)

- This create a movie with the gender in DB. Insert in id the id gender to join with movie in DB.

#### Schema

```json
{
  "imagen": "string",
  "title": "string",
  "dateCreation": "2021-10-13",
  "qualification": 5
}
```


<div align="center">
<img src="https://i.imgur.com/UNkp1r0.png" width="80%" height="80%"/>
</div>

## Movie-movies

[http://localhost:8080/movie/movies](http://localhost:8080/movie/movies)

- This GET a list compress of fields specific to movie.

#### Schema

```json
  {
    "imagen": "String",
    "title": "String",
    "dateCreation": "2021-10-12" -> date
  }
```


<div align="center">
<img src="https://i.imgur.com/YDmb2qb.png" width="80%" height="80%"/>
</div>

## Movie-moviesAll

[http://localhost:8080/movie/moviesAll](http://localhost:8080/movie/moviesAll)

- This obtain a list with all movie fields of DB.

<div align="center">
<img src="https://i.imgur.com/HJTkiIF.png" width="80%" height="80%"/>
</div>

## Movie-movieFilter

[http://localhost:8080/movie/movieFilter?name=po&idGender=1&order=DESC](http://localhost:8080/movie/movieFilter?name=po&idGender=1&order=DESC)

- This obtain a list of movie for data filter, Name of movie, idGender of gender and order by ASC or DESC, default value DESC.


<div align="center">
<img src="https://i.imgur.com/32qDXAp.png" width="80%" height="80%"/>
</div>

## Movie-delete

[http://localhost:8080/movie/deleteMovie/0](http://localhost:8080/movie/deleteMovie/0)

- This delete a movie to BD for ID. The delete is SOFT DELETE.


<div align="center">
<img src="https://i.imgur.com/RcVpzdJ.png" width="80%" height="80%"/>
</div>