package com.work.found

import com.work.found.core.api.model.detail.*
import com.work.found.core.api.model.work.Area
import com.work.found.core.api.model.work.Employer
import com.work.found.core.api.model.work.Salary
import com.work.found.core.api.model.work.WorkResponse

object ExpensesFactory {

    val workResponse = WorkResponse(
        alternate_url = "",
        found = 10,
        items = emptyList(),
        pages = 5,
        page = 2,
        per_page = 3
    )

    val workDetailResponse = WorkDetailResponse(
        address = "",
        area = Area(),
        contacts = "",
        description = "",
        employer = Employer(),
        employment = Employment(),
        experience = Experience(),
        id = "67495966",
        key_skills = emptyList(),
        name = "Android-разработчик",
        salary = Salary(),
        schedule = Schedule(),
        site = Site(),
    )
}