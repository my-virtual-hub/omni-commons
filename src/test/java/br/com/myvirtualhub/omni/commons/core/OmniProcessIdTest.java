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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OmniProcessIdTest {

    private OmniProcessId omniProcessIdUnderTest1;
    private OmniProcessId omniProcessIdUnderTest2;

    @BeforeEach
    void setUp() {
        omniProcessIdUnderTest1 = new OmniProcessId(ChannelType.SMS) {
        };

        omniProcessIdUnderTest2 = new OmniProcessId(ChannelType.SMS) {
        };
    }

    @Test
    void testConstructorWithoutPrefixAndNull() {
        assertThrows(NullPointerException.class, () -> new OmniProcessId( null) {});
    }

    @Test
    void testGetOmniProcessId() {
        assertTrue(omniProcessIdUnderTest1.getOmniProcessId().startsWith("omni:SMS:"));
    }

    @Test
    void testEquals() {
        assertNotSame(omniProcessIdUnderTest1,omniProcessIdUnderTest2);
        assertNotEquals(omniProcessIdUnderTest1,omniProcessIdUnderTest2);
    }

    @Test
    void testHashCode() {
        assertNotEquals(omniProcessIdUnderTest1.hashCode(),omniProcessIdUnderTest2.hashCode());
    }

    @Test
    void testToString() {
        assertTrue(omniProcessIdUnderTest1.toString().startsWith("{prefix='omni', channelType=SMS, omniProcessUUID="));
        assertTrue(omniProcessIdUnderTest1.toString().endsWith("}"));
    }
}
