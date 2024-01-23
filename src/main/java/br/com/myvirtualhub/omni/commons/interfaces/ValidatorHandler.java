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

package br.com.myvirtualhub.omni.commons.interfaces;

import br.com.myvirtualhub.omni.commons.exceptions.OmniException;

/**
 * The ValidatorHandler interface defines the contract for classes that handle validation of a given value.
 *
 * @param <V> the type of value to be validated
 * @param <E> the type of exception to be thrown in case of validation failure
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-11
 */
public interface ValidatorHandler<V, E extends OmniException> {

    /**
     * Performs the handling of a request by validating the given value and passing it to the next
     * handler if one exists.
     *
     * @param value the value to be validated and processed
     * @throws E if the validation fails, and the specific exception type provided in the generic
     *           declaration of the ValidatorHandler interface
     */
    default void handleRequest(V value) throws E {
        validate(value);
        if (getNext() != null) {
            getNext().handleRequest(value);
        }
    }

    /**
     * Validates the given value.
     *
     * @param value the value to be validated
     * @throws E if the validation fails and the specific exception type provided in the generic declaration is thrown
     */
    void validate(V value) throws E;

    /**
     * Retrieves the next ValidatorHandler in the chain.
     *
     * @return the next ValidatorHandler in the chain, or null if there is no next handler
     */
    ValidatorHandler<V, E> getNext();

    /**
     * Sets the next ValidatorHandler in the chain.
     *
     * @param next the next ValidatorHandler in the chain
     */
    void setNext(ValidatorHandler<V, E> next);
}
