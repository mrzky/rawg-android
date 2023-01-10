package com.app.koltinpoc.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResponse(
    val results: List<GameItem>?,
    val count: Int?
):Parcelable

@Parcelize
data class GameItem(
    val id: Int?,
    val name: String?,
    val released: String?,
    val rating: Double?,
    val background_image: String?
): Parcelable