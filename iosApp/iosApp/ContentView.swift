import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel = MainViewModel()

    var body: some View {
        LazyVStack {
            ForEach(0..<viewModel.notes.count, id: \.self) { index in
                Text(viewModel.notes[index].name)
            }
        }
        .onAppear {
            Task {
                try await viewModel.fetchData()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
