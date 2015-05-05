package com.cloudmunch.javademo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class RestLoggerTest {
    @Test
    public final void echo_returnsSameString_returnsSameString() throws SQLException {
        RestLogger restLogger = new RestLogger();
        String echoMessage = "This is a Message";

        String returnedString = restLogger.echo(echoMessage);

        assertEquals(echoMessage, returnedString);
    }

    @Test
    public final void info_getsJsonPayloadAndStoresIt_returnsTrue()
            throws SQLException {

        IDataAccess da = mock(IDataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.INFO.toString());

        when(da.insertLogMessage(Mockito.anyObject())).thenReturn(true);

        RestLogger restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\"," +
                " \"message\": \"Test Message\" }");

        assertTrue(returned);
    }

    @Test
    public final void warn_getsJsonPayloadAndStoresIt_returnsTrue()
            throws SQLException {
        IDataAccess da = mock(IDataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.WARN.toString());
        
        System.out.println(da.toString());

        when(da.insertLogMessage(logMessage)).thenReturn(true);

        RestLogger restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\"," +
                " \"message\": \"Test Message\" }");

        assertTrue(returned);
    }

    @Test
    public final void error_getsJsonPayloadAndStoresIt_returnsTrue()
            throws SQLException {
        IDataAccess da = mock(IDataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.ERROR.toString());

        when(da.insertLogMessage(logMessage)).thenReturn(true);

        RestLogger restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\", " +
                " \"message\": \"Test Message\" }");

        assertTrue(returned);
    }

    @Test
    public final void fatal_getsJsonPayloadAndStoresIt_returnsTrue()
            throws SQLException {
        IDataAccess da = mock(IDataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.FATAL.toString());

        when(da.insertLogMessage(logMessage)).thenReturn(true);

        RestLogger restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\", " +
                " \"message\": \"Test Message\" }");

        assertTrue(returned);
    }


}
