//
//  FavoriteChampionView.swift
//  iosApp
//
//  Created by Tom Kubasik on 04/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct FavoriteChampionView: View {
    var championInfo: UiChampionInfo
    var onFavoriteClick: () -> Void
    
    var body: some View {
        VStack(alignment: .center) {
            AsyncImage(url: URL(string: championInfo.imageUrl)) { image in
                image
                    .resizable()
                    .scaledToFill()
            } placeholder: {
                ProgressView()
            }
            .frame(
                width: CGFloat(SharedConstants.HomeDimens.shared.ChampionImageSize),
                height: CGFloat(SharedConstants.HomeDimens.shared.ChampionImageSize)
            )
            .clipShape(Circle())
            .overlay(
                alignment: .bottomTrailing,
                content: {
                    FavoriteButton(isFavorite : championInfo.isFavorite, onClick: onFavoriteClick)
                        .offset(x:16, y:16)
                }
            )
            Spacer().frame(height: 12)
            Text(championInfo.name ?? "")
                .font(LeagueWikiTypography.textLarge)
                .foregroundColor(LeagueWikiColorTheme.contentPrimary)
        }
        .padding(12)
        .background(LeagueWikiColorTheme.backgroundSecondary)
        .clipShape(RoundedRectangle(cornerRadius: 8))
    }
}
