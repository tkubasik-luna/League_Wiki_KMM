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
class TestViewModel: ObservableObject {
    @Published var value = "_"
    
    private let repository = IosChampionRepository()

    func startCollectingFlow() {
        _ = Task {
            do {
                let sequence = asyncSequence(for: self.repository.championListFlow)
                for try await value in sequence {
                    self.value = value.description
                }
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
    
    func startCollectingRemote() {
        _ = Task {
            do {
                _ = try await asyncFunction(for:self.repository.getChampionList())
                print("Success")
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
}
