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
import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OmniProcessIdTest {

    private OmniProcessId omniProcessIdUnderTest1;
    private OmniProcessId omniProcessIdUnderTest2;

    private OmniProcessId omniProcessIdUnderTest3;

    @BeforeEach
    void setUp() {
        omniProcessIdUnderTest1 = new OmniProcessId("prefix", ChannelType.SMS,
                UUID.fromString("ed18e662-86ea-4cd1-848a-092000af927c")) {
            @Override
            public OmniProcessId copy() throws PhoneNumberException {
                return null;
            }
        };

        omniProcessIdUnderTest2 = new OmniProcessId("prefix", ChannelType.SMS,
                UUID.fromString("ed18e662-86ea-4cd1-848a-092000af927c")) {
            @Override
            public OmniProcessId copy() throws PhoneNumberException {
                return null;
            }
        };

        omniProcessIdUnderTest3 = new OmniProcessId("prefix", ChannelType.SMS,
                UUID.randomUUID()) {
            @Override
            public OmniProcessId copy() throws PhoneNumberException {
                return null;
            }
        };
    }

    @Test
    void testConstructorWithNull() {
        assertThrows(NullPointerException.class, () -> new OmniProcessId("prefix", null,
                UUID.randomUUID()) {
            @Override
            public OmniProcessId copy() throws PhoneNumberException {
                return null;
            }
        });
        assertThrows(NullPointerException.class, () -> new OmniProcessId( null) {
            @Override
            public OmniProcessId copy() throws PhoneNumberException {
                return null;
            }
        });
    }

    @Test
    void testGetOmniProcessId() {
        assertEquals("prefix:SMS:ed18e662-86ea-4cd1-848a-092000af927c",omniProcessIdUnderTest1.getOmniProcessId());
    }

    @Test
    void testEquals() {
        assertEquals(omniProcessIdUnderTest1,omniProcessIdUnderTest2);
        assertNotEquals(omniProcessIdUnderTest1,omniProcessIdUnderTest3);
    }

    @Test
    void testHashCode() {
        assertEquals(omniProcessIdUnderTest1.hashCode(),omniProcessIdUnderTest2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("{prefix='prefix', channelType=SMS, omniProcessUUID=ed18e662-86ea-4cd1-848a-092000af927c}", omniProcessIdUnderTest1.toString());
    }
}
