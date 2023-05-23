import SwiftUI
import shared
import Combine
import Foundation
import KMPNativeCoroutinesCombine

struct ContentView: View {
    @ObservedObject var viewModel: TestViewModel = TestViewModel()

    init() {
        viewModel.startCollectingRemote()
    }
    
    var body: some View {
        Text("result -> \(viewModel.value)")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
