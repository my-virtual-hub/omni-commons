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

import br.com.myvirtualhub.omni.commons.enums.ChannelType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class SmsOmniProcessIdTest {

    @Test
    void testSmsOmniProcessIdInitializesWithSmsChannelType() {
        SmsOmniProcessId smsOmniProcessId = new SmsOmniProcessId();

        assertEquals(ChannelType.SMS, smsOmniProcessId.getChannelType(),
                "SmsOmniProcessId should initialize with the SMS channel type.");
    }

    @Test
    void testEqualsAndHashCode() {
        SmsOmniProcessId smsOmniProcessId1 = new SmsOmniProcessId();
        SmsOmniProcessId smsOmniProcessId2 = new SmsOmniProcessId();

        assertNotSame(smsOmniProcessId1, smsOmniProcessId2);
        assertNotEquals(smsOmniProcessId1, smsOmniProcessId2);
        assertNotEquals(smsOmniProcessId1.hashCode(), smsOmniProcessId2.hashCode());
    }
}
