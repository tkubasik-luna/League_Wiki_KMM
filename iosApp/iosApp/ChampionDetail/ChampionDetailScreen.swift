//
//  ChampionDetailScreen.swift
//  iosApp
//
//  Created by Tom Kubasik on 28/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ChampionDetailScreen: View {
    let championId: String
    
    @ObservedObject var viewModel: DetailViewModel
    
    init(championId: String) {
        self.championId = championId
        self.viewModel = DetailViewModel(championID: championId)
    }
    
    var body: some View {
        NavigationView {
            ScrollView {
                LazyVStack {
                    // Tags
                    Group {
                        HStack {
                            ForEach(viewModel.championDetail?.tags ?? [], id: \.self) { tag in
                                TagView(tag: tag)
                            }
                        }.frame(maxWidth: .infinity, alignment: .leading).padding(16)
                    }
                    // Lore
                    Group {
                        SectionTitle(title: "Lore")
                            .padding([.leading, .trailing], 16)
                        Text(viewModel.championDetail?.title ?? "")
                            .font(LeagueWikiTypography.textLarge)
                            .padding([.leading, .trailing], 16)
                            .padding([.bottom, .top], 8)
                            .frame(maxWidth: .infinity, alignment: .leading)
                        Text(viewModel.championDetail?.lore ?? "")
                            .font(LeagueWikiTypography.textBase)
                            .foregroundColor(LeagueWikiColorTheme.contentSecondary)
                            .padding([.leading, .trailing, .bottom], 16)
                    }
                    // Passive
                    Group {
                        SectionTitle(title: "Passive")
                            .padding([.leading, .trailing], 16)
                        SpellCell(
                            title: viewModel.championDetail?.passive.name ?? "",
                            imageUrl: viewModel.championDetail?.passive.imageUrl ?? "",
                            onClick: {}
                        ).padding([.leading, .trailing], 16)
                        Spacer().frame(height: 16)
                    }
                    // Spells
                    Group {
                        SectionTitle(title: "Spells")
                            .padding([.leading, .trailing], 16)
                        ForEach(viewModel.championDetail?.spells ?? [], id: \.name) { spell in
                            SpellCell(
                                title: spell.name,
                                imageUrl: spell.imageUrl,
                                onClick: {}
                            ).padding([.leading, .trailing], 16)
                        }
                    }
                    // Skins
                    Group {
                        SectionTitle(title: "Skins")
                            .padding([.leading, .trailing, .top], 16)
                        PageView(skins: viewModel.championDetail?.skins ?? [])
                    }
                }
            }
        }.navigationTitle(championId)
        .onAppear {
            viewModel.refreshFromRemote()
            viewModel.observeChampionDetail()
        }
    }
}

struct ChampionDetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        ChampionDetailScreen(championId: "Jhin")
    }
}

struct PageView: View {
    var skins: [UiSkin]
    var body: some View {
        TabView {
            ForEach(skins, id: \.name) { skin in
                SkinView(skin: skin)
            }
            .padding(.all, 16)
        }
        .tabViewStyle(.page)
        .indexViewStyle(.page(backgroundDisplayMode: .always))
        .frame(width: UIScreen.main.bounds.width, height: UIScreen.main.bounds.width)
    }
}
