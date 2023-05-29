//
//  ChampionDetailScreen.swift
//  iosApp
//
//  Created by Tom Kubasik on 28/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ChampionDetailScreen: View {
    var championId: String
    var body: some View {
        NavigationView {
            Text("Super c'est le detail")
        }.navigationTitle(championId)
    }
}

struct ChampionDetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        ChampionDetailScreen(championId: "Jhin")
    }
}
