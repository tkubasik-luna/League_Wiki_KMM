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
        let handle = Task {
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
        let handleRemote = Task {
            do {
                let sequence = try await asyncFunction(for:self.repository.getRandomTestData())
                value = sequence
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
}
