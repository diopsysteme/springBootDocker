package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Datas.Entity.EmargementEntity;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Web.Dtos.Response.EmargementDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface EmargementIService {

    EmargementEntity getEmargementByUserAndDate(UserEntity user, LocalDate date);
    EmargementEntity getAbsencesByUserAndDate(UserEntity user, LocalDate date);
    List<EmargementEntity> getPresencesByUserBetweenDates(UserEntity user, LocalDate startDate, LocalDate endDate);
    List<EmargementEntity> getAllEmargementsByUser(UserEntity user);
    public EmargementEntity checkInOrOut(UserEntity user);
    public List<EmargementEntity> getEmargementsByMonth(UserEntity user, int year, int month);
    public Map<String, Object> emargerApprenants(List<Long> apprenantIds);
    public Map<String, Object> emargerUsers(List<Long> userIds);
    public Map<String, Object> emargerApprenant(Long apprenantId);
    public Map<String, Object> updateEmargement(Long apprenantId, LocalTime entree, LocalTime sortie);
    public void markAbsencesForToday();
    public Map<String, Object> emargerUser(Long userId);
    public List<EmargementEntity> getEmargementsByApprenant(ApprenantEntity apprenant);
    public List<EmargementDto> getEmargementsByApprenantAndMonth(Long apprenantId, int year, int month);
    public EmargementDto getEmargementsByApprenantAndDate(Long apprenantId, LocalDate date);
    public List<EmargementEntity> getEmargementsByApprenantId(Long apprenantId);
    public List<EmargementEntity> emargementAll(Integer mois, Integer annee, Long referentielId, LocalDate date, Long promoId);
}
