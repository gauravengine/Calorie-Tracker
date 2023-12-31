package CalorieTracker.controller;

import CalorieTracker.entity.Entries;
import CalorieTracker.errors.CustomException;
import CalorieTracker.service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entries")
public class EntriesController {
    @Autowired
    private EntriesService entriesService;

    @PostMapping
    public ResponseEntity<Object> createEntry(@RequestBody EntryRequestDTO entryRequestDTO) {
        if (entryRequestDTO.getFoodName() == null || entryRequestDTO.getCalories() == null || entryRequestDTO.getLocalDate() == null || entryRequestDTO.getLocalTime() == null){
            throw new CustomException("Fields cannot be NULL");
        }
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



    @GetMapping("/range")
    ResponseEntity<HashMap<String,Long>> getEntriesForRange(@RequestBody GetNDaysCalsDTO getNDaysCalsDTO){
        try {
            HashMap<String,Long> returnData = entriesService.getEntriesForRange(getNDaysCalsDTO);
            return ResponseEntity.ok().body(returnData);
        } catch (Exception e) {
            throw new CustomException("Error fetching entries for Range: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entries> updateEntries(@PathVariable("id") Long iD, @RequestBody Entries entry){
        try{
            Entries entries = entriesService.updateEntries(iD,entry);
            return ResponseEntity.ok().body(entries);
        } catch (Exception e){
            throw new CustomException("Error updating the entry: " + e.getMessage());
        }

    }
}
