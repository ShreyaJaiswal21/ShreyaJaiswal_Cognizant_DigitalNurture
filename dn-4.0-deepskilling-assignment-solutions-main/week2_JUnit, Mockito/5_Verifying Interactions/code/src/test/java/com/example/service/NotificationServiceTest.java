package com.example.service;

import com.example.service.NotificationService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    public void testSendEmailCalledWithSpecificArguments() {
        // Create mock object
        NotificationService mockService = mock(NotificationService.class);

        //Call the method with specific arguments
        mockService.sendEmail("test@example.com", "Welcome to Mockito!");

        // Verify the interaction
        verify(mockService).sendEmail("test@example.com", "Welcome to Mockito!");
    }
}
