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

package br.com.myvirtualhub.omni.commons.sms;

import br.com.myvirtualhub.omni.commons.core.OmniProcessId;
import br.com.myvirtualhub.omni.commons.enums.ChannelType;

/**
 * A specialized type of OmniProcessId that represents an SMS process within the application.
 *
 * <p>This class extends the {@link OmniProcessId} class to represent a unique identification for
 * an SMS process within the application. It provides additional context and functionality
 * catered towards processes related to SMS operations while inheriting the standard behaviour
 * of an Omni process.
 *
 * @author  Marco Quiçula
 * @version 1.0
 * @since   2024-01-09
 * @see     OmniProcessId
 */
public class SmsOmniProcessId extends OmniProcessId {

    /**
     * Constructs a new instance of SmsOmniProcessId with the SMS channel type.
     *
     * <p>This constructor initializes the SmsOmniProcessId with the specified channel type.
     * The channel type represents the communication channel used for SMS operations.
     *
     * @see OmniProcessId
     * @see ChannelType
     */
    public SmsOmniProcessId() {
        super(ChannelType.SMS);
    }
}
