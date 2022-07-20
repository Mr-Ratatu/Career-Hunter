package com.work.found.core.api.model.detail

import com.work.found.core.api.model.work.Area
import com.work.found.core.api.model.work.Employer
import com.work.found.core.api.model.work.Salary

data class WorkDetailResponse(
    val address: Any,
    val area: Area,
    val contacts: String,
    val description: String,
    val employer: Employer,
    val employment: Employment,
    val experience: Experience,
    val id: String,
    val key_skills: List<KeySkill>,
    val name: String,
    val salary: Salary?,
    val schedule: Schedule,
    val site: Site,
)