package org.SchoolApp.Jobs;

import org.SchoolApp.Services.Interfaces.EmargementIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AbsenceScheduler {

    @Autowired
    private EmargementIService emargementService;

    // Tâche qui s'exécute tous les jours à une heure précise, par exemple, 23h59
    @Scheduled(cron = "0 59 21 * * ?")
    public void markAbsences() {
        emargementService.markAbsencesForToday();
    }
}
