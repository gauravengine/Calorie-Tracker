package CalorieTracker.controller;

import CalorieTracker.entity.Entries;
import CalorieTracker.errors.CustomException;
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
    public ResponseEntity<Object> createEntry(@RequestBody EntryRequestDTO entryRequestDTO) {
        try {
            entriesService.createEntry(entryRequestDTO);
            return ResponseEntity.ok().body(Map.of("message", "Entry saved successfully"));
        } catch (Exception e) {
            throw new CustomException("Entry not saved successfully: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Entries>> getEntriesForDate(@RequestBody GetEntryForDateDTO data) {
        try {
            List<Entries> returnData = entriesService.getEntriesForDate(data);
            return ResponseEntity.ok().body(returnData);
        } catch (Exception e) {
            throw new CustomException("Error fetching entries for date: " + e.getMessage());
        }
    }

    // ... other methods ...
}
