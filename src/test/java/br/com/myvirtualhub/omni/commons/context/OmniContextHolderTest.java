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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

class OmniContextHolderTest {

    @BeforeEach
    public void setUp() {
        OmniContextHolder.clearContext();
    }

    @Test
    void testSetAndGetContext() {
        OmniContext mockOmniContext = mock(OmniContext.class);
        OmniContextHolder.setContext(mockOmniContext);
        OmniContext retrievedContext = OmniContextHolder.getContext();
        assertEquals(mockOmniContext, retrievedContext);
    }

    @Test
    void testClearContext() {
        OmniContext mockOmniContext = mock(OmniContext.class);
        OmniContextHolder.setContext(mockOmniContext);
        OmniContextHolder.clearContext();
        OmniContext retrievedContext = OmniContextHolder.getContext();
        assertNull(retrievedContext);
    }
}
