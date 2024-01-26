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

import br.com.myvirtualhub.omni.commons.core.OmniProcessId;

/**
 * The OmniContext class represents a context object that holds an OmniProcessId.
 * It provides methods to retrieve and set the OmniProcessId associated with the context.
 */
public class OmniContext {
    private OmniProcessId omniProcessId;

    /**
     * Retrieves the OmniProcessId associated with the context.
     *
     * @return the OmniProcessId associated with the context
     */
    public OmniProcessId getOmniProcessId() {
        return omniProcessId;
    }

    /**
     * Sets the OmniProcessId associated with the context. The OmniProcessId represents
     * a unique identifier for an Omni process.
     *
     * @param omniProcessId the OmniProcessId to be set
     *
     * @see OmniProcessId
     * @see OmniProcessId#getPrefix()
     * @see OmniProcessId#getChannelType()
     * @see OmniProcessId#getOmniProcessUUID()
     */
    public void setOmniProcessId(OmniProcessId omniProcessId) {
        this.omniProcessId = omniProcessId;
    }
}
