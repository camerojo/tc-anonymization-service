/*
 * Copyright (c) 2023 Talent Beyond Boundaries.
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see https://www.gnu.org/licenses/.
 */

package org.tctalent.anonymization.entity.db;

import java.time.OffsetDateTime;

/**
 * Interface implemented by objects who want to record audit information about when they were
 * created and when they were last updated - and by whom.
 *
 * @author John Cameron
 */
public interface Auditable {

    /**
     * Who created this object
     * @return User responsible for creating the object
     */
    User getCreatedBy();

    /**
     * Date time of object creation
     * @return Date time of object creation
     */
    OffsetDateTime getCreatedDate();

    /**
     * Who last updated this object
     * @return Last user who updated the object
     */
    User getUpdatedBy();

    /**
     * Date time of last update
     * @return Date time of last update
     */
    OffsetDateTime getUpdatedDate();

}