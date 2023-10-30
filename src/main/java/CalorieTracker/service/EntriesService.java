package CalorieTracker.service;

import CalorieTracker.controller.EntryRequestDTO;
import CalorieTracker.controller.GetEntryForDateDTO;
import CalorieTracker.controller.GetNDaysCalsDTO;
import CalorieTracker.entity.Entries;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface EntriesService {
    void createEntry(EntryRequestDTO entryRequestDTO);

    List<Entries> getEntriesForDate(GetEntryForDateDTO data);

    public HashMap<String,Long> getEntriesForRange(GetNDaysCalsDTO data);

    public Entries updateEntries(Long entryId,Entries entry);
}
