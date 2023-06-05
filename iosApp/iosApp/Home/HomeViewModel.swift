//
//  TestViewModel.swift
//  iosApp
//
//  Created by Tom Kubasik on 23/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync

@MainActor
class HomeViewModel: ObservableObject {
    @Published var value: [UiChampionInfo] = []
    
    private let delegate = IosHomeViewModelDelegate()

    func startCollectingFlow() {
        _ = Task {
            do {
                let sequence = asyncSequence(for: self.delegate.championList)
                for try await value in sequence {
                    self.value = value
                }
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
    
    func toggleFavorite(id: String) {
        _ = Task {
            do {
                _ = try await asyncFunction(for:self.delegate.toggleFavorite(id: id))
                print("Success setFavorite")
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
    
    func startCollectingRemote() {
        _ = Task {
            do {
                _ = try await asyncFunction(for:self.delegate.refresh())
                print("Success refresh")
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
    
    init() {
        startCollectingRemote()
        startCollectingFlow()
    }
}
