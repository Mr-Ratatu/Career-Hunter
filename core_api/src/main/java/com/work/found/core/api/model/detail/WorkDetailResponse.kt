package com.work.found.core.api.model.detail

import com.work.found.core.api.model.work.Area
import com.work.found.core.api.model.work.Employer
import com.work.found.core.api.model.work.Salary
import com.work.found.core.api.model.work.Type

data class WorkDetailResponse(
    val accept_handicapped: Boolean,
    val accept_incomplete_resumes: Boolean,
    val accept_kids: Boolean,
    val accept_temporary: Boolean,
    val address: Any,
    val allow_messages: Boolean,
    val alternate_url: String,
    val apply_alternate_url: String,
    val archived: Boolean,
    val area: Area,
    val branded_description: Any,
    val code: Any,
    val contacts: Any,
    val created_at: String,
    val department: Any,
    val description: String,
    val driver_license_types: List<Any>,
    val employer: Employer,
    val employment: Employment,
    val experience: Experience,
    val has_test: Boolean,
    val hidden: Boolean,
    val id: String,
    val insider_interview: Any,
    val key_skills: List<KeySkill>,
    val name: String,
    val negotiations_url: Any,
    val premium: Boolean,
    val published_at: String,
    val quick_responses_allowed: Boolean,
    val relations: List<Any>,
    val response_letter_required: Boolean,
    val response_url: Any,
    val salary: Salary?,
    val schedule: Schedule,
    val site: Site,
    val suitable_resumes_url: Any,
    val test: Any,
    val type: Type,
    val vacancy_constructor_template: Any,
    val working_days: List<Any>,
    val working_time_intervals: List<Any>,
    val working_time_modes: List<Any>
)