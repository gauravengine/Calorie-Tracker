package CalorieTracker.controller;

import CalorieTracker.entity.Entries;
import CalorieTracker.repository.UserRepository;
import CalorieTracker.service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entries")
public class EntriesController {
    @Autowired
    private EntriesService entriesService;

    @PostMapping
    public ResponseEntity<Object> createEntry(@RequestBody EntryRequestDTO entryRequestDTO){
        try {
            entriesService.createEntry(entryRequestDTO);
            return ResponseEntity.ok().body(Map.of("message", "Entry saved successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Entry not saved successfully: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Entries>> getEntriesForDate(@RequestBody GetEntryForDateDTO data){
        try {
            List<Entries> returnData= entriesService.getEntriesForDate(data);
            return ResponseEntity.ok().body(returnData);
        } catch (Exception e) {
            return (ResponseEntity<List<Entries>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<List<Entries>> getLastNdates()
}
