package lab_3c;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Tests {
    public static final int TEST_UNIQUE_ID = 5;

    @Test
    public void shouldReturnGivenValue() {
        Database databaseMock = mock(Database.class);
        when(databaseMock.getUniqueId()).thenReturn(TEST_UNIQUE_ID);
        Service service = new Service(databaseMock);
        String expectedOutput = "Using database with id: " + TEST_UNIQUE_ID;
        assertEquals(service.getDatabaseID(), expectedOutput);
    }
}