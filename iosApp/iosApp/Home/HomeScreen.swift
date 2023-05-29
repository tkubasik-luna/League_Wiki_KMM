import SwiftUI
import shared
import Combine
import Foundation
import KMPNativeCoroutinesCombine

struct HomeScreenView: View {
    @ObservedObject var viewModel: HomeViewModel = HomeViewModel()
    
    @State private var selection: String? = nil

    init() {
        viewModel.startCollectingRemote()
        viewModel.startCollectingFlow()
    }
    
    var body: some View {
        NavigationView {
            List(viewModel.value, id: \.id) { championInfo in
                NavigationLink {
                    ChampionDetailScreen(championId: championInfo.id)
                } label: {
                    ChampionListItemView(championInfo: championInfo) {
                        viewModel.toggleFavorite(id: championInfo.id)
                    }
                }
            }.navigationTitle("LeagueWiki")
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		HomeScreenView()
	}
}
