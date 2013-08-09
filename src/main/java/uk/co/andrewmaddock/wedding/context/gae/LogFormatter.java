package uk.co.andrewmaddock.wedding.context.gae;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Single line log formatter.
 *
 * @author Andrew Maddock
 *         Date: 07/08/13 10:23
 */
public class LogFormatter extends Formatter {

    /**
     * Format pattern:
     * 
     * [
     * %1$tF  - ISO 8601 complete date
     * %1$tT  - Time formatted for the 24-hour clock
     * :
     * %1$tL  - Millisecond within the second formatted as three digits with leading zeros as necessary
     * ]
     * 
     * %4$-6s - Level
     * 
     * %5$s   - Message
     * %6$s   - Throwable
     * %n     - New line
     */
    private static final String FORMAT = "[%1$tF %1$tT:%1$tL] %4$-6s %5$s%6$s%n";
    
    private final Date dat = new Date();

    @Override
    public synchronized String format(LogRecord record) {
        
        dat.setTime(record.getMillis());
        String source;
        
        if (record.getSourceClassName() != null) {
            source = record.getSourceClassName();
            if (record.getSourceMethodName() != null) {
                source += " " + record.getSourceMethodName();
            }
        } else {
            source = record.getLoggerName();
        }
        
        String message = formatMessage(record);
        String throwable = "";
        
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            pw.println();
            record.getThrown().printStackTrace(pw);
            pw.close();
            throwable = sw.toString();
        }
        
        return String.format(
                FORMAT,
                dat,
                source,
                record.getLoggerName(),
                record.getLevel().getLocalizedName(),
                message,
                throwable);
        
    }

}

