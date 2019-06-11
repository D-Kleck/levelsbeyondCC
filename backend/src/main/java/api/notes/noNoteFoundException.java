package api.notes;

public class NoNoteFoundException extends RuntimeException {
  long id;

  public NoNoteFoundException(long id){
    this.id = id;
  }

  public String getMessage(){
    return "Cannot find " + this.id + " in existing notes\n";
  }
}
