package com.work.found.core.api.model.work

data class Employer(
    val alternate_url: String,
    val id: String,
    val logo_urls: LogoUrls?,
    val name: String,
    val trusted: Boolean,
    val url: String,
    val vacancies_url: String
)