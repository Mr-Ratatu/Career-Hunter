package com.work.found.core.api.network_service

data class PathData(
    val key: String,
    val value: String?
)

class HttpUrl private constructor(
    val scheme: Scheme,
    val host: String,
    val segment: List<String>,
    val path: List<PathData>,
    val query: List<PathData>,
) {

    class Builder {
        private var scheme: Scheme = Scheme.HTTPS
        private var host: String = Urls.DEFAULT_HOST
        private var segment = mutableListOf<String>()
        private var query = mutableListOf<PathData>()
        private var path = mutableListOf<PathData>()

        fun setHost(host: String) = apply { this.host = host }

        fun setScheme(scheme: Scheme) = apply { this.scheme = scheme }

        fun setSegment(segment: String) = apply { this.segment.add(segment) }

        fun setPath(key: String, value: String) = apply { path.add(PathData(key, value)) }

        fun setQuery(key: String, value: String) = apply { query.add(PathData(key, value)) }

        fun build() = HttpUrl(scheme, host, segment, path, query)
    }

    enum class Scheme {
        HTTP, HTTPS
    }
}
