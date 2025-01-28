package be.apispotlove.commons.services.mapper;

import be.apispotlove.commons.model.Photo;
import be.apispotlove.commons.model.dto.PhotoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PhotoMapper {

    PhotoDTO toFullDTO(Photo photo);
}
