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

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * An abstract representation of an Omni Process identifier.
 * An instance of this class encapsulates the unique identification data associated
 * with an Omni process, including the prefix, channel type, and a universally unique identifier.
 *
 *  @author  Marco Quiçula
 *  @version 1.0
 *  @since   2024-01-09
 */
public abstract class OmniProcessId implements Serializable {

    /**
     * Represents the prefix associated with an OmniProcessId.
     * The prefix is a string value that is associated with an OmniProcessId object.
     * It is used to identify and categorize the OmniProcessId.
     * The prefix can be retrieved using the {@link OmniProcessId#getPrefix()} method.
     * For example, if the prefix is "ABC123", it can be used to differentiate the OmniProcessId from others.
     *
     * @see OmniProcessId
     * @see OmniProcessId#getPrefix()
     */
    private final String prefix;

    /**
     * Represents the channel type associated with an OmniProcessId.
     * The channel type is used to determine how to process and handle communications based on the specific channel.
     * This information is typically used throughout the system.
     */
    private final ChannelType channelType;

    /**
     * The omniProcessUUID variable represents the universally unique identifier (UUID) associated with the OmniProcessId.
     */
    private final UUID omniProcessUUID;

    /**
     * Constructs a new instance of OmniProcessId with the specified channel type.
     *
     * @param channelType the channel type for the OmniProcessId
     * @throws NullPointerException if the channelType is null
     */
    protected OmniProcessId(ChannelType channelType) {
        this("omni", channelType, UUID.randomUUID());
    }

    /**
     * Constructs a new instance of OmniProcessId with the specified prefix, channel type, and OmniProcess UUID.
     *
     * @param prefix The prefix associated with the OmniProcessId.
     * @param channelType The channel type associated with the OmniProcessId.
     * @param omniProcessUUID The universally unique identifier (UUID) associated with the OmniProcessId.
     */
    private OmniProcessId(String prefix, ChannelType channelType, UUID omniProcessUUID) {
        Objects.requireNonNull(channelType, "OmniProcessId channelType cannot be null");
        this.prefix = prefix;
        this.channelType = channelType;
        this.omniProcessUUID = omniProcessUUID;
    }

    /**
     * Retrieves the prefix associated with the OmniProcessId.
     *
     * @return The prefix of the OmniProcessId.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Retrieves the channel type associated with the OmniProcessId.
     *
     * @return The channel type of the OmniProcessId.
     */
    public ChannelType getChannelType() {
        return channelType;
    }

    /**
     * Retrieves the universally unique identifier (UUID) associated with the OmniProcessId.
     *
     * @return The UUID of the OmniProcessId.
     */
    public UUID getOmniProcessUUID() {
        return omniProcessUUID;
    }

    /**
     * Retrieves the OmniProcess ID, which is a concatenation of the prefix, channel type,
     * and OmniProcess UUID associated with the OmniProcessId object.
     *
     * @return The OmniProcess ID in the format: prefix:channelType:omniProcessUUID
     */
    public final String getOmniProcessId() {
        return getPrefix() + ":" + getChannelType().toString() + ":" + getOmniProcessUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OmniProcessId that)) return false;
        return getPrefix().equals(that.getPrefix()) && getChannelType() == that.getChannelType() && getOmniProcessUUID().equals(that.getOmniProcessUUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrefix(), getChannelType(), getOmniProcessUUID());
    }

    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "prefix='" + prefix + '\'' +
                ", channelType=" + channelType +
                ", omniProcessUUID=" + omniProcessUUID +
                '}';
    }
}
