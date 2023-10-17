package CalorieTracker.service;

import CalorieTracker.controller.EntryRequestDTO;
import CalorieTracker.controller.GetEntryForDateDTO;
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
import java.util.List;

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
                .calories(entryRequestDTO.getCalories())
                .localDate(entryRequestDTO.getLocalDate())
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


}
