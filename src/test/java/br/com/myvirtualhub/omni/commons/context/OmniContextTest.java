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

package br.com.myvirtualhub.omni.commons.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import br.com.myvirtualhub.omni.commons.core.OmniProcessId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OmniContextTest {

    private OmniContext<OmniProcessId> omniContext;

    @BeforeEach
    void setUp() {
        omniContext = new OmniContext<>();
    }

    @Test
    void testSetAndGetOmniProcessId() {
        OmniProcessId mockOmniProcessId = mock(OmniProcessId.class);
        omniContext.setOmniProcessId(mockOmniProcessId);
        OmniProcessId retrievedOmniProcessId = omniContext.getOmniProcessId();
        assertEquals(mockOmniProcessId, retrievedOmniProcessId);
    }
}
