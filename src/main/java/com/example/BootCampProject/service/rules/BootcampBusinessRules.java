package com.example.BootCampProject.service.rules;


import com.example.BootCampProject.common.exceptions.types.BusinessException;
import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.repository.BootcampRepository;
import org.springframework.stereotype.Service;
import java.sql.Date;

@Service
public class BootcampBusinessRules {
    private final BootcampRepository bootcampRepository;

    public BootcampBusinessRules(BootcampRepository bootcampRepository) {
        this.bootcampRepository = bootcampRepository;
    }

    public void checkIfNameExists(String name){
        Bootcamp bootcamp = bootcampRepository.getByNameIgnoreCase(name);
        if(bootcamp!=null)
            throw new BusinessException("Aynı isimde bir bootcamp daha önce açılmışsa tekrar açılamaz.");
    }

    public void checkStartDateBeforeEndDate(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            throw new BusinessException("Başlangıç tarihi, bitiş tarihinden önce olmalıdır.");
        }
    }
    public void checkIfInstructorExists(int instructorId) {
        boolean exists = bootcampRepository.existsByInstructorId(instructorId);
        if (!exists) {
            throw new BusinessException("Eğitmen sistemde kayıtlı olmalıdır.");
        }
    }
    public void checkIfBootcampOpenForApplication(int bootcampId) {
        Bootcamp bootcamp = bootcampRepository.findById(bootcampId)
                .orElseThrow(() -> new BusinessException("Bootcamp bulunamadı."));

        if (bootcamp.getBootcampState() != Bootcamp.BootcampState.OPEN_FOR_APPLICATION) {
            throw new BusinessException("Başvuru durumu 'CLOSED' olan bootcamp’e başvuru alınamaz.");
        }
    }
}
