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
 * Custom exception class for Scanner related errors.
 * This exception is derived from the OmniException class.
 */
public class ScannerException extends OmniException{
    /**
     * Custom exception class for Scanner-related errors.
     * This exception is derived from the OmniException class.
     *
     * @param message the detail message for the exception
     */
    public ScannerException(String message) {
        super(message);
    }

    /**
     * Custom exception class for Scanner-related errors.
     * This exception is derived from the OmniException class.
     *
     * @param message the detail message for the exception
     * @param cause the cause of the exception
     */
    public ScannerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Custom exception class for Scanner-related errors.
     * This exception is derived from the OmniException class.
     *
     * @param message           the detail message for the exception
     * @param throwableCause    the cause of the exception as a string
     */
    public ScannerException(String message, String throwableCause) {
        super(message, throwableCause);
    }
}
