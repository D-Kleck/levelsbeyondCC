/*
Note Model ex:
Id: 1 (long id)
Body: "Ask Larry about the TPS reports" (String)
*/
package api.notes;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class Note {

  private @Id @GeneratedValue Long id;
  private String body;

  Note(){

  }
  //New notes are assigned bodys
  Note(String body) {
    this.body = body;
  }
}
