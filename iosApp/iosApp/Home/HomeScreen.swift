import SwiftUI
import shared
import Combine
import Foundation
import KMPNativeCoroutinesCombine

struct HomeScreenView: View {
    @ObservedObject var viewModel: HomeViewModel = HomeViewModel()
    
    var body: some View {
        NavigationView {
            ScrollView {
                LazyVStack {
                    if(!viewModel.value.filter { champion in champion.isFavorite }.isEmpty) {
                        SectionTitle(title: "Favorites")
                        ScrollView(.horizontal, showsIndicators: false) {
                            LazyHStack(alignment: .center) {
                                ForEach(
                                    viewModel.value.filter { champion in champion.isFavorite },
                                    id: \.title
                                ) { championInfo in
                                    NavigationLink {
                                        ChampionDetailScreen(championId: championInfo.id)
                                    } label: {
                                        FavoriteChampionView(championInfo: championInfo) {
                                            viewModel.toggleFavorite(id: championInfo.id)
                                        }
                                    }
                                }
                        }
                        }
                        Spacer().frame(height: 16)
                        SectionTitle(title: "All")
                    }
                    ForEach(viewModel.value, id: \.id) { championInfo in
                        NavigationLink {
                            ChampionDetailScreen(championId: championInfo.id)
                        } label: {
                            ChampionListItemView(championInfo: championInfo) {
                                viewModel.toggleFavorite(id: championInfo.id)
                            }
                        }
                    }
                }.padding(16)
            }
            .navigationTitle("LeagueWiki")
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		HomeScreenView()
	}
}
