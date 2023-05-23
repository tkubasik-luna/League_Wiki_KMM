package com.lunabee.repository.datasource

interface VersionRemoteDatasource {
    suspend fun fetchLastVersion(): String
}