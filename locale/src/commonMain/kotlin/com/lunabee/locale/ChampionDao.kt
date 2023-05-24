package com.lunabee.locale

import com.lunabee.domain.model.ChampionInfo
import com.lunabee.locale.model.RealmChampionInfo
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow

class ChampionDao(
    private val realm: Realm,
) {

    fun getChampionsList(): Flow<ResultsChange<RealmChampionInfo>> {
        return realm.query<RealmChampionInfo>().asFlow()
    }

    suspend fun insertChampionList(championInfo: List<ChampionInfo>) {
        realm.write {
            championInfo.forEach {
                this.copyToRealm(
                    instance = RealmChampionInfo.fromChampionInfo(it),
                    updatePolicy = UpdatePolicy.ALL
                )
            }
        }
    }
}