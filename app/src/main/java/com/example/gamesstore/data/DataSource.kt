package com.example.gamesstore.data

import com.example.gamesstore.R
import com.example.gamesstore.model.GamesStore

class DataSource {
    // return list of data
    fun loadGames(): List<GamesStore>{
        return listOf(
            GamesStore(R.string.ps5,R.string.ps5_price,R.drawable.ps5,R.string.ps5_description) ,
            GamesStore(R.string.ps5_controller,R.string.ps5_controller_price,R.drawable.ps5_controler,R.string.ps5_controller_description),
            GamesStore(R.string.ps5_headset,R.string.ps5_headset_price,R.drawable.ps5_headset,R.string.ps5_headset_description),
            GamesStore(R.string.ps5_camera,R.string.ps5_camera_price,R.drawable.ps5_camera,R.string.ps5_camera_description),
            GamesStore(R.string.ps5_cd,R.string.ps5_cd_price,R.drawable.ps5_cd,R.string.ps5_cd_description),
            GamesStore(R.string.ps5_cd,R.string.ps5_cd_price,R.drawable.ps5_cd_2,R.string.ps5_cd_description),
            GamesStore(R.string.ps5_cd,R.string.ps5_cd_price,R.drawable.ps5_cd3,R.string.ps5_cd_description)


        )
    }
}