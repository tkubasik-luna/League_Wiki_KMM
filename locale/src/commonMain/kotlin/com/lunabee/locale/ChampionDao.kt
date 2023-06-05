package com.lunabee.locale

import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.ChampionInfo
import com.lunabee.locale.model.RealChampionFavorite
import com.lunabee.locale.model.RealmChampionDetail
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

    fun getIsFavorite(id: String): Flow<ResultsChange<RealChampionFavorite>> {
        return realm.query<RealChampionFavorite>("id == $0", id).asFlow()
    }

    fun getFavorites(): Flow<ResultsChange<RealChampionFavorite>> {
        return realm.query<RealChampionFavorite>().asFlow()
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

    suspend fun insertFavorite(id: String) {
        realm.write {
            this.copyToRealm(
                instance = RealChampionFavorite(id),
                updatePolicy = UpdatePolicy.ALL
            )
        }
    }

    suspend fun removeFavorite(id: String) {
        realm.write {
            val champion = query<RealChampionFavorite>("id == $0", id).first().find()
            if (champion != null) {
                this.delete(champion)
            }
        }
    }

    suspend fun insertChampionDetail(championDetail: ChampionDetail) {
        realm.write {
            this.copyToRealm(
                instance = RealmChampionDetail.fromChampionDetail(championDetail),
                updatePolicy = UpdatePolicy.ALL,
            )
        }
    }

    fun getChampionsDetail(id: String): Flow<ResultsChange<RealmChampionDetail>> {
        return realm.query<RealmChampionDetail>("id == $0", id).asFlow()
    }
}