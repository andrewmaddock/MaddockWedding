package uk.co.andrewmaddock.wedding.service;

import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.service.email.EmailService;

/**
 * Service interface for {@link PlayList} domain objects.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:43
 */
public interface PlayListService extends GenericService<PlayList>, EmailService<PlayList> {

}
