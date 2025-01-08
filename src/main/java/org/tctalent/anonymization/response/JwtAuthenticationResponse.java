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

package org.tctalent.anonymization.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.db.User;

@Getter
@Setter
public class JwtAuthenticationResponse {

    private User user;
    private String accessToken;
    private String tokenType = "Bearer";

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public JwtAuthenticationResponse(
        @JsonProperty("accessToken") String accessToken,
        @JsonProperty("user") User user) {

        this.accessToken = accessToken;
        this.user = user;
    }

}
