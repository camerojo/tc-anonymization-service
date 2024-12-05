package org.tctalent.anonymization.request.candidate.exam;/*
 * Copyright (c) 2024 Talent Beyond Boundaries.
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


import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.Exam;

@Getter
@Setter
public class UpdateCandidateExamRequest {
    private Long id;
    private Exam exam;
    private String otherExam;
    private String score;
    private Long year;
    private String notes;
}
