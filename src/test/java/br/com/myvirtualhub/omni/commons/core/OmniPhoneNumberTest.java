/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.commons.core;

import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
import br.com.myvirtualhub.omni.commons.validator.PhoneNumberIsValidValidatorHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OmniPhoneNumberTest {

    private PhoneNumberIsValidValidatorHandler validator;

    @BeforeEach
    void setUp() {
        validator = Mockito.mock(PhoneNumberIsValidValidatorHandler.class);
        PhoneNumberIsValidValidatorHandler.Builder builder =
                Mockito.mock(PhoneNumberIsValidValidatorHandler.Builder.class);
        Mockito.when(builder.build()).thenReturn(validator);
    }

    @Test
    void constructorShouldValidatePhoneNumber() throws PhoneNumberException {
        String validPhoneNumber = "+1234567890";
        Mockito.doNothing().when(validator).validate(validPhoneNumber);

        assertDoesNotThrow(() -> new OmniPhoneNumber(validPhoneNumber));
    }

    @Test
    void constructorShouldThrowExceptionForInvalidPhoneNumber() throws PhoneNumberException {
        String invalidPhoneNumber = "invalid";
        Mockito.doThrow(PhoneNumberException.class).when(validator).validate(invalidPhoneNumber);

        assertThrows(PhoneNumberException.class, () -> new OmniPhoneNumber(invalidPhoneNumber));
    }

    @Test
    void getContentShouldReturnCorrectContent() throws PhoneNumberException {
        String phoneNumberContent = "+1234567890";
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber(phoneNumberContent);

        assertEquals(phoneNumberContent, omniPhoneNumber.getContent());
    }

    @Test
    void setContentShouldUpdateContent() throws PhoneNumberException {
        String initialContent = "+1234567890";
        String newContent = "+0987654321";
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber(initialContent);

        omniPhoneNumber.setContent(newContent);

        assertEquals(newContent, omniPhoneNumber.getContent());
    }

    @Test
    void equalsAndHashCodeShouldBeConsistent() throws PhoneNumberException {
        String phoneNumberContent = "+1234567890";
        OmniPhoneNumber omniPhoneNumber1 = new OmniPhoneNumber(phoneNumberContent);
        OmniPhoneNumber omniPhoneNumber2 = new OmniPhoneNumber(phoneNumberContent);

        assertEquals(omniPhoneNumber1, omniPhoneNumber2);
        assertEquals(omniPhoneNumber1.hashCode(), omniPhoneNumber2.hashCode());
    }

    @Test
    void toStringShouldReturnCorrectFormat() throws PhoneNumberException {
        String phoneNumberContent = "+1234567890";
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber(phoneNumberContent);

        String expectedString = "OmniPhoneNumber{content='" + phoneNumberContent + "'}";
        assertEquals(expectedString, omniPhoneNumber.toString());
    }

    @Test
    void testCopy() throws Exception {
        String phoneNumberContent = "+1234567890";
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber(phoneNumberContent);
        OmniPhoneNumber omniPhoneNumberCopy = omniPhoneNumber.copy();

        assertEquals(omniPhoneNumber, omniPhoneNumberCopy);
        assertNotSame(omniPhoneNumber, omniPhoneNumberCopy);
    }
}
