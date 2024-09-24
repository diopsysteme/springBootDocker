package org.SchoolApp.Web.Controller.Impl;

import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.SchoolApp.Web.Controller.Interfaces.CrudController;
import org.SchoolApp.Web.Dtos.Request.PromoRequest;
import org.SchoolApp.Services.Impl.PromoService;
import org.SchoolApp.Web.Dtos.Request.PromoUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Promotions")
public class PromoController implements CrudController<PromoEntity,PromoRequest, PromoUpdateRequest> {
    @Autowired
    private PromoService promoService;

    @PostMapping("")
    public PromoEntity Create(@RequestBody PromoRequest promoEntity){
        return promoService.createPromo(promoEntity);
    }

    @GetMapping("")
    public List<PromoEntity> findAll(){
        return promoService.getAllPromos();
    }

    @GetMapping("/encours")
    public PromoEntity getPromoEncours(){
        return promoService.getActivePromo();
    }

    @PatchMapping("/{id}/etat")
    public List<PromoEntity> updateEtatPromo(@PathVariable Long id, @RequestBody EtatEnum etat){
        return promoService.updateEtat(id, etat);
    }

    @GetMapping("/{id}")
    public Optional<PromoEntity> findById(@PathVariable Long id){
        return promoService.findById(id);
    }

    @PatchMapping("/{id}")
    public PromoEntity Update(@PathVariable Long id, @RequestBody PromoUpdateRequest promoUpdateRequest){
        return promoService.update(id, promoUpdateRequest);
    }



    @PatchMapping("/{id}/cloturer")
    public PromoEntity cloturerPromo(@PathVariable Long id){
        return promoService.cloturePromo(id);
    }
}
