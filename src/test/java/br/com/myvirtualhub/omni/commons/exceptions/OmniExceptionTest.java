/*
 * Copyright 2024 My Virtual Hub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.myvirtualhub.omni.commons.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OmniExceptionTest {

    @Test
    void constructorWithMessageShouldSetMessageCorrectly() {
        String testMessage = "Test message";
        OmniException exception = new OmniException(testMessage);

        assertEquals(testMessage, exception.getMessage());
        assertNull(exception.getCause());
        assertNull(exception.getThrowableCause());
    }

    @Test
    void constructorWithMessageAndCauseShouldSetBothCorrectly() {
        String testMessage = "Test message";
        Throwable testCause = new RuntimeException("Test cause");
        OmniException exception = new OmniException(testMessage, testCause);

        assertEquals(testMessage, exception.getMessage());
        assertEquals(testCause, exception.getCause());
        assertEquals(testCause.toString(), exception.getThrowableCause());
    }

    @Test
    void constructorWithMessageAndThrowableCauseShouldSetBothCorrectly() {
        String testMessage = "Test message";
        String testThrowableCause = "Test throwable cause";
        OmniException exception = new OmniException(testMessage, testThrowableCause);

        assertEquals(testMessage, exception.getMessage());
        assertNull(exception.getCause());
        assertEquals(testThrowableCause, exception.getThrowableCause());
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        String testMessage = "Test message";
        OmniException exception = new OmniException(testMessage);

        String expectedString = "OmniException{Exception.toString()=br.com.myvirtualhub.omni.commons.exceptions.OmniException: Test message, throwableCause={null}}";
        assertEquals(expectedString, exception.toString());
    }
}
