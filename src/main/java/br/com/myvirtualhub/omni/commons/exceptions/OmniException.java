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
 * This is the standard exception for all other exceptions
 * within the domain layer of the application.
 *
 * <p>It is used to encapsulate exceptions specific to the business logic
 * and entities of the domain. Derived exceptions should provide specific
 * details about the type of domain error condition they represent.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-09
 */
public class OmniException extends Exception {

    /**
     * Class representing an exception with a throwable cause in the domain layer of the application.
     * This exception is used to encapsulate exceptions specific to the business logic and entities of the domain.
     * Derived exceptions should provide specific details about the type of domain error condition they represent.
     */
    private final String throwableCause;

    /**
     * Constructs a new OmniException with the specified message.
     *
     * @param message the detail message for the exception
     */
    public OmniException(String message) {
        super(message);
        this.throwableCause = null;
    }

    /**
     * Constructs a new OmniException with the specified message and cause.
     *
     * @param message the detail message for the exception
     * @param cause   the cause of the exception (nullable)
     */
    public OmniException(String message, Throwable cause) {
        super(message, cause);
        this.throwableCause = cause.toString();
    }

    /**
     * Constructs a new OmniException with the specified message and throwableCause.
     *
     * @param message          the detail message for the exception
     * @param throwableCause  the cause of the exception as a string
     */
    public OmniException( String message, String throwableCause) {
        super(message);
        this.throwableCause = throwableCause;
    }

    /**
     * Returns the cause of this exception as a string.
     *
     * <p>If the cause of this exception is an instance of {@link OmniException},
     * the throwableCause string of the cause exception will be returned.
     * Otherwise, if the cause is not present or not an instance of OmniException,
     * null will be returned.
     *
     * @return the cause of this exception as a string, or null if not available
     */
    public String getThrowableCause() {
        return throwableCause;
    }

    @Override
    public String toString() {
        return "OmniException{" +
                "Exception.toString()=" + super.toString() +
               ", throwableCause={" + throwableCause +
               "}}";
    }
}
