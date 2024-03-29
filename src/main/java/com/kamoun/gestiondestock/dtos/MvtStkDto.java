package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.MvtStk;
import com.kamoun.gestiondestock.model.TypeMvtStock;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data
@Builder

public class MvtStkDto {
    private Integer id ;

    private BigDecimal quantite;

    private Instant dateMvt;

    private ArticleDto article ;

    private TypeMvtStock typeMvtStock;
    public static MvtStkDto  fromEntity(MvtStk mvtStk){
        if(mvtStk==null){
            // TODO throw an exception
            return null;
        }
        return  MvtStkDto.builder()
                .id(mvtStk.getId())
                .quantite(mvtStk.getQuantite())
                .dateMvt(mvtStk.getDateMvt())
                .typeMvtStock(mvtStk.getTypeMvtStock())

                .build();
    }

    public static  MvtStk  toEntity(MvtStkDto mvtStkDto){
        if(mvtStkDto==null){
            // TODO throw an exception
            return null;
        }
        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.id);
        mvtStk.setQuantite(mvtStkDto.quantite);
        mvtStk.setDateMvt(mvtStkDto.dateMvt);
        mvtStk.setDateMvt(mvtStkDto.dateMvt);

        return  mvtStk;
    }
}
