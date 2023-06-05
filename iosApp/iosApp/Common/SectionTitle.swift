//
//  SectionTitle.swift
//  iosApp
//
//  Created by Tom Kubasik on 04/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SectionTitle: View {
    var title: String
    var body: some View {
        VStack(alignment: HorizontalAlignment.leading) {
            Text(title).font(LeagueWikiTypography.textLarge)
            Rectangle()
                .frame(maxWidth: .infinity, maxHeight: 2)
                .foregroundColor(LeagueWikiColorTheme.secondary)
        }
    }
}

struct SectionTitle_Previews: PreviewProvider {
    static var previews: some View {
        SectionTitle(title: "Section")
    }
}
