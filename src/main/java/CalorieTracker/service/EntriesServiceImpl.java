package CalorieTracker.service;

import CalorieTracker.controller.EntryRequestDTO;
import CalorieTracker.controller.GetEntryForDateDTO;
import CalorieTracker.controller.GetNDaysCalsDTO;
import CalorieTracker.entity.Entries;
import CalorieTracker.entity.FoodType;
import CalorieTracker.entity.User;
import CalorieTracker.errors.CustomException;
import CalorieTracker.repository.EntriesRepository;
import CalorieTracker.repository.FoodTypeRepository;
import CalorieTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntriesServiceImpl implements EntriesService{

    @Autowired
    private  EntriesRepository entriesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodTypeRepository foodTypeRepository;
    @Override
    public void createEntry(EntryRequestDTO entryRequestDTO) {
        FoodType foodType = foodTypeRepository.findById(entryRequestDTO.getFoodTypeId())
                .orElseThrow(() -> new CustomException("FoodType not found"));

        User user=userRepository.findByUserId(entryRequestDTO.getUserId()).orElseThrow(()->new CustomException("User not Found"));

        Entries entries=Entries
                .builder()
                .foodName(entryRequestDTO.getFoodName())
                .calories(entryRequestDTO.getCalories()).localDate(entryRequestDTO.getLocalDate())
                .localTime(entryRequestDTO.getLocalTime())
                .user(user)
                .foodType(foodType)
                .build();

        entriesRepository.save(entries);
    }

    @Override
    public List<Entries> getEntriesForDate(GetEntryForDateDTO data) {
        return entriesRepository.findByUserUserIdAndLocalDate(data.getUserId(),data.getLocalDate());
    }
    @Override
    public HashMap<String, Long> getEntriesForRange(GetNDaysCalsDTO data){
        HashMap<String,Long> dateWise=new HashMap<>();
        LocalDate currDate= data.getStartDate();
        List<Entries> entriesForRange=entriesRepository.findByUserUserIdAndLocalDateBetween(data.getUserId(),data.getStartDate(),data.getEndDate());

        while(!currDate.isAfter(data.getEndDate())){
            dateWise.put(currDate.toString(),0L);
            currDate= currDate.plusDays(1);
        }
        for(Entries entry:entriesForRange){
            dateWise.put(entry.getLocalDate().toString(),dateWise.get(entry.getLocalDate().toString())+entry.getCalories());
        }

        return dateWise;
    }

    @Override
    public Entries updateEntries(Long entryId,Entries entry){
        Optional<Entries> dbEntryOpt=entriesRepository.findById(entryId);
        Entries dbEntry;
        if(dbEntryOpt.isEmpty()) {
            throw new CustomException("bad request ! Entry Id not valid");
        }
        else{
            dbEntry = dbEntryOpt.get();
        }

        if(Objects.nonNull(entry.getCalories())){
            dbEntry.setCalories(entry.getCalories());
        }

        if(Objects.nonNull(entry.getLocalDate())){
            dbEntry.setLocalDate(entry.getLocalDate());
        }

        if(Objects.nonNull(entry.getLocalTime())){
            dbEntry.setLocalTime(entry.getLocalTime());
        }

        if(Objects.nonNull(entry.getFoodName())){
            dbEntry.setFoodName(entry.getFoodName());
        }
        return entriesRepository.save(dbEntry);
    }

}
