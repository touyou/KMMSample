//
//  MainViewModel.swift
//  iosApp
//
//  Created by emp-mac-yosuke-fujii on 2022/05/27.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

class MainViewModel: ObservableObject {
    @Published var notes = [NoteSummary]()

    private let noteAPI = NoteAPI()

    func fetchData() async throws {
        try await noteAPI.fetchNotes { [weak self] newNotes in
            guard let self = self else { return }
            self.notes = newNotes
        }
    }
}
