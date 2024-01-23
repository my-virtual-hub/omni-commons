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

/**
 * Exception used to indicate issues with phone number operations.
 *
 * <p>This is a specific type of {@link OmniException}. It should be used
 * for exceptional conditions related to phone number processing such as
 * validation, formatting, parsing, or other phone number related errors.
 *
 * @author  Marco Quiçula
 * @version 1.0
 * @since   2024-01-09
 */
public class PhoneNumberException extends OmniException{
    /**
     * Constructs a new PhoneNumberException with the specified message.
     *
     * @param message the detail message for the exception
     */
    public PhoneNumberException(String message) {
        super(message);
    }

    /**
     * Constructs a new PhoneNumberException with the specified message and cause.
     *
     * @param message the detail message for the exception
     * @param cause   the cause of the exception
     * @throws NullPointerException if the message is null
     */
    public PhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception used to indicate issues with phone number operations.
     *
     * <p>This is a specific type of {@link OmniException}. It should be used
     * for exceptional conditions related to phone number processing such as
     * validation, formatting, parsing, or other phone number related errors.
     *
     * @param message          the detail message for the exception
     * @param throwableCause  the cause of the exception as a string
     */
    public PhoneNumberException( String message , String throwableCause) {
        super(message, throwableCause);
    }
}
