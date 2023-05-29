//
//  ChampionListItemView.swift
//  iosApp
//
//  Created by Tom Kubasik on 27/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ChampionListItemView: View {
    var championInfo: UiChampionInfo
    var onFavoriteClick: () -> Void
    var body: some View {
        HStack(alignment: .center) {
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
            VStack(alignment: .leading) {
                Text(championInfo.name ?? "")
                    .font(LeagueWikiTypography.textLarge)
                    .foregroundColor(LeagueWikiColorTheme.contentPrimary)
                Text(championInfo.title ?? "")
                    .font(LeagueWikiTypography.textBase)
                    .foregroundColor(LeagueWikiColorTheme.contentSecondary)
            }
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .overlay(
            alignment: .topTrailing,
            content: {
                FavoriteButton(isFavorite : championInfo.isFavorite, onClick: onFavoriteClick)
            }
        )
    }
}
