package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Web.Dtos.Request.PromoRequest;

public interface PromoRequestMapper {
    PromoRequest toPromoRequest(PromoRequest promoRequest);
    PromoEntity toPromoEntity(PromoRequest promoRequest);
}
