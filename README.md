# levelsbeyondCC
LevelsBeyond Coding Challenge How to use
Part 1: backend
1. After downloading the github project make sure maven is downloaded on your terminal
2. Through terminal, enter the backend file where pom.xml is located and enter the command ```mvn spring-boot:run```
3. Once the server is running, open the webpage [http://localhost:8080/api/notes](http://localhost:8080/api/notes) and open another terminal window for your curl requests.
4. To create a new note, enter the terminal command ```curl -i -H "Content-Type: application/json" -X POST -d '{"body" : "what you want to write in the note"}' http://localhost:8080/api/notes``` then refresh the webpage to see the results.
5. To edit an existing note, enter the terminal command ```curl -i -H "Content-Type: application/json" -X POST -d '{"body" : "what you want in the new note"}' http://localhost:8080/api/notes/1``` with the last number being the index of the note you wish to edit, then refresh the webpage to see the results.If you enter a index that does not exist in the repository, it will instead make a new note.
6. To pull up a note, enter the terminal command ```curl -i -H "Content-Type: application/json" -X GET -d http://localhost:8080/api/notes/1``` with the last number being the index of the note you wish to see.
7. To pull up all notes, enter the terminal command ```curl -i -H "Content-Type: application/json" -X GET -d http://localhost:8080/api/notes```
8. To delete a note, enter the terminal command ```curl -i -H "Content-Type: application/json" -X DELETE -d http://localhost:8080/api/notes/1```with the last number being the index of the note you wish to edit, then refresh the webpage to see the results.
