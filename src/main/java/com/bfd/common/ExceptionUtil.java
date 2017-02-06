package com.bfd.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Exception Utils to help customize Exception
 * 
 * @Date 4:24:50 pm 6 Feb 2017
 * @author wilkins.liang
 *
 */
public class ExceptionUtil {

    /**
     * Get String output from an exception
     * 
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
