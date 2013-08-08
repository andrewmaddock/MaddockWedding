package uk.co.andrewmaddock.wedding.service.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.repository.PlayListRepository;
import uk.co.andrewmaddock.wedding.service.AbstractGenericService;
import uk.co.andrewmaddock.wedding.service.PlayListService;
import uk.co.andrewmaddock.wedding.service.ServiceException;
import uk.co.andrewmaddock.wedding.service.email.EmailService;

/**
 * GAE implementation of the {@link PlayListService} interface.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:04
 */
@Service
public class PlayListServiceGae extends AbstractGenericService<PlayList> implements PlayListService {

    private final EmailService<PlayList> emailService;

    @Override
    public void email(PlayList playList) throws ServiceException {
        try {
            emailService.email(playList);
        } catch (Exception e) {
            LOG.error("PlayListServiceGae", "email", e);
            throw new ServiceException(e);
        } 
    }

    @Autowired
    public PlayListServiceGae(PlayListRepository playListRepository, EmailService<PlayList> emailService) {
        super(playListRepository);
        this.emailService = emailService;
    }
    
}
