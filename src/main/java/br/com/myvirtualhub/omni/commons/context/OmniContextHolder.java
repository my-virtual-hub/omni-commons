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

/**
 * The OmniContextHolder class provides a thread-local context holder for OmniProcessIds.
 * It serves as a storage mechanism for the current OmniProcessId associated with a thread.
 * The class provides methods to set, get, and clear the OmniProcessId in the context holder.
 */
public class OmniContextHolder {
    private static final ThreadLocal<OmniContext> contextHolder = new ThreadLocal<>();

    private OmniContextHolder() {
        // private constructor to prevent instantiation
    }

    /**
     * Sets the context for the OmniProcessId associated with the current thread.
     *
     * @param context the OmniContext object containing the OmniProcessId
     */
    public static void setContext(OmniContext context) {
        contextHolder.set(context);
    }

    /**
     * Retrieves the current OmniContext associated with the current thread.
     *
     * @return the OmniContext object containing the OmniProcessId
     */
    public static OmniContext getContext() {
        return contextHolder.get();
    }

    /**
     * Clears the context for the OmniProcessId associated with the current thread.
     */
    public static void clearContext() {
        contextHolder.remove();
    }
}
