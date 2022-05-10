import Foundation

@objc public class StatusBarArea: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
