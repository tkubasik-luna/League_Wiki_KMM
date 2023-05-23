package com.lunabee.remote

import com.lunabee.remote.api.VersionApi
import com.lunabee.repository.datasource.VersionRemoteDatasource

class VersionRemoteDatasourceImpl(
    private val versionApi: VersionApi,
) : VersionRemoteDatasource {

    override suspend fun fetchLastVersion(): String {
        return versionApi.getVersions()[1]
    }
}