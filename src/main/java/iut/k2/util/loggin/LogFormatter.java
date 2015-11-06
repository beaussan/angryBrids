/*
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package iut.k2.util.loggin;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * The LogFormatter Class.
 *
 * @author Nicolas Beaussart
 */
public class LogFormatter extends Formatter {
    // private final static String format = "{0,date} {0,time}";
    /**
     * The Constant format.
     */
    private final static String format = "{0,time}";

    private final static String skipStr = "me.nbeaussart.";
    /**
     * The args.
     */
    private final Object args[] = new Object[1];
    /**
     * The line separator.
     */
    private final String lineSeparator = System.getProperty("line.separator");
    /**
     * The dat.
     */
    Date dat = new Date();

    // Line separator string. This is the value of the line.separator
    // property at the moment that the SimpleFormatter was created.
    // private String lineSeparator = (String)
    // java.security.AccessController.doPrivileged(
    // new sun.security.action.GetPropertyAction("line.separator"));
    /**
     * The formatter.
     */
    private MessageFormat formatter;

    /**
     * Format the given LogRecord.
     *
     * @param record the log record to be formatted.
     * @return a formatted log record
     */
    @Override
    public synchronized String format(LogRecord record) {

        StringBuilder sb = new StringBuilder();

        // Minimize memory allocations here.
        dat.setTime(record.getMillis());
        args[0] = dat;

        // Date and time
        StringBuffer text = new StringBuffer();
        if (formatter == null) {
            formatter = new MessageFormat(format);
        }
        sb.append("[");
        formatter.format(args, text, null);
        sb.append(text);
        sb.append("] [");

        // Class name
        if (record.getSourceClassName() != null) {
            sb.append(record.getSourceClassName().replaceAll(skipStr, ""));
        } else {
            sb.append(record.getLoggerName().replaceAll(skipStr, ""));
        }
        sb.append("");

        // Method name
        if (record.getSourceMethodName() != null) {
            sb.append(" @ ");
            sb.append(record.getSourceMethodName());
        }
        sb.append("] - "); // lineSeparator

        // Level
        // sb.append(record.getLevel().getLocalizedName());
        sb.append(record.getLevel());
        sb.append(": ");

        // Indent - the more serious, the more indented.
        // sb.append( String.format("% ""s") );
        int iOffset = (1000 - record.getLevel().intValue()) / 100;
        for (int i = 0; i < iOffset; i++) {
            sb.append(" ");
        }

        String message = formatMessage(record);

        sb.append(message);
        sb.append(lineSeparator);
        if (record.getThrown() != null) {
            try {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                record.getThrown().printStackTrace(pw);
                pw.close();
                sb.append(sw.toString());
            } catch (Exception ignored) {
            }
        }
        return sb.toString();
    }
}
