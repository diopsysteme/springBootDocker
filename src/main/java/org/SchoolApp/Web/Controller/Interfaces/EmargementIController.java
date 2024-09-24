package org.SchoolApp.Web.Controller.Interfaces;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Datas.Entity.EmargementEntity;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Web.Dtos.Request.EmargementRequest;
import org.SchoolApp.Web.Dtos.Response.EmargementDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface EmargementIController {
//    EmargementEntity getEmargementByUserAndDate(UserEntity user, LocalDate date);
//    EmargementEntity getAbsencesByUserAndDate(UserEntity user, LocalDate date);
//    List<EmargementEntity> getPresencesByUserBetweenDates(UserEntity user, LocalDate startDate, LocalDate endDate);
//    List<EmargementEntity> getAllEmargementsByUser(UserEntity user);
//    EmargementEntity checkInOrOut(UserEntity user);
//    List<EmargementEntity> getEmargementsByMonth(UserEntity user, int year, int month);

    Map<String, Object> emargerApprenants(EmargementRequest apprenantIds);
    Map<String, Object> emargerUsers(List<Long> userIds);
    Map<String, Object> emargerApprenant(Long apprenantId);
    Map<String, Object> updateEmargement(Long apprenantId, LocalTime entree, LocalTime sortie);
//    void markAbsencesForToday();
    Map<String, Object> emargerUser(Long userId);
//    public List<EmargementEntity> getEmargementsByApprenant(ApprenantEntity apprenant);
    public List<EmargementDto> getEmargementsByApprenantAndMonth(Long apprenantId, int year, int month);
    public EmargementDto getEmargementsByApprenantAndDate(Long apprenantId, LocalDate date);
//    public List<EmargementEntity> getEmargementsByApprenantId(Long apprenantId);
}
