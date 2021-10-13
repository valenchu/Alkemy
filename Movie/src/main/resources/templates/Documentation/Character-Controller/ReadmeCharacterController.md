## Character-edit

[http://localhost:8080/character/editCharacter?id=1](http://localhost:8080/character/editCharacter?id=1)

- This PUT edit the character in BD. Use alone the data to edit, the other data erase them of the schema.

#### Schema

```json
{
  "imagen": "string",
  "name": "string",
  "age": 0,
  "weight": 2147483647,
  "history": "string"
}
```

<div align="center">
<img src="https://i.imgur.com/WWrOXym.png" width="80%" height="80%"/>
</div>

## Character-create

[http://localhost:8080/character/createCharacter](http://localhost:8080/character/createCharacter)

- Add a character to BD

#### Schema

```json
{
  "imagen": "string",
  "name": "string",
  "age": 0,-> Integer
  "weight": 2147483647,->Float 0.0
  "history": "string"
}
```
<div align="center">
<img src="https://i.imgur.com/jqqicoE.png" width="80%" height="80%"/>
</div>

## Character-filterFind

[http://localhost:8080/character/findCharacter?name=p&age=23&id_movie=10](http://localhost:8080/character/findCharacter?name=p&age=23&id_movie=10)

- This GET obtain a list of character for the filter

#### Schema

```json
  {
    "idChar": 0,-> Long
    "imagen": "String",
    "name": "String",
    "age": 0,-> Integer
    "weight": 0.0,-> Float
    "history": "String",
    "deleted": false-> Boolean
  }
```

<div align="center">
<img src="https://i.imgur.com/AHDp8wL.png" width="80%" height="80%"/>
</div>

## Character-characteres

[http://localhost:8080/character/characteres](http://localhost:8080/character/characteres)

- List reduct all characteres

<div align="center">
<img src="https://i.imgur.com/bn5Gngy.png" width="80%" height="80%"/>
</div>

## Character- allCharacter

[http://localhost:8080/character/characteresAll](http://localhost:8080/character/characteresAll)

- List complete all characteres

<div align="center">
<img src="https://i.imgur.com/ZtxJNva.png" width="80%" height="80%"/>
</div>

## Character-delete

[http://localhost:8080/character/deleteCharacter/0](http://localhost:8080/character/deleteCharacter/0)

- Delete character for ID


<div align="center">
<img src="https://i.imgur.com/jb08OyS.png" width="80%" height="80%"/>
</div>
