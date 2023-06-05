//
//  TagView.swift
//  iosApp
//
//  Created by Tom Kubasik on 04/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TagView: View {
    var tag: String
    
    var body: some View {
        ZStack {
            Text(tag)
                .font(LeagueWikiTypography.textBase)
        }
        .padding([.top, .bottom], 8)
        .padding([.leading, .trailing], 16)
        .background(LeagueWikiColorTheme.primary)
        .foregroundColor(LeagueWikiColorTheme.contentOnPrimary)
        .clipShape(Capsule())
    }

}

struct TagView_Previews: PreviewProvider {
    static var previews: some View {
        TagView(tag: "Assassin")
    }
}
