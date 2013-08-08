package uk.co.andrewmaddock.wedding.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Domain object representing a play list.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:03
 */
@Entity
public class PlayList implements BaseEntity {

    private static final long serialVersionUID = 8467356953499282256L;

    @Id
    private Long id;
    
    @NotEmpty
    private String requester;

    @NotEmpty
    private String artist;

    @NotEmpty
    private String track;

    @Size(max = 500)
    private String why;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("requester", this.getRequester())
                .append("artist", this.getArtist())
                .append("track", this.getTrack())
                .append("why", this.getWhy())
                .toString();
    }
    
}
