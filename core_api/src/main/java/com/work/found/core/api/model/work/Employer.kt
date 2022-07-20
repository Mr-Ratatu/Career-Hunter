package com.work.found.core.api.model.work

data class Employer(
    val alternate_url: String = "",
    val id: String = "",
    val logo_urls: LogoUrls = LogoUrls(),
    val name: String = "",
    val trusted: Boolean = false,
    val url: String = "",
    val vacancies_url: String = ""
)