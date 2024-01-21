/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.commons.core;

import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
import br.com.myvirtualhub.omni.commons.interfaces.Copyable;
import br.com.myvirtualhub.omni.commons.validator.PhoneNumberIsValidValidatorHandler;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a phone number in an application.
 * This class stores a phone number string and provides validation
 * according to international phone number formatting standards.
 *
 * <p>This is an illustration and does not cover all aspects of a real-world
 * phone number class like proper validation, formatting, etc.
 *
 * @author  Your Name
 * @version 1.0
 * @since   YourProject 1.0
 */
public class OmniPhoneNumber implements Serializable, Copyable<OmniPhoneNumber> {

    /**
     * Represents the content of a variable.
     *
     * <p>This class stores the content of a variable as a string.
     */
    private String content;

    /**
     * Constructs a new OmniPhoneNumber object. The phone number must be in the format
     * of "+" followed by digits, including the country code, with no formatting.
     *
     * @param content the phone number string as entered by the user
     * @throws PhoneNumberException if the phone number is invalid
     */
    public OmniPhoneNumber(String content) throws PhoneNumberException {
        PhoneNumberIsValidValidatorHandler validator = new PhoneNumberIsValidValidatorHandler.Builder().build();
        validator.validate(content);
        setContent(content);
    }

    /**
     * Retrieves the content of the OmniPhoneNumber object.
     *
     * @return the content of the OmniPhoneNumber object as a String
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the OmniPhoneNumber object.
     *
     * @param content the new content for the OmniPhoneNumber object
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public OmniPhoneNumber copy() throws PhoneNumberException {
        return new OmniPhoneNumber(getContent());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OmniPhoneNumber omniPhoneNumber)) return false;
        return getContent().equals(omniPhoneNumber.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getContent());
    }

    @Override
    public String toString() {
        return "OmniPhoneNumber{" +
                "content='" + content + '\'' +
                '}';
    }
}
