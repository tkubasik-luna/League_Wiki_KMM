//
//  FavoriteButton.swift
//  iosApp
//
//  Created by Tom Kubasik on 28/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct FavoriteButton: View {
    var isFavorite: Bool
    var onClick: () -> Void
    
    @State var isPressed = false
    
    var body: some View {
        ZStack {
            Image(isFavorite ? "IconHeartFilled" : "IconHeartOutline")
                .foregroundColor(LeagueWikiColorTheme.secondary)
        }
        .frame(width: 40, height: 40)
        .clipShape(Circle())
        .scaleEffect(isPressed ? 0.9 : 1)
        .onTapGesture(count: 1) {
            self.isPressed.toggle()
            onClick()
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.1) {
                self.isPressed = false
            }
        }
    }
}

struct FavoriteButton_Previews: PreviewProvider {
    static var previews: some View {
        FavoriteButton(isFavorite: true) {}
    }
}
