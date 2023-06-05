//
//  SpellCell.swift
//  iosApp
//
//  Created by Tom Kubasik on 04/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SpellCell: View {
    var title: String
    var imageUrl: String
    var onClick: () -> Void
    
    var body: some View {
        HStack(alignment: .center) {
            AsyncImage(url: URL(string: imageUrl)) { image in
                image
                    .resizable()
                    .scaledToFill()
            } placeholder: {
                ProgressView()
            }
            .frame(
                width: CGFloat(SharedConstants.DetailDimens.shared.SpellImageSize),
                height: CGFloat(SharedConstants.DetailDimens.shared.SpellImageSize)
            )
            .clipShape(Circle())
            Text(title)
                .font(LeagueWikiTypography.textLarge)
                .foregroundColor(LeagueWikiColorTheme.contentPrimary)
        }.padding(16)
            .frame(maxWidth: .infinity, alignment: .leading)
            .background(LeagueWikiColorTheme.backgroundSecondary)
            .clipShape(RoundedRectangle(cornerRadius: 8))
    }
}
