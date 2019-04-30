package com.furkanaskin.app.podpocket.ui.player

import android.app.Application
import androidx.databinding.ObservableField
import com.furkanaskin.app.podpocket.Podpocket
import com.furkanaskin.app.podpocket.core.BaseViewModel
import com.furkanaskin.app.podpocket.service.response.Episodes
import com.furkanaskin.app.podpocket.service.response.EpisodesItem
import io.reactivex.Observable

/**
 * Created by Furkan on 16.04.2019
 */

class PlayerViewModel(app: Application) : BaseViewModel(app) {

    var progressBarView: ObservableField<Boolean> = ObservableField(false)
    val item: ObservableField<EpisodesItem> = ObservableField()
    val episodeItem: ObservableField<Episodes> = ObservableField()

    init {
        (app as? Podpocket)?.component!!.inject(this)
    }


    fun getEpisodeDetails(id: String): Observable<Episodes> {
        return api.getEpisodesById(id)
    }
}