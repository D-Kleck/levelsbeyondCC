package api.notes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

//JpaRepository supports some of the CRUD calls

interface NoteRepository extends JpaRepository<Note, Long> {
  List<Note> findByBody(@Param("val") String val);
}
