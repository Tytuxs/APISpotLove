package be.apispotlove.commons.services;

import be.apispotlove.commons.model.Photo;
import be.apispotlove.commons.model.command.PhotoCreationCommand;
import be.apispotlove.commons.model.dto.PhotoDTO;
import be.apispotlove.commons.repository.PhotoRepository;
import be.apispotlove.commons.services.mapper.PhotoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional(readOnly = true)
public class PhotoService {

    private PhotoRepository photoRepository;
    private PhotoMapper photoMapper;

    @Transactional
    public Long uploadPhoto(PhotoCreationCommand command) throws IOException {
        try {
            Photo photo = new Photo(command.getName(), command.getData().getBytes(), command.getIsMain(), command.getIsPrivate());
            return photoRepository.save(photo).getId();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public PhotoDTO getPhoto(Long id) {
        return photoMapper.toFullDTO(photoRepository.retrieve(id));
    }
}
