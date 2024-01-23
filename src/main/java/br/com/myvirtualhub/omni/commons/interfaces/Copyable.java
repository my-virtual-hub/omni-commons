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


import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;

/**
 * Copyable is an interface that defines the contract for creating a copy of an object.
 * Classes implementing this interface should provide an implementation for the {@link #copy()} method
 * which returns a copy of the object.
 *
 * @param <T> the type of object that this Copyable interface can create a copy of
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-13
 */
public interface Copyable<T> {
    /**
     * Creates a copy of the object.
     *
     * @return a copy of the object
     * @throws PhoneNumberException if there is an issue with phone number operations while creating the copy
     */
    T copy() throws PhoneNumberException;
}