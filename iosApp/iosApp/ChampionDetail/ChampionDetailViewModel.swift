//
//  ChampionDetailViewModel.swift
//  iosApp
//
//  Created by Tom Kubasik on 04/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync

@MainActor
class DetailViewModel: ObservableObject {
    var championId: String
    
    @Published var championDetail: UiChampionDetail? = nil
    
    private let delegate = IosDetailViewModelDelegate()
    
    func observeChampionDetail() {
        _ = Task {
            do {
                let sequence = asyncSequence(for: self.delegate.championDetail(id: championId))
                for try await value in sequence {
                    self.championDetail = value
                }
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
    
    func toggleFavorite() {
        _ = Task {
            do {
                _ = try await asyncFunction(for:self.delegate.toggleFavorite(
                    id: championId,
                    isFavorite: championDetail?.isFavorite ?? false)
                )
                print("Success setFavorite")
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
    
    func refreshFromRemote() {
        _ = Task {
            do {
                _ = try await asyncFunction(for:self.delegate.refresh(id: championId))
                print("Success refresh")
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }
    
    init(championID: String) {
        self.championId = championID
    }
    
}
