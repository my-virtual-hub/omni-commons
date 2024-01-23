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

class OmniPhoneNumberExceptionTest {

    @Test
    void testContructorOnlyWithMessage() {
        final PhoneNumberException phoneNumberExceptionUnderTest1 = new PhoneNumberException("message");
        assertEquals("OmniException{Exception.toString()=br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException: message, throwableCause={null}}", phoneNumberExceptionUnderTest1.toString());
    }

    @Test
    void testContructorWithExceptionThrow() {
        final PhoneNumberException phoneNumberExceptionUnderTest1 = new PhoneNumberException("message", new Exception("message"));
        assertEquals("OmniException{Exception.toString()=br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException: message, throwableCause={java.lang.Exception: message}}", phoneNumberExceptionUnderTest1.toString());
    }

    @Test
    void testContructorWithStringExceptionThrow() {
        final PhoneNumberException phoneNumberExceptionUnderTest1 = new PhoneNumberException("message", "text throw");
        assertEquals("OmniException{Exception.toString()=br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException: message, throwableCause={text throw}}", phoneNumberExceptionUnderTest1.toString());
    }
}
