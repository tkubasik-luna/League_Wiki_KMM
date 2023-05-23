//
//  TestViewModel.swift
//  iosApp
//
//  Created by Tom Kubasik on 23/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import Combine
import KMPNativeCoroutinesCombine
import KMPNativeCoroutinesAsync

@MainActor
class TestViewModel: ObservableObject {
    @Published var value = "_"
    
    private let repository = IosChampionRepository()

    func startCollectingFlow() {
        _ = Task {
            do {
                let sequence = asyncSequence(for: self.repository.testFlow)
                for try await value in sequence {
                    print("Got random value: \(value)")
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
                let championList = try await asyncFunction(for:self.repository.getChampionList())
                value = championList.first?.description() ?? "empty"
                
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
}
