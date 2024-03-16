package ca.mcgill.ecse321.SportsSchedulePlus.controller;

import java.util.List;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.SportsSchedulePlus.dto.dailyschedule.DailyScheduleResponseDTO;
import ca.mcgill.ecse321.SportsSchedulePlus.model.DailySchedule;
import ca.mcgill.ecse321.SportsSchedulePlus.service.userservice.UserService;
import ca.mcgill.ecse321.SportsSchedulePlus.dto.dailyschedule.DailyScheduleRequestDTO;
import ca.mcgill.ecse321.SportsSchedulePlus.dto.dailyschedule.DailyScheduleListResponseDTO;

/**
 * Rest controller for managing the opening hours of the sports center
 *
 * @author Vladimir Venkov
 */
@CrossOrigin(origins = "*")
@RestController
public class DailyScheduleController {

    @Autowired
    private UserService userService;

    /*
     * create a new default daily schedule
     */
    @PostMapping(value = {"/openingHours", "/openingHours/"})
    public DailyScheduleListResponseDTO createDailySchedule() {
        List<DailyScheduleResponseDTO> dtos = new ArrayList<>();
        for (DailySchedule ds : userService.createDailySchedule()) {
            dtos.add(new DailyScheduleResponseDTO(ds));
        }
        return new DailyScheduleListResponseDTO(dtos);
    }

    /*
     * get the opening hours
     */
    @GetMapping(value = {"/openingHours", "/openingHours/"})
    public DailyScheduleListResponseDTO getAllDailySchedules() {
        List<DailyScheduleResponseDTO> dtos = new ArrayList<>();
        for (DailySchedule ds : userService.getAllDailySchedules()) {
            dtos.add(new DailyScheduleResponseDTO(ds));
        }
        return new DailyScheduleListResponseDTO(dtos);
    }

    /*
     * get the opening hours for a day in the week
     */
    @GetMapping(value = {"/openingHours/{id}", "/openingHours/{id}/"})
    public DailyScheduleResponseDTO getDailyScheduleById(@PathVariable("id") int id) {
        return new DailyScheduleResponseDTO(userService.getDailyScheduleById(id));
    }

    /*
     * update the opening hours for a day in the week
     */
    @PutMapping(value = {"/openingHours/{id}", "/openingHours/{id}/"})
    public DailyScheduleResponseDTO updateDailySchedule(@PathVariable("id") int id, @RequestBody DailyScheduleRequestDTO request) {
       
        if(request.getOpeningTime() == null ){
            System.out.println("null !");
        }
        Time openingTime = Time.valueOf(request.getOpeningTime());
        Time closingTime = Time.valueOf(request.getClosingTime());
        return new DailyScheduleResponseDTO(userService.updateDailyScheduleByID(id, openingTime, closingTime));
    }
}