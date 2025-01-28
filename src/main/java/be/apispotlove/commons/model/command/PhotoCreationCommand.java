package be.apispotlove.commons.model.command;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
public class PhotoCreationCommand {
    private String name;
    private MultipartFile data;
    private Boolean isMain;
    private Boolean isPrivate;
}
