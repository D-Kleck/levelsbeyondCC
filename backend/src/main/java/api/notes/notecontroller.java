package api.notes;

/*
CRUD Ops Used:
Create: newNote
Delete: deleteNote
Get: getNote
Get All: getNotes()
Find All By Term: getNotes(body)
Edit: editNote
*/
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteControler{

  private final NoteRepository repo;

  private final String API_DICT = "api/notes";

  NoteControler(NoteRepository repo) {
    this.repo = repo;
  }

  //Create and store new note
  @PostMapping(API_DICT)
  Note newNote(@RequestBody Note newNote){
    return repo.save(newNote);
  }

  //Delete note from id
  @DeleteMapping(API_DICT = "/{id}")
  void deleteNote(@PathVariable Long id){
    //eiether finds id and deletes or id doesnt exist -> throw exception
    return repo.deleteById(id).orElseThrow(()-> new NoNoteFoundException(id));
  }

  //Get existing note (single)
  @GetMapping(API_DICT = "/{id}")
  Note getNote(@PathVariable Long id){
    //eiether finds id or id doesnt exist -> throw exception
    return repo.findById(id).orElseThrow(()-> new NoNoteFoundException(id));
  }

  //Get all existing notes and stores to repo
  @GetMapping(API_DICT)
  List<Note> getNotes() {
    return repo.findAll();
  }

  //Get all existing notes w/ queried term and saves to repo
  @RequestMapping(value="API_DICT", method= RequestMethod.GET)
  //val = requested Query ex. "milk"
  public List<Note> findByBody(@RequestParam("val") String val) {
    List<Note> notes = repo.findALl();
    //prints list
    System.out.println(notes.toString());
    //stores to repo
    return repo.findAll();
  }

  //Edit note from id
  @PutMapping(API_DICT = "/{id}")
  //basically makes new note and sets it with the older version's ID
  Note editNote(@RequestBody Note newNote, @PathVariable Long id){
    //eiether finds id and deletes or id doesnt exist -> throw exception
    return repo.findById(id).map(note -> {
      note.setBody(newNote.getBody());
      return repo.save(note);
    }).orElseGet(() -> {
      newNote.setId(id);
      return repo.save(newNote);
    });
  }
}
