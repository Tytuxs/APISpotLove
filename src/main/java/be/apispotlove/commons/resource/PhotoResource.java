package be.apispotlove.commons.resource;

import be.apispotlove.commons.model.command.PhotoCreationCommand;
import be.apispotlove.commons.model.dto.PhotoDTO;
import be.apispotlove.commons.services.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;

@RestController
@RequestMapping("/api/photos")
@AllArgsConstructor
public class PhotoResource {
    private PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<Long> uploadPhoto(@RequestBody PhotoCreationCommand command) throws IOException {
        return ResponseEntity.ok(photoService.uploadPhoto(command));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoDTO> getPhoto(@PathVariable Long id) throws IOException {
        PhotoDTO photoDTO = photoService.getPhoto(id);
        String mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(photoDTO.getData()));
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + photoDTO.getName() + "\"")
                .contentType(MediaType.parseMediaType(mimeType))
                .body(photoDTO);
    }
}
