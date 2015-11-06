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

import java.io.PrintStream;
import java.util.logging.*;

/**
 * The UtilLog Class. It makes Logging easyer !
 */
public final class UtilLog {

    /**
     * The Constant rootLogger.
     */
    private static final Logger rootLogger = Logger.getLogger("");
    private static final PrintStream DEFAULT_ERR = System.err;
    private static final PrintStream DEFAULT_OUT = System.out;
    /**
     * The is log init variable.
     */
    private static boolean isLogInit = false;
    private static Logger LOG;
    private static PrintStream err;

    private static PrintStream out;

    /**
     * The han.
     */
    private static Handler han;

    /**
     * Private constructor so we don't instantiate it.
     */
    private UtilLog() {

    }

    public static PrintStream getDefaultErr() {
        return DEFAULT_ERR;
    }

    public static PrintStream getDefaultOut() {
        return DEFAULT_OUT;
    }

    public static PrintStream getErr() {
        return err;
    }

    /**
     * Gets the log.
     *
     * @param str the str
     * @return the log
     */
    public static Logger getLog(String str) {
        if (!isLogInit) {
            initLog();
        }
        return Logger.getLogger(str);
    }

    public static PrintStream getOut() {
        return out;
    }

    /**
     * Inits the log.
     */
    private static void initLog() {
        if (err == null) {
            restoreDefaultErr();
        }
        if (out == null) {
            restorDefaultOut();
        }
        Handler[] handlers = rootLogger.getHandlers();

        if (handlers[0] instanceof ConsoleHandler) {

            rootLogger.removeHandler(handlers[0]);
        }
        if (han != null) {
            rootLogger.removeHandler(han);
        }

        han = new Handler() {

            @Override
            public void close() throws SecurityException {
            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {
                if (getFormatter() == null) {
                    setFormatter(new LogFormatter());
                }

                try {
                    String message = getFormatter().format(record);
                    if (record.getLevel().intValue() >= Level.WARNING
                            .intValue()) {
                        getErr().write(message.getBytes());
                    } else {
                        getOut().write(message.getBytes());
                    }
                } catch (Exception exception) {
                    reportError(null, exception, ErrorManager.FORMAT_FAILURE);
                }

            }
        };
        rootLogger.addHandler(han);
        isLogInit = true;
        LOG = getLog(UtilLog.class.getName());
        logForMe(Level.FINEST, "Root logger with formater edited !");
    }

    private static void logForMe(Level lev, String msg) {
        if (isLogInit) {
            LOG.log(lev, msg);
        }
    }

    public static void restorDefaultOut() {
        logForMe(Level.FINEST, "Restoring out to default");
        setOutPrintStream(DEFAULT_OUT);
    }

    public static void restoreDefaultErr() {
        logForMe(Level.FINEST, "Restoring err to default");
        setErrPrintStream(DEFAULT_ERR);
    }

    public static void setErrPrintStream(PrintStream errOut) {
        logForMe(Level.FINEST, "Changing stdErr stream to " + errOut);
        err = errOut;
    }

    /**
     * Sets the formatter.
     *
     * @param format the new formatter
     */
    public static void setFormatter(Formatter format) {
        if (format == null) {
            throw new NullPointerException("Format must not be null");
        }
        han.setFormatter(format);
        logForMe(Level.FINEST, "Editing Formatter to " + format);
    }

    /**
     * Sets the level global.
     *
     * @param lev the new level global
     */
    public static void setLevelGlobal(Level lev) {
        rootLogger.setLevel(lev);
        logForMe(Level.FINEST, "Set global level to " + lev);
    }

    /**
     * Sets the level global for the package.
     *
     * @param lev  the new level global
     * @param pack the package name
     */
    public static void setLevelGlobal(Level lev, String pack) {
        try {
            Logger logg = Logger.getLogger(pack);
            logg.setLevel(lev);
            logForMe(Level.FINEST,
                    "Editing level for " + pack + " to " + lev.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setOutPrintStream(PrintStream stdOut) {
        logForMe(Level.FINEST, "Changing stdOut stream to " + stdOut);
        out = stdOut;
    }
}
