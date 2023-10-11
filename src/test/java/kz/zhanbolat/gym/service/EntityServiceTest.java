package kz.zhanbolat.gym.service;


import kz.zhanbolat.gym.entity.Entity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EntityServiceTest {

    @Mock
    private Entity entity;

    @InjectMocks
    private EntityService entityService;

    @Test
    void shouldReturnEntity() {
        String expectedStr = "Mocked entity";
        when(entity.toPrint()).thenReturn(expectedStr);

        Entity actual = entityService.getEntity();

        assertNotNull(actual);
        assertEquals(expectedStr, actual.toPrint());
    }
}
