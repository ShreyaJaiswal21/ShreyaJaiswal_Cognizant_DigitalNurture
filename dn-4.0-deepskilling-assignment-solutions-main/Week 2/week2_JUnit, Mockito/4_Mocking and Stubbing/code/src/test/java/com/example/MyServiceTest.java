package com.example;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testProcess_withMockedExternalApi() {
        // Arrange: create mock and stub method
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.fetchData()).thenReturn("Mocked Data");

        MyService service = new MyService(mockApi);

        // Act
        String result = service.process();

        // Assert
        assertEquals("Processed: Mocked Data", result);
    }
}
