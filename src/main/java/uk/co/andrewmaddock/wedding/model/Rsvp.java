package uk.co.andrewmaddock.wedding.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.condition.IfNotZero;

/**
 * Domain object representing a rsvp.
 *
 * @author Andrew Maddock
 *         Date: 17/07/13 11:59
 */
@Entity 
public class Rsvp extends AbstractBaseEntity {

    private static final long serialVersionUID = -5212436493939200125L;

    @NotEmpty
    @Size(max = 500)
    private String names;

    @Index
    private boolean attending;
    
    @Min(value = 1) 
    @Max(value = 4)
    @Index(IfNotZero.class)
    private int adults;

    @Min(value = 0)
    @Max(value = 4)
    @Index(IfNotZero.class)
    private int children;

    @Index
    private boolean transport;

    @Size(max = 500)
    private String message;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public boolean isAttending() {
        return attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public boolean isTransport() {
        return transport;
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("names", this.getNames())
                .append("attending", this.isAttending())
                .append("adults", this.getAdults())
                .append("children", this.getChildren())
                .append("transport", this.isTransport())
                .append("message", this.getMessage())
                .toString();
    }

}
