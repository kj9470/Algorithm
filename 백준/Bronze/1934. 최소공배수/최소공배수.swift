import Foundation

for _ in 0..<Int(readLine()!)! {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    var A = input[0]
    var B = input[1]
    
    let result = (A * B) / gcd(A, B)
    print(result)

}

func gcd(_ a: Int, _ b: Int) -> Int {
    if b == 0 {
        return a
    } else {
        return gcd(b, a % b)
    }
}