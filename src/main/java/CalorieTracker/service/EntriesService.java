package CalorieTracker.service;

import CalorieTracker.controller.EntryRequestDTO;
import CalorieTracker.controller.GetEntryForDateDTO;
import CalorieTracker.entity.Entries;

import java.time.LocalDate;
import java.util.List;

public interface EntriesService {
    void createEntry(EntryRequestDTO entryRequestDTO);

    List<Entries> getEntriesForDate(GetEntryForDateDTO data);
}
