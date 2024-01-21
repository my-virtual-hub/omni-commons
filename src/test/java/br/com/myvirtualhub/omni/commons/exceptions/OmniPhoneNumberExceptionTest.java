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
