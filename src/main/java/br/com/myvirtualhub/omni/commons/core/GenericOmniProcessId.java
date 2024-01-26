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

package br.com.myvirtualhub.omni.commons.core;

import br.com.myvirtualhub.omni.commons.enums.ChannelType;

/**
 * A concrete representation of a generic Omni Process identifier.
 * An instance of this class encapsulates the unique identification data associated with a generic Omni process,
 * including the prefix, channel type, and a universally unique identifier.
 */
public class GenericOmniProcessId extends OmniProcessId {

    /**
     * Constructs a new instance of GenericOmniProcessId. This constructor initializes the GenericOmniProcessId object with the default channel type {@code ChannelType.GENERIC}.
     * The channel type is used to determine how to process and handle communications based on the specific channel.
     *
     * @see ChannelType
     */
    public GenericOmniProcessId() {
        super(ChannelType.GENERIC);
    }
}
