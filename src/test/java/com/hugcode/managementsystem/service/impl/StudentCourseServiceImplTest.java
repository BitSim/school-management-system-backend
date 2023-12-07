package com.hugcode.managementsystem.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentCourseServiceImplTest {

    private StudentCourseServiceImpl studentCourseService;

    @BeforeEach
    public void setUp() {
        studentCourseService = new StudentCourseServiceImpl();
    }

    @Test
    public void testDeleteBySidListWhenSidsIsEmptyThenReturnFalse() {
        // Arrange
        List<String> sids = Collections.emptyList();

        // Act
        boolean result = studentCourseService.deleteBySidList(sids);

        // Assert
        assertFalse(result, "Expected deleteBySidList to return false when sids is empty");
    }

    @Test
    public void testDeleteBySidListWhenSidsIsNotEmptyThenReturnFalse() {
        // Arrange
        List<String> sids = Arrays.asList("sid1", "sid2", "sid3");

        // Act
        boolean result = studentCourseService.deleteBySidList(sids);

        // Assert
        assertFalse(result, "Expected deleteBySidList to return false when sids is not empty");
    }
}