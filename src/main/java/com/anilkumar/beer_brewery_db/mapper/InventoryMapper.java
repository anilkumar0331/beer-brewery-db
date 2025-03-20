package com.anilkumar.beer_brewery_db.mapper;

import com.anilkumar.beer_brewery_db.entities.InventoryEntity;
import com.anilkumar.beer_brewery_db.models.InventoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

        @Mapping( source = "beerId", target = "id")
        @Mapping(source = "nameOfBeer", target = "beerName")
        @Mapping(source = "numOfBeers", target = "quantity")
        @Mapping(source = "beerCost", target = "price")
        InventoryEntity modelToEntity(InventoryModel inventoryModel);

        @Mapping(source = "beerName", target = "nameOfBeer")
        @Mapping(source = "quantity", target = "numOfBeers")
        @Mapping(source = "price", target = "beerCost")
        @Mapping(target = "beerId", source = "id")
        InventoryModel entityToModel(InventoryEntity inventoryEntity);

        List<InventoryModel> toModelList(List<InventoryEntity> entities);
}