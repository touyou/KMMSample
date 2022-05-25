// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "KMMSampleSharedLib",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "KMMSampleSharedLib",
            targets: ["KMMSampleSharedLib"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "KMMSampleSharedLib",
            path: "./KMMSampleSharedLib.xcframework"
        ),
    ]
)
