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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericOmniProcessIdTest {

    @Test
    void testGenericOmniProcessIdInitializesWithSmsChannelType() {
        GenericOmniProcessId genericOmniProcessId = new GenericOmniProcessId();

        assertEquals(ChannelType.GENERIC, genericOmniProcessId.getChannelType(),
                "GenericOmniProcessId should initialize with the SMS channel type.");
    }

    @Test
    void testEqualsAndHashCode() {
        GenericOmniProcessId genericOmniProcessId1 = new GenericOmniProcessId();
        GenericOmniProcessId genericOmniProcessId2 = (GenericOmniProcessId)genericOmniProcessId1.copy();

        assertEquals(genericOmniProcessId1, genericOmniProcessId2);
        assertEquals(genericOmniProcessId1.hashCode(), genericOmniProcessId2.hashCode());
    }
}
