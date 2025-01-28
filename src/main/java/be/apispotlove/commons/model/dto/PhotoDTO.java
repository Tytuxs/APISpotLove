package be.apispotlove.commons.model.dto;

import lombok.Value;

@Value
public class PhotoDTO {
    String name;
    byte[] data;
    Boolean isMain;
    Boolean isPrivate;
}
