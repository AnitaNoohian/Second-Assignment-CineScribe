# Get Movies & Actors Details
## Description
with this program you can find some information about any movie/series and actor/actress you want 
## Parts of the project
It's made of three classes(main,Movie,Actors)  
Main includes the menu and inputs and outputs are write in this part  
Movie includes all the functions that take the informations of the movie from the sites and give it to us in our desire type   
Actors is exactly like the movie, it just take informations about exact actor and give it back.   
In my code i show you the year, time of release, name of director, list of actors, rating, imdb votes and the genre of a movie or series; and show the age, the nationality, the gender, his/her networth, the height, the birthday, the day of the death(if he/she isn't alive) of a actor or actress. 

## The Challenges I faced
I had a problem getting some informations like actors list, Internet movie database, actors information,  etc from site.  
For example: The api-ninjas site give the information as a json back to us but there is an extra square bracket so it made an error in mycode, to solve this problem i made a substring from the json and removed the extra bracket.  
Or the imdbvotes was defined as string and have "," in the middle of the numbers but i wanted to return imdbvotes as a integer so i got it as an string and then used parseInt() to convert it to integer.  
Or actors list was defined as an array of string but i wanted to save the actor's names in the arraylist so i got them as an array of string then, i wrote a "for" loop to put datas from the array into the arraylist.   
Or the value of internet movie information was saved in a json that was stored in another json; for using this information i got the rating list as an JSONArray and then found the source it names "internet movie information" to got the value of it.  
One of my problems was with errors of the project so i wroted errorhandling functions for each class to check if the user gave a wrong name the project wanted another one until user gave the true name.