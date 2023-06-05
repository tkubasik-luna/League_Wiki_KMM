//
//  SkinView.swift
//  iosApp
//
//  Created by Tom Kubasik on 04/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SkinView: View {
    var skin: UiSkin
    var body: some View {
        VStack {
            AsyncImage(url: URL(string: skin.imageUrl)) { image in
                image
                    .resizable()
                    .scaledToFill()
            } placeholder: {
                ProgressView()
            }
            .frame(maxWidth: .infinity)
            .aspectRatio(16/9, contentMode: .fit)
            Text(skin.name)
                .font(LeagueWikiTypography.textLarge)
                .foregroundColor(LeagueWikiColorTheme.contentOnPrimary)
                .padding(16)
        }
        .background(LeagueWikiColorTheme.primary)
        .clipShape(RoundedRectangle(cornerRadius: 8))
    }
}
