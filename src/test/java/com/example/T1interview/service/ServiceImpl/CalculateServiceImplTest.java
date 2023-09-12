package com.example.T1interview.service.ServiceImpl;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


class CalculateServiceImplTest {


    @Test
    void CheckIfEmpty(){
        CalculateServiceImpl service=new CalculateServiceImpl();
        assertEquals(Collections.singleton(""),service.calculate(""));
    }
    @Test
    void CheckIfNull(){
        CalculateServiceImpl service=new CalculateServiceImpl();
        assertEquals(Collections.singleton(""),service.calculate(null));
    }
    @Test
    void CheckSingle(){
        CalculateServiceImpl service=new CalculateServiceImpl();
        assertEquals(Collections.singleton("'a': 1"),service.calculate("a"));
    }

    @Test
    void CheckEnglishString(){
        CalculateServiceImpl service=new CalculateServiceImpl();
        assertEquals(Collections.singleton("'l': 3, 'o': 2, ' ': 1, '!': 1, 'r': 1, 'd': 1, 'e': 1, 'w': 1, 'h': 1"),
                service.calculate("Hello world!"));
    }

    @Test
    void CheckRussianString(){
        CalculateServiceImpl service=new CalculateServiceImpl();
        assertEquals(Collections.singleton("'р': 2, 'и': 2, ' ': 1, '!': 1, 'в': 1, 'т': 1, 'е': 1, 'м': 1, 'п': 1"),
                service.calculate("Привет мир!"));
    }

    @Test
    void CheckChineseString(){
        CalculateServiceImpl service=new CalculateServiceImpl();
        assertEquals(Collections.singleton("'你': 1, '!': 1, '世': 1, '界': 1, '好': 1"),
                service.calculate("你好世界!"));
    }
    @Test
    void CheckBigString(){
        CalculateServiceImpl service=new CalculateServiceImpl();
        assertEquals(Collections.singleton("'l': 23, 'm': 22, 't': 22, 'a': 21, 'c': 20, 'f': 20, 'w': 20, 'z': 20, 'i': 19, 's': 19, 'j': 17, 'n': 17, 'o': 17, 'r': 17, 'e': 15, 'q': 15, 'u': 15, 'v': 15, 'y': 15, 'g': 14, 'h': 14, 'p': 14, 'k': 12, 'd': 11, '0': 10, '5': 9, '8': 9, 'x': 9, '9': 9, '1': 8, '7': 8, 'b': 7, '2': 6, '4': 6, '3': 4, '6': 1"),
                service.calculate("c2lElSaQzd8SuA5LB9I5mJQE2Jx77ywkoFsOCjkZkucl0rEuwg04ZZ4WTkTIKshRVZ7tFmFCq5ucMJ2zVfJkmWMAPtJjoZ1ei2FQSmtrrvYlfhCV2fA2DLOhhzj9LBXquddw8Y4SlrYXAafX5WWfZQ5leZLVJU9RG9IK0OLqugQfCYgA1BskvP1ohIgGZpNUKAYiAmSAahanGTQlPgMCFVxW7Mv9uEnIepJgTo8IrDDww01jouHE7N6JGSNMQcELMsryzhZrGtCYbPCRnoAwMynYVFe37fkswTdF4ups0oLabIya5RTi91BpXWzbzHFotzmtMJ5AuGZWN7LZyfdA3MlLWFI48A8poQsmiXoipX88lgcx0Vr9hIutmd1PmnQsLLlyO0u4C0hFn0jVMT5eVserawqGL9FrtC1INh8JRInDAH9nnkVwT3nSeWR8Avp7roNPCyTLSTksOvcEsCnZyjcmiW1htT5tmi3cftpqe0MijDcoZquW"));
    }

}